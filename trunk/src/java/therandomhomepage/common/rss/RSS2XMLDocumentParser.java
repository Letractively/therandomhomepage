package therandomhomepage.common.rss;

import com.google.gwt.xml.client.*;

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

            Element element = document.getDocumentElement();
            XMLParser.removeWhitespace(element);

            NodeList items = element.getElementsByTagName("item");
            rssItems = new ArrayList();

            RSSItem rssItem = null;
            for (int i = 0; i < items.getLength(); i++) {
                rssItem = new RSSItem();
                Node item = items.item(i);
                rssItem.setTitle(getNodeTextValue(item, "title"));
                rssItem.setLink(getNodeTextValue(item, "link"));
                String desc = getNodeTextValue(item, "description");
                rssItem.setDesc(desc);
                rssItem.setGuid(getNodeTextValue(item, "guid"));
                rssItem.setMediaContentNode(getNodeByNodeName(item, "media:content"));
                rssItem.setMediaThumbnailNode(getNodeByNodeName(item, "media:thumbnail"));
                rssItems.add(rssItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rssItems;
    }

    public static RSSItem[] parseItemsAsArray(String xmlString) {
        RSSItem rssItems[] = null;
        try {
            Document document = XMLParser.parse(xmlString);

            Element element = document.getDocumentElement();
            XMLParser.removeWhitespace(element);

            NodeList items = element.getElementsByTagName("item");
            rssItems = new RSSItem[items.getLength()];

            RSSItem rssItem;
            for (int i = 0; i < items.getLength(); i++) {
                rssItem = new RSSItem();
                Node item = items.item(i);
                rssItem.setTitle(getNodeTextValue(item, "title"));
                rssItem.setLink(getNodeTextValue(item, "link"));
                String desc = getNodeTextValue(item, "description");
                rssItem.setDesc(desc);
                rssItem.setGuid(getNodeTextValue(item, "guid"));
                rssItem.setMediaContentNode(getNodeByNodeName(item, "media:content"));
                rssItem.setMediaThumbnailNode(getNodeByNodeName(item, "media:thumbnail"));
                rssItems[i] = rssItem;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rssItems;
    }

    private static String getNodeTextValue(Node node, String nodeName) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeName().equals(nodeName) && childNodes.item(i).getFirstChild() != null) {
                return childNodes.item(i).getFirstChild().getNodeValue().trim();
            }
        }
        return "";
    }

    private static Node getNodeByNodeName(Node node, String nodeName) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeName().equals(nodeName)) {
                return childNode;
            }
        }
        return null;
    }
}
