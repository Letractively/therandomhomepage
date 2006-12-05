package therandomhomepage.randomflickrclient;

import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.ui.HTML;
import therandomhomepage.common.AbstractPreferenceMap;
import therandomhomepage.common.RandomWidget;
import therandomhomepage.common.Randomizer;
import therandomhomepage.common.StringUtil;
import therandomhomepage.common.rss.RSS2XMLDocumentParser;
import therandomhomepage.common.rss.RSSItem;

import java.util.List;

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

            HTML snippet = new HTML(StringUtil.grep(desc, "<img", ">"));
            setContent(snippet);
            EffectsHelper.applyEffects(snippet, EffectsHelper.RANDOM);
        }
    }

    protected void handleResponse(String url, String responseText) {
        List rssItems = RSS2XMLDocumentParser.parse(responseText);
        cache.addToCache(url, rssItems);
        displayRandomItem(rssItems);
    }
}
