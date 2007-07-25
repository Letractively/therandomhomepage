package therandomhomepage.lookup.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.xml.client.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Jul 23, 2007
 * Time: 10:33:29 AM
 */
public class GData {

    private String cellPostURL = null;
    private String cellFeedURL = null;
    private String rowPostURL = null;

    public int rowCount = 0;

    public static final String SPREADSHEET_LISTING_URL = "http://spreadsheets.google.com/feeds/spreadsheets/private/full";
    private static Set entities = new HashSet();
    private static Set attributes = new HashSet();
    private static final int ENTITY_COL_NUM = 1;
    private static final int ATTRIBUTE_COL_NUM = 2;
    private static final int ANSWER_COL_NUM = 3;

    private static final String ENTRY_NODE_BEGIN = "<entry xmlns='http://www.w3.org/2005/Atom' xmlns:gsx='http://schemas.google.com/spreadsheets/2006/extended'>";
    private static final String ENTRY_NODE_END = "</entry>";
    private String listFeedURL;


    public GData() {
        Authentication.login(new LoginCallback() {
            public void onSuccess() {
                initialiseMetadata();
            }

            public void onFailure() {
                GWT.log("Unable to obtain authentication token. Could not proceed further !", new Exception());
            }
        });
    }

    private void initialiseMetadata() {
        GDataRequest builder = new GDataRequest(SPREADSHEET_LISTING_URL);
        builder.sendGetRequest(new SpreadSheetListingURLRequestCallback());
    }

    private void initMetadaFeed(String metadataFeedURL) {
        GDataRequest builder = new GDataRequest(metadataFeedURL);
        builder.sendGetRequest(new SpreadsheetMetadataFeedRequestCallback());
    }


    private static String parseURLWithHrefSuffix(Document document, String suffix) {

        NodeList list = document.getElementsByTagName("entry");

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            NodeList childNodes = node.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                if (childNodes.item(j).getNodeName().equals("link")) {
                    return getURLForLinkHrefSuffix(childNodes.item(j), suffix);
                }
            }

        }
        return null;
    }

    private static String getURLForLinkHrefSuffix(Node entryNode, String suffix) {
        NamedNodeMap attributes = entryNode.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node relAtt = attributes.getNamedItem("rel");
            if ((relAtt != null) && relAtt.getNodeValue().endsWith(suffix) && attributes.getNamedItem("href") != null) {
                return attributes.getNamedItem("href").getNodeValue();
            }
        }
        return null;
    }

    public void lookupAnswer(final String lookupText, final Label answerLabel) {

        String strArr[] = lookupText.split(";");
        System.out.println("strArr[0] = " + strArr[0]);
        System.out.println("strArr[1] = " + strArr[1]);

        rowCount++;

        String postData = ENTRY_NODE_BEGIN +
                "<gsx:entity>" + strArr[0] + "</gsx:entity> \n" +
                "<gsx:attribute>" + strArr[1] + "</gsx:attribute> \n" +
                ENTRY_NODE_END;
        System.out.println("postData = " + postData);

        GDataRequest builder = new GDataRequest(rowPostURL);

        builder.sendPostRequest(postData, new RequestCallback() {

            public void onResponseReceived(Request request, Response response) {
                System.out.println("AFTER POST response = " + response.getText());
                Document responseDoc = XMLParser.parse(response.getText());
                
                 updateFormula(answerLabel);

                answerLabel.setText(response.getText());
            }

            public void onError(Request request, Throwable exception) {
                exception.printStackTrace();
            }
        });
    }

    private void updateFormula(final Label answerLabel) {
        rowCount++;
        String postData = "<?xml version='1.0' encoding='UTF-8'?><entry xmlns='http://www.w3.org/2005/Atom' xmlns:gs='http://schemas.google.com/spreadsheets/2006'>"+
                "<gs:cell row=\""+rowCount+"\" col=\"3\" inputValue=\"=GoogleLookup(A"+rowCount+",B"+rowCount+")\" /></entry>";
        System.out.println("postData = " + postData);

        GDataRequest request = new GDataRequest(cellPostURL);
        request.sendPostRequest(postData, new RequestCallback() {

            public void onResponseReceived(Request request, Response response) {
                System.out.println("AFTER UPDATE FORMULA response.getText() = " + response.getText());
                answerLabel.setText(response.getText());
            }

            public void onError(Request request, Throwable exception) {
                exception.printStackTrace();
            }
        });

    }

    private class SpreadSheetListingURLRequestCallback extends GDataRequestCallback {

        public void onResponseReceived(Request request, Response response) {
            String metadataFeedURL = parseURLWithHrefSuffix(XMLParser.parse(response.getText()), "#worksheetsfeed");
            initMetadaFeed(metadataFeedURL);
        }
    }

    private class SpreadsheetMetadataFeedRequestCallback extends GDataRequestCallback {

        public void onResponseReceived(Request request, Response response) {
            System.out.println("Spreadsheet MetadataFeed response.getText() = " + response.getText());

            Document responseDoc = XMLParser.parse(response.getText());
            cellFeedURL = getFeedURLForLinkHrefPrefix(responseDoc, "#cellsfeed");

            if (cellFeedURL != null) {
                System.out.println("cellFeedURL = " + cellFeedURL);

                String readLookupValuesAndMetadataURL = cellFeedURL + "?min-col=" + ENTITY_COL_NUM + "&max-col=" + ENTITY_COL_NUM;
                System.out.println("readLookupValuesAndMetadataURL = " + readLookupValuesAndMetadataURL);
                GDataRequest readEntitiesRequest = new GDataRequest(readLookupValuesAndMetadataURL);
                readEntitiesRequest.sendGetRequest(new ReadLookupValuesAndMetadataCallback(entities));

                GDataRequest readAttributesRequest = new GDataRequest(cellFeedURL + "?min-col=" + ATTRIBUTE_COL_NUM + "&max-col=" + ATTRIBUTE_COL_NUM);
                readAttributesRequest.sendGetRequest(new ReadLookupValuesAndMetadataCallback(attributes));
            }

            listFeedURL = getFeedURLForLinkHrefPrefix(responseDoc, "#listfeed");
            if (listFeedURL != null) {
                System.out.println("responseDoc = " + listFeedURL);
                GDataRequest readListFeedRequest = new GDataRequest(listFeedURL + "?start-index=1&max-results=1");
                readListFeedRequest.sendGetRequest(new ReadListFeedMetadataCallback());
            }
        }

        private String getFeedURLForLinkHrefPrefix(Document responseDoc, String suffix) {
            NodeList linkNodes = responseDoc.getElementsByTagName("link");

            for (int i = 0; i < linkNodes.getLength(); i++) {
                Node linkNode = linkNodes.item(i);
                String url = getURLForLinkHrefSuffix(linkNode, suffix);
                if (url != null) {
                    return url;
                }
            }

            return null;
        }
    }

    private class ReadLookupValuesAndMetadataCallback extends ReadLookupValuesCallback {

        public ReadLookupValuesAndMetadataCallback(Set lookupValuesSet) {
            super(lookupValuesSet);
        }

        public void onResponseReceived(Request request, Response response) {
            super.onResponseReceived(request, response);

            System.out.println("response.getText() = " + response.getText());

            NodeList totalSearchResultNodes = responseDocument.getElementsByTagName("totalResults");

            if (totalSearchResultNodes != null && totalSearchResultNodes.getLength() > 0 && totalSearchResultNodes.item(0).getFirstChild() != null && rowCount < Integer.parseInt(totalSearchResultNodes.item(0).getFirstChild().getNodeValue())) {
                rowCount = Integer.parseInt(totalSearchResultNodes.item(0).getFirstChild().getNodeValue());
                System.out.println("rowCount = " + rowCount);
            }

            cellPostURL = getPostURL(responseDocument);
        }

    }

    private class ReadListFeedMetadataCallback extends GDataRequestCallback {

        public void onResponseReceived(Request request, Response response) {
            System.out.println("response.getText() = " + response.getText());

            Document responseDocument = XMLParser.parse(response.getText());
            rowPostURL = getPostURL(responseDocument);
            System.out.println("rowPostURL = " + rowPostURL);
        }
    }

    private String getPostURL(Document responseDocument) {
        NodeList idNodes = responseDocument.getElementsByTagName("id");

        if (idNodes != null && idNodes.getLength() > 0 && cellPostURL == null) {
            return idNodes.item(0).getFirstChild().getNodeValue();
        }
        return null;
    }

}
