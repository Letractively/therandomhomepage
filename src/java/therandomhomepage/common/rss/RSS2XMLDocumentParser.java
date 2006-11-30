package therandomhomepage.common.rss;

import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Nov 29, 2006
 * Time: 3:54:22 PM
 */
public class RSS2XMLDocumentParser {

    public static List parse(String xmlString) {
        List rssItems = null;
        try {
            Document document = XMLParser.parse(xmlString);

            NodeList items = document.getElementsByTagName("item");
            rssItems = new ArrayList();

            RSSItem rssItem = null;
            for (int i = 0; i < items.getLength(); i++) {
                Node item = items.item(i);
                NodeList childNodes = item.getChildNodes();
                rssItem = new RSSItem();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node childElement = childNodes.item(j);
                    if (childElement.getNodeName().equals("title")) {
                        rssItem.setTitle(childElement.getNodeValue());
                    } else if (childElement.getNodeName().equals("description")) {
                        rssItem.setDesc(childElement.getNodeValue());
                    } else if (childElement.getNodeName().equals("guid")) {
                        rssItem.setGuid(childElement.getNodeValue());
                    } else if (childElement.getNodeName().equals("media:content")) {
                        rssItem.setMediaContentNode(childElement);
                    } else if (childElement.getNodeName().equals("media:text")) {
                        rssItem.setMediaTextNode(childElement);
                    } else if (childElement.getNodeName().equals("media:thumbnail ")) {
                        rssItem.setMediaThumbnailNode(childElement);
                    }
                }
                rssItems.add(rssItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rssItems;
    }
}
