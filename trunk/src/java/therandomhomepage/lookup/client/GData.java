package therandomhomepage.lookup.client;

import com.google.gwt.http.client.*;
import com.google.gwt.xml.client.*;

import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Jul 23, 2007
 * Time: 10:33:29 AM
 */
public class GData {

    public void showMetafeed(){
        String url = "http://spreadsheets.google.com/feeds/spreadsheets/private/full";
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
        try {
            System.out.println("Setting authorization auth = "+Authentication.getToken());
            builder.setHeader("Authorization","GoogleLogin auth="+Authentication.getToken());
            builder.sendRequest(null, new RequestCallback() {
                public void onError(Request request, Throwable exception) {
                    exception.printStackTrace();
                }

                public void onResponseReceived(Request request, Response response) {
                    System.out.println("response = " + response.getText());
                    Document document = XMLParser.parse(response.getText());

                    NodeList list = document.getElementsByTagName("entry");

                    for(int i=0; i < list.getLength(); i++){
                        Node node = list.item(i);

                        NodeList childNodes = node.getChildNodes();
                        for(int j=0; j < childNodes.getLength(); j++){
                            Node childNode = childNodes.item(j);
                            if (childNode.getNodeName().equals("link")){
                                String worksheetFeedURL = getWorksheetFeedURL(childNode);
                                System.out.println("worksheetFeedURL = " + worksheetFeedURL);
                            }
                        }
                    }

                }
            });
        } catch (RequestException e) {
            e.printStackTrace();
        }
    }

    private String getWorksheetFeedURL(Node entryNode) {

        NamedNodeMap attributes = entryNode.getAttributes();
        for(int i=0; i < attributes.getLength(); i++){
            Node relAtt = attributes.getNamedItem("rel");
            if ((relAtt != null) && relAtt.getNodeValue().endsWith("#worksheetsfeed") && attributes.getNamedItem("href") != null){
                return attributes.getNamedItem("href").getNodeValue();
            }
        }
        return null;
    }

}
