package therandomhomepage.lookup.client;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;
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

    public static final String SPREADSHEET_LISTING_URL = "http://spreadsheets.google.com/feeds/spreadsheets/private/full";
    private static Set entities = new HashSet();
    private static Set attributes = new HashSet();

    public static void init() {
        Authentication.login(new LoginCallback() {
            public void onSuccess() {
                GDataRequestBuilder builder = new GDataRequestBuilder(SPREADSHEET_LISTING_URL);
                builder.sendRequest(new SpreadSheetListingURLRequestCallback());
            }

            public void onFailure() {
                // do nothing
            }
        });
    }

    private static void initMetadaFeed() {
        GDataRequestBuilder builder = new GDataRequestBuilder(metadataFeedURL);
        builder.sendRequest(new SpreadsheetMetadataFeedRequestCallback());
    }

    private static void initEntitiesAndAttributes(Document document) {

    }

    private static String parseURLWithHrefSuffix(String response, String suffix) {
        Document document = XMLParser.parse(response);
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

    private static class SpreadSheetListingURLRequestCallback extends GDataRequestCallback {

        public void onResponseReceived(Request request, Response response) {
            metadataFeedURL = parseURLWithHrefSuffix(response.getText(), "#worksheetsfeed");
            initMetadaFeed();
        }
    }

    private static class SpreadsheetMetadataFeedRequestCallback extends GDataRequestCallback {

        public void onResponseReceived(Request request, Response response) {
            System.out.println("response.getText() = " + response.getText());
            String listFeedURL = parseURLWithHrefSuffix(response.getText(), "#listfeed");
            GDataRequestBuilder builder = new GDataRequestBuilder(listFeedURL);
            builder.sendRequest(new ListFeedRequestCallback());
        }
    }

    private static class ListFeedRequestCallback extends GDataRequestCallback {

        public void onResponseReceived(Request request, Response response) {
            System.out.println("ListFeed response = " + response.getText());
        }
    }
}
