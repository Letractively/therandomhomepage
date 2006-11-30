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

        String url = "/php/ajaxProxy.php?url="+URL.encodeComponent("http://www.flickr.com/services/feeds/photos_public.gne?tags=colorful&format=rss_200");

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
//            RSSItemLink itemLink = new RSSItemLink(randomItem);
            Image image = randomItem.getMedia().getContent();
            table.setWidget(1, 0, image);
            table.getFlexCellFormatter().setColSpan(1, 0, 2);
            table.getFlexCellFormatter().setVerticalAlignment(0, 1, HasVerticalAlignment.ALIGN_TOP);
//            HTML descWidget = new HTML(randomItem.getDesc());
            table.setWidget(2, 0, new Label(randomItem.getTitle()));
            table.getFlexCellFormatter().setColSpan(2, 0, 2);
            EffectsHelper.applyEffects(image,EffectsHelper.RANDOM);
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
