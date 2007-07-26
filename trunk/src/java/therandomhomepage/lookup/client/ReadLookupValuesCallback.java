package therandomhomepage.lookup.client;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.XMLParser;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.Node;

import java.util.Set;
import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Jul 24, 2007
 * Time: 4:17:13 PM
 */
public class ReadLookupValuesCallback extends GDataRequestCallback{

    private Set lookupValuesSet = new HashSet();
    protected Document responseDocument ;

    public ReadLookupValuesCallback(Set lookupValuesSet) {
        this.lookupValuesSet = lookupValuesSet;
    }

    public void onResponseReceived(Request request, Response response) {
        System.out.println("ReadLookupValuesCallback response.getText() = " + response.getText());
        responseDocument = XMLParser.parse(response.getText());
        NodeList entryNodes = responseDocument.getElementsByTagName("entry");

        for(int i=0; i < entryNodes.getLength(); i++){
            Node entryNode = entryNodes.item(i);
            NodeList entryNodeChilds = entryNode.getChildNodes();
            for(int j=0; j < entryNodeChilds.getLength(); j++){
                if (entryNodeChilds.item(j).getNodeName().equals("content")){
                    String lookupValue = entryNodeChilds.item(j).getFirstChild().getNodeValue();
                    System.out.println("lookupValue = " + lookupValue);
                    lookupValuesSet.add(lookupValue);
                }
            }
        }

    }

    public void processResponse(Response response) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
