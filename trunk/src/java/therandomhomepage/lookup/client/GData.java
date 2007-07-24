package therandomhomepage.lookup.client;

import com.google.gwt.http.client.*;
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

    public static String metadataFeedURL = null;
    public static String postURL = null;
    public static String cellFeedURL = null;
    public static int rowCount = 0;

    public static final String SPREADSHEET_LISTING_URL = "http://spreadsheets.google.com/feeds/spreadsheets/private/full";
    private static Set entities = new HashSet();
    private static Set attributes = new HashSet();
    private static final String ENTRY_NODE_BEGIN = "<entry xmlns='http://www.w3.org/2005/Atom' xmlns:gsx='http://schemas.google.com/spreadsheets/2006/extended'>";
    private static final String ENTRY_NODE_END = "</entry>";


    public static void init() {
        Authentication.login(new LoginCallback() {
            public void onSuccess() {
                GDataRequest builder = new GDataRequest(SPREADSHEET_LISTING_URL);
                builder.sendGetRequest(new SpreadSheetListingURLRequestCallback());
            }

            public void onFailure() {
                // do nothing
            }
        });
    }

    private static void initMetadaFeed() {
        GDataRequest builder = new GDataRequest(metadataFeedURL);
        builder.sendGetRequest(new SpreadsheetMetadataFeedRequestCallback());
    }

    private static void initEntitiesAndAttributes(Document document) {

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

    public static void lookupAnswer(final String lookupText, final Label answerLabel) {

        String strArr[] = lookupText.split(";");
        System.out.println("strArr[0] = " + strArr[0]);
        System.out.println("strArr[1] = " + strArr[1]);


        String postData = ENTRY_NODE_BEGIN +
                "<gsx:entity>"+strArr[0]+"</gsx:entity> \n" +
                "<gsx:attribute>"+strArr[1]+"</gsx:attribute> \n" +
                "<gsx:answer>=GoogleLookup(A,B3)</gsx:answer> \n" +
                ENTRY_NODE_END;
        System.out.println("postData = " + postData);

        GDataRequest builder = new GDataRequest(postURL);

            builder.sendPostRequest(postData, new RequestCallback() {

                public void onResponseReceived(Request request, Response response) {
                    System.out.println("AFTER POST response = " + response.getText());
                    Document responseDoc = XMLParser.parse(response.getText());
                    NodeList linkNodes = responseDoc.getElementsByTagName("link");

                    if (linkNodes != null && linkNodes.getLength() > 0) {

                        for(int i=0; i < linkNodes.getLength(); i++){
                            String editURL = getURLForLinkHrefSuffix(linkNodes.item(i),"edit");
                            if (editURL != null) {
                                System.out.println("editURL = " + editURL);
//                                updateFormula(editURL,answerLabel);
                            }
                        }                    }
                    answerLabel.setText(response.getText());
                }

                public void onError(Request request, Throwable exception) {
                    exception.printStackTrace();
                }
            });
    }

    private static void updateFormula(String editURL, final Label answerLabel) {
        rowCount++;
        String postData = ENTRY_NODE_BEGIN +
                "  <gsx:answer>=GoogleLookup(A"+rowCount+",B3)</gsx:answer>"+
                ENTRY_NODE_END;

        GDataRequest request = new GDataRequest(editURL);
        request.sendPostRequest(postData,new RequestCallback(){

            public void onResponseReceived(Request request, Response response) {
                System.out.println("AFTER UPDATE FORMULA response.getText() = " + response.getText());
                answerLabel.setText(response.getText());
            }

            public void onError(Request request, Throwable exception) {
                exception.printStackTrace();
            }
        });

    }

    private static class SpreadSheetListingURLRequestCallback extends GDataRequestCallback {

        public void onResponseReceived(Request request, Response response) {
            metadataFeedURL = parseURLWithHrefSuffix(XMLParser.parse(response.getText()), "#worksheetsfeed");
            initMetadaFeed();
        }
    }

    private static class SpreadsheetMetadataFeedRequestCallback extends GDataRequestCallback {

        public void onResponseReceived(Request request, Response response) {
            System.out.println("Spreadsheet MetadataFeed response.getText() = " + response.getText());
            String listFeedURL = parseURLWithHrefSuffix(XMLParser.parse(response.getText()), "#listfeed");
            System.out.println("listFeedURL = " + listFeedURL);
            cellFeedURL = parseURLWithHrefSuffix(XMLParser.parse(response.getText()), "#cellsfeed");


            GDataRequest builder = new GDataRequest(listFeedURL);
            builder.sendGetRequest(new ListFeedRequestCallback());
        }
    }

    private static class ListFeedRequestCallback extends GDataRequestCallback {

        public void onResponseReceived(Request request, Response response) {
            System.out.println("ListFeed response = " + response.getText());
            Document document = XMLParser.parse(response.getText());
            postURL = parseURLFromLinkHrefSuffix(document, "#post");
            System.out.println("postURL = " + postURL);
            NodeList list = document.getElementsByTagName("totalResults");
            if (list != null && list.getLength() > 0){
                rowCount = Integer.parseInt(list.item(0).getFirstChild().getNodeValue());
                System.out.println("rowCount = " + rowCount);
            }
            initEntitiesAndAttributes(document);
        }

        private String parseURLFromLinkHrefSuffix(Document document, String suffix) {
            NodeList childNodes = document.getElementsByTagName("link");
            for (int j = 0; j < childNodes.getLength(); j++) {
                if (getURLForLinkHrefSuffix(childNodes.item(j), suffix) != null) {
                    return getURLForLinkHrefSuffix(childNodes.item(j), suffix);
                }
            }
            return null;
        }
    }
}
