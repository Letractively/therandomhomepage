package therandomhomepage.randomflickrclient;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;
import therandomhomepage.common.Randomizer;
import therandomhomepage.common.StringUtil;
import therandomhomepage.common.rss.RSSItem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 4, 2006
 * Time: 2:33:51 PM
 */
public class LightboxWidget extends Widget {

    public static int anchorId = 0;
    private List rssItems;
    int prevIdx = -1;

    public LightboxWidget(List rssItems, String groupName) {
        this.rssItems = rssItems;
        List imageList = getImageList(rssItems);

        Element divElement = DOM.createDiv();
        DOM.setAttribute(divElement, "id", "divLightBox");

        for (int i = 0; i < imageList.size(); i++) {
            Image image1 = (Image) imageList.get(i);
            Element anchorElement = DOM.createAnchor();
            DOM.setAttribute(anchorElement, "href", image1.getUrl());
            DOM.setIntAttribute(anchorElement, "id", anchorId);
            DOM.setAttribute(anchorElement, "title", image1.getTitle());
            DOM.setAttribute(anchorElement, "rel", "lightbox[" + groupName + "]");
            UIObject.setVisible(anchorElement, false);
            DOM.appendChild(anchorElement, image1.getElement());
            DOM.appendChild(divElement, anchorElement);
            anchorId++;
        }
        setElement(divElement);
    }

    protected void onLoad() {
        init();
    }

    public RSSItem showRandomImage() {
        if (prevIdx > -1) {
            toggleAnchor(prevIdx, false);
        }
        int randomIdx = Randomizer.getRandomIdx(rssItems);
        prevIdx = randomIdx;
        toggleAnchor(randomIdx, true);
        return (RSSItem) rssItems.get(randomIdx);
    }

    private void toggleAnchor(int randomIdx, boolean visible) {
        Element anchorElement = DOM.getElementById(Integer.toString(randomIdx));
        UIObject.setVisible(anchorElement, visible);
    }

    private List getImageList(List rssItems) {
        List imageList = new ArrayList();
        for (Iterator iterator = rssItems.iterator(); iterator.hasNext();) {
            RSSItem rssItem = (RSSItem) iterator.next();
            imageList.add(getSnippetImage(rssItem.getDesc()));
        }
        return imageList;
    }

    public static native void init() /*-{
        $wnd.initLightbox();
    }-*/;

    private Image getSnippetImage(String desc) {
        if (desc != null) {
            String imgNode = StringUtil.grep(desc, "<IMG", ">");
            System.out.println("imgNode = " + imgNode);
            if (imgNode != null) {
                Element imgElement = DOM.createImg();
                DOM.setInnerHTML(imgElement,imgNode);
                String src = DOM.getAttribute(imgElement,"src");
                return new Image(src);
            }
        }
        return null;
    }

}
