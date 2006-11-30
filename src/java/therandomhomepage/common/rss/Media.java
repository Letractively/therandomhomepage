package therandomhomepage.common.rss;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.xml.client.NamedNodeMap;
import com.google.gwt.xml.client.Node;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Nov 29, 2006
 * Time: 4:10:41 PM
 */
public class Media {
    private Image content;
    private HTML text;
    private Image thumbnail;

    public void setMediaContentNode(Node mediaContentNode) {
        content = parseImage(mediaContentNode);
    }

    public void setMediaTextNode(Node mediaTextNode) {
        if (mediaTextNode != null) {
            if (mediaTextNode.getNodeValue() != null) {
                text = new HTML(mediaTextNode.getNodeValue());
            }
        }
    }

    public void setMediaThumbnailNode(Node mediaThumbnailNode) {
        thumbnail = parseImage(mediaThumbnailNode);
    }


    private Image parseImage(Node imageNode) {
        Image image = null;
        if (imageNode != null) {
            NamedNodeMap attributes = imageNode.getAttributes();
            if (attributes != null) {
                image = new Image(attributes.getNamedItem("url").getNodeValue());
                //maybe this is redundant
                image.setHeight(attributes.getNamedItem("height").getNodeValue());
                image.setWidth(attributes.getNamedItem("width").getNodeValue());
            }
        }
        return image;
    }

    public Image getContent() {
        return content;
    }

    public HTML getText() {
        return text;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public String toString() {
        return "Media{" +
                "content=" + content +
                ", text=" + text +
                ", thumbnail=" + thumbnail +
                '}';
    }
}
