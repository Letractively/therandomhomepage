package therandomhomepage.randomflickrclient;

import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ResponseTextHandler;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import org.gwtwidgets.client.ui.LightBox;
import therandomhomepage.common.*;
import therandomhomepage.common.rss.RSS2XMLDocumentParser;
import therandomhomepage.common.rss.RSSItem;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

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
        table.getCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
        table.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);
    }

    protected void retrieveRandomItem() {

        String url = "/php/xmlProxy.php?url=" + URL.encodeComponent("http://www.flickr.com/services/feeds/photos_public.gne?tags=colorful&format=rss_200");

        if (cache.getFromCache(url) == null) {
            if (!HttpRequestUtil.sendAsyncGetRequest(url, new MyResponseHandler(url))) {
                showError();
            }
        } else {
            List itemList = cache.getFromCache(url);
            displayRandomItem(itemList);
        }
    }

    private void displayRandomItem(List rssItems) {
        if (rssItems != null && rssItems.size() > 0) {

            LightboxWidget.clearWidget();
            LightboxWidget widget = new LightboxWidget(rssItems,"colorful");
            table.setWidget(1, 0, widget);
            LightboxWidget.init();

            RSSItem randomItem = widget.toggleRandomImage();
            table.setWidget(0, 0, new Label(randomItem.getTitle()));
            table.getFlexCellFormatter().setColSpan(1, 0, 2);
            table.getFlexCellFormatter().setVerticalAlignment(0, 1, HasVerticalAlignment.ALIGN_TOP);

            Widget image = table.getWidget(1, 0);
            EffectsHelper.applyEffects(image, EffectsHelper.RANDOM);
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
                displayRandomItem(rssItems);
            }
        }
    }
}
