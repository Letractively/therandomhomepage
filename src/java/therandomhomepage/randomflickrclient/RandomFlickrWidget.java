package therandomhomepage.randomflickrclient;

import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ResponseTextHandler;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.*;
import org.gwtwidgets.client.ui.LightBox;
import therandomhomepage.common.HttpRequestUtil;
import therandomhomepage.common.RSSCache;
import therandomhomepage.common.RandomWidget;
import therandomhomepage.common.Randomizer;
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
            RSSItem rssItem = (RSSItem) Randomizer.getRandomItem(itemList);
            displayRandomItem(rssItem);
        }
    }

    private void displayRandomItem(RSSItem randomItem) {
        if (randomItem != null) {
            table.setWidget(0, 0, new Label(randomItem.getTitle()));
            HTML snippet = new HTML(randomItem.getDesc());
            HTML lightboxHTML = extractImage(snippet);
            snippet.addClickListener(new LightBoxListener(randomItem.getMedia().getContent()));
            table.setWidget(1, 0, snippet);
            table.getFlexCellFormatter().setColSpan(1, 0, 2);
            table.getFlexCellFormatter().setVerticalAlignment(0, 1, HasVerticalAlignment.ALIGN_TOP);
            EffectsHelper.applyEffects(snippet, EffectsHelper.RANDOM);
        }
    }

    private HTML extractImage(HTML snippet) {
        String rawHTML = DOM.getInnerHTML(snippet.getElement());
        System.out.println("rawHTML = " + rawHTML);
        String imageTag = grep(rawHTML,"<img",">");
        if (imageTag != null) {
            String url = grep(imageTag,"src=","\"");
            System.out.println("url = " + url);
            String html = "<A HREF="+url+" rel=\"lightbox\">"+imageTag+"</A>";
            return new HTML(html);
        }
        return null;
    }

//    private void displayRandomItem(RSSItem randomItem) {
//        if (randomItem != null) {
//            table.setWidget(0, 0, new Label(randomItem.getTitle()));
//            DOM.getInnerHTML(randomItem.getMedia().getThumbnail().getElement());
//            ImageLightBox snippet = new ImageLightBox(randomItem.getMedia().getThumbnail());
////            snippet.addClickListener(new LightBoxListener(randomItem.getMedia().getContent()));
//            table.setWidget(1, 0, snippet);
//            table.getFlexCellFormatter().setColSpan(1, 0, 2);
//            table.getFlexCellFormatter().setVerticalAlignment(0, 1, HasVerticalAlignment.ALIGN_TOP);
//            EffectsHelper.applyEffects(snippet,EffectsHelper.RANDOM);
//        }
//    }

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

    private class LightBoxListener implements ClickListener {
        private Image image;
        private int reduceByPerc = 50;

        public LightBoxListener(Image image) {
            this.image = image;
            String height = DOM.getStyleAttribute(this.image.getElement(), "height");
            String width = DOM.getStyleAttribute(this.image.getElement(), "width");
            System.out.println("height & width = " + height + ", " + width);
        }

        private String reduceSize(int offsetHeight) {
            return Integer.toString((offsetHeight * 50) / 100);
        }


        public void onClick(Widget sender) {
            PopupPanel panel = new PopupPanel(true);
            panel.setWidget(image);
            LightBox lightBox = new LightBox(panel);
            lightBox.show();
        }
    }

    public static String grep(String actualString, String startsWith, String endsWith) {
        if (actualString != null) {
            int startIdx = actualString.indexOf(startsWith.toUpperCase()) < 0  ? actualString.indexOf(startsWith.toLowerCase()) : actualString.indexOf(startsWith.toUpperCase()) ;
            int endIdx = actualString.indexOf(endsWith.toUpperCase(),startIdx) < 0  ? actualString.indexOf(endsWith.toLowerCase(),startIdx) : actualString.indexOf(endsWith.toUpperCase(),startIdx);
            if (startIdx > -1 && endIdx > -1) {
                return actualString.substring(startIdx, endIdx + 1);
            }
        }
        return null;
    }
}
