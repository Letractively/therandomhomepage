package therandomhomepage.randomflickrclient;

import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.ResponseTextHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Image;
import therandomhomepage.common.*;
import therandomhomepage.common.rss.JSON2RSSParser;
import therandomhomepage.common.rss.RSSItem;
import therandomhomepage.common.rss.RSS2XMLDocumentParser;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Aug 6, 2006
 * Time: 12:15:23 PM
 */
public class RandomFlickrWidget extends RandomWidget {
    private static RSSCache cache = new RSSCache();

    public RandomFlickrWidget(String header) {
        super(header);
    }

    protected void retrieveRandomItem() {

        String url = "/php/xmlProxy.php?url="+URL.encodeComponent("http://www.flickr.com/services/feeds/photos_public.gne?tags=colorful&format=rss_200");

        if (cache.getFromCache(url) == null) {
            if (!HttpRequestUtil.sendAsyncGetRequest(url, new MyResponseHandler(url))) {
                showError();
            }
        } else {
            List itemList = cache.getFromCache(url);
            RSSItem rssItem = (RSSItem) Randomizer.getRandomItem(itemList);
            displayRandomItem(rssItem);
        }
    }

    private void displayRandomItem(RSSItem randomItem) {
        if (randomItem != null) {
            System.out.println("randomItem = " + randomItem);
            table.setWidget(0, 0, new Label(randomItem.getTitle()));
            HTML snippet = randomItem.getMedia().getText();
            table.setWidget(1, 0, snippet);
            table.getFlexCellFormatter().setColSpan(1, 0, 2);
            table.getFlexCellFormatter().setVerticalAlignment(0, 1, HasVerticalAlignment.ALIGN_TOP);
            EffectsHelper.applyEffects(snippet,EffectsHelper.RANDOM);
        }
    }

    private void showError() {
        Label errorLabel = new Label(ERROR_MESSAGE);
        //noinspection GWTStyleCheck
        errorLabel.setStyleName("randomWidgetHeader-errorMessage");
        table.setWidget(1, 0, errorLabel);
    }

    private class MyResponseHandler implements ResponseTextHandler {
        private String url;

        public MyResponseHandler(String url) {
            this.url = url;
        }

        public void onCompletion(String responseText) {
            if (!HttpRequestUtil.isErrorResponse(responseText)) {
                List rssItems = RSS2XMLDocumentParser.parse(responseText);
                cache.addToCache(url, rssItems);
                RSSItem randomItem = (RSSItem) Randomizer.getRandomItem(rssItems);
                displayRandomItem(randomItem);
            }
        }
    }
}
