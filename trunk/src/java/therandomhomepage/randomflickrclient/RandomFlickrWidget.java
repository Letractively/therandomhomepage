package therandomhomepage.randomflickrclient;

import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import therandomhomepage.common.AbstractPreferenceMap;
import therandomhomepage.common.RandomWidget;
import therandomhomepage.common.Randomizer;
import therandomhomepage.common.StringUtil;
import therandomhomepage.common.rss.RSS2XMLDocumentParser;
import therandomhomepage.common.rss.RSSItem;

import java.util.List;

import org.gwtwidgets.client.ui.LightBox;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Aug 6, 2006
 * Time: 12:15:23 PM
 */
public class RandomFlickrWidget extends RandomWidget {

    public RandomFlickrWidget(AbstractPreferenceMap preferenceMap) {
        super(preferenceMap);
    }

    public String getFeedURL() {
        return "/php/xmlProxy.php?url=" + URL.encodeComponent("http://www.flickr.com/services/feeds/photos_public.gne?tags=colorful&format=rss_200");
    }

    protected void displayRandomItem(List rssItems) {
        if (rssItems != null && rssItems.size() > 0) {
            RSSItem randomRSSItem = (RSSItem) Randomizer.getRandomItem(rssItems);
            setHeader(randomRSSItem.getTitle());

            RandomFlickrPreferenceMap prefMap = (RandomFlickrPreferenceMap) preferenceMap;
            String desc = randomRSSItem.getDesc();
            if (!prefMap.isSlideshow()) {
                addArrow();
            } else {
                addStarter();
                addStopper();
            }

//            HTML snippet = new HTML("<a href='"+randomRSSItem.getMedia().getContent().getUrl()+"' target='_new'>"+StringUtil.grep(desc, "<img", ">")+"</a>");
            HTML snippet = new HTML("<a href='"+randomRSSItem.getMedia().getContent().getUrl()+"' rel='lightbox'>"+StringUtil.grep(desc, "<img", ">")+"</a>");
            setContent(snippet);
            callLightbox();
            EffectsHelper.applyEffects(snippet, prefMap.getTransitionEffectConstant());
        }
    }

    protected void handleResponse(String url, String responseText) {
        List rssItems = RSS2XMLDocumentParser.parse(responseText);
        cache.addToCache(url, rssItems);
        displayRandomItem(rssItems);
    }

    private static native void callLightbox() /*-{
        alert("calling initLightbox function directly ");
        if ($wnd.initLightbox()) {
            $wnd.initLightbox();
        }
        else {
            alert("callLightbox function not found");
        }
    }-*/;

    private class ImageClickListener implements ClickListener {
        private RSSItem randomRSSItem;
        private RandomFlickrPreferenceMap prefMap;

        public ImageClickListener(RSSItem randomRSSItem, RandomFlickrPreferenceMap prefMap) {
            this.randomRSSItem = randomRSSItem;
            this.prefMap = prefMap;
        }

        public void onClick(Widget sender) {
            switch(prefMap.getOnClickConstant()){
                case RandomFlickrPreferenceMap.OPEN_ORIGINAL_IMAGE:
                    //Window.open(randomRSSItem.getMedia().getContent().getUrl(),randomRSSItem.getTitle(),"menubar=no,location=no,resizable=yes,scrollbars=yes,status=no");
                    PopupPanel panel = new PopupPanel(true);
                    panel.setWidget(randomRSSItem.getMedia().getContent());
                    LightBox lightBox = new LightBox(panel);
                    lightBox.show();
                    break;
            }

        }
    }
}
