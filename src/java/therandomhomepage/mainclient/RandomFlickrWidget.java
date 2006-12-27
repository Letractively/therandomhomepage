package therandomhomepage.mainclient;

import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.ui.Image;
import therandomhomepage.common.RandomWidget;
import therandomhomepage.common.Randomizer;
import therandomhomepage.common.rss.RSS2XMLDocumentParser;
import therandomhomepage.common.rss.RSSItem;
import therandomhomepage.widgets.client.LightboxImage;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Aug 6, 2006
 * Time: 12:15:23 PM
 */
public class RandomFlickrWidget extends RandomWidget {


    private LightboxImage lightbox;


    public String getFeedURL() {
        return "/php/xmlProxy.php?url=" + URL.encodeComponent("http://www.flickr.com/services/feeds/photos_public.gne?tags=colorful&format=rss_200");
    }

    protected void displayRandomItem(List rssItems) {
        if (rssItems != null && rssItems.size() > 0) {
            if (lightbox == null) {
                lightbox = new LightboxImage(getImages(rssItems));
                setContent(lightbox);
            }

            int randomIdx = Randomizer.getRandomIdx(rssItems);
            lightbox.toggleImage(randomIdx);
        }
    }

    private Image[] getImages(List rssItems) {
        Image[] images = new Image[rssItems.size()];
        for (int i = 0; i < rssItems.size(); i++) {
            RSSItem rssItem = (RSSItem) rssItems.get(i);
            images[i] = rssItem.getMedia().getContent();
            images[i].setStyleName("randomFlickrthumbnailImage");
        }
        return images;
    }


    protected void handleResponse(String url, String responseText) {
        List rssItems = RSS2XMLDocumentParser.parse(responseText);
        cache.addToCache(url, rssItems);
        displayRandomItem(rssItems);
    }
}
