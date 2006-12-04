package therandomhomepage.randomflickrclient;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.DOM;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import therandomhomepage.common.Randomizer;
import therandomhomepage.common.rss.RSSItem;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 4, 2006
 * Time: 2:33:51 PM
 */
public class LightboxWidget extends Widget {

    private static int anchorId = 0;
    private List rssItems;


    public LightboxWidget(List rssItems,String groupName){
        this.rssItems = rssItems;
        List imageList = getImageList(rssItems);
        Element divElement = DOM.createDiv();
        DOM.setAttribute(divElement,"id","divLightBox");

        for (int i = 0; i < imageList.size(); i++) {
            Image image1 = (Image) imageList.get(i);
            Element anchorElement = DOM.createAnchor();
            DOM.setAttribute(anchorElement,"href",image1.getUrl());
            DOM.setIntAttribute(anchorElement,"id",anchorId);
            DOM.setAttribute(anchorElement,"title",image1.getTitle());
            DOM.setAttribute(anchorElement,"rel","lightbox["+groupName+"]");
            UIObject.setVisible(anchorElement,false);
            DOM.appendChild(anchorElement,image1.getElement());
            DOM.appendChild(divElement,anchorElement);
            anchorId ++;
        }
        setElement(divElement);
    }

    public RSSItem toggleRandomImage(){
        int randomIdx = Randomizer.getRandomIdx(rssItems);
        Element anchorElement = DOM.getElementById(Integer.toString(randomIdx));
        UIObject.setVisible(anchorElement,true);
        return (RSSItem) rssItems.get(randomIdx);
    }

    private List getImageList(List rssItems) {
        List imageList = new ArrayList();
        for (Iterator iterator = rssItems.iterator(); iterator.hasNext();) {
            RSSItem rssItem = (RSSItem) iterator.next();
            imageList.add(rssItem.getMedia().getContent());
        }
        return imageList;
    }

    public static native void init() /*-{
        $wnd.initLightbox();
    }-*/;

    public static void clearWidget(){
        Element lightBoxElement = DOM.getElementById("divLightBox");
        if (lightBoxElement != null) {
            String innerHTML = DOM.getInnerHTML(lightBoxElement);
            System.out.println("innerHTML = " + innerHTML);
            DOM.setInnerHTML(lightBoxElement,"");
        }
        else {
            System.out.println("divLightBox doesn't exist !!!");
        }
    }
}
