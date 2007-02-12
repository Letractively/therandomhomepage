package therandomhomepage.mainclient;

import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ResponseTextHandler;
import com.google.gwt.user.client.ui.*;
import therandomhomepage.common.HttpRequestUtil;
import therandomhomepage.common.Randomizer;
import therandomhomepage.common.StringUtil;
import therandomhomepage.common.rss.JSON2RSSParser;
import therandomhomepage.common.rss.RSSItem;
import therandomhomepage.common.rss.RSS2XMLDocumentParser;
import therandomhomepage.widgets.client.LightboxImage;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Aug 6, 2006
 * Time: 12:15:23 PM
 */
public class RandomFlickrWidget extends AbstractRandomGadget {

    private LightboxImage lightbox;
    private Label randomFlickrImageTitle = new Label();
    private int prevIdx = -1;
    private RSSItem rssItems[] = null;

    private String[] flickrTags = {"art", "colorful", "travel", "autumn", "water", "nature", "sunset", "tree"};

    protected static final String ERROR_MESSAGE = "Error retrieving content !. Please try later...";


    public RandomFlickrWidget(String header, String googleGadgetURL, String netvibesModuleURL, int width, int height) {
        super(header, googleGadgetURL, netvibesModuleURL, width, height);
        retrieveRandomItem();
    }

    private void addWidgetToBodyPanel(Widget widget, String id) {
        bodyPanel.add(widget, id);
    }

    private void initTable() {
        table.setCellSpacing(0);
        table.setCellPadding(2);
        DOM.setAttribute(table.getElement(), "align", "center");
        DOM.setAttribute(table.getElement(), "valign", "top");
        initWidget(table);
        table.addStyleName("ig_reset");
        table.addStyleName("ig_tbl_line");
    }


    protected void buildUI() {
        initTable();
        table.getCellFormatter().setStyleName(0, 0, "tdGadgetHeader");
        String headerHTML = "<DIV title=\"Click on the right arrows(&gt;&gt;) to see next random item.\" class=\"gadgetHeader\">&nbsp;\n" + header + "</div>";
        table.setHTML(0, 0, headerHTML);

        table.getRowFormatter().addStyleName(0, "gadgetFrameTR");
        width += 10;

        bodyPanel = new HTMLPanel("<div class=\"gadgetBody\" style=\"display: block; width: " + width + "px; height: " + height + "px;\"><table align=\"center\" style=\"display: block; width: " + width + "px; height: " + height + "px;\"><tbody align=\"center\" style=\"display: block; width: " + width + "px; height: " + height + "px;\"><tr><td width=\"90%\" id=\"randomFlickrHeader\"></td><td width=\"10%\" align=\"right\" id=\"randomFlickrControl\"></td></tr><tr><td align=\"center\" colspan=\"2\" id=\"randomFlickrImage\"></td></tr><TR><TD style=\"height:2px;\"></TD></TR></tbody></table></div>");
        table.setWidget(1, 0, bodyPanel);
        table.setWidget(2, 0, new HTML(getAddToTable()));
    }

    protected void retrieveRandomItem() {
        String url = getFeedURL();
        if (rssItems == null) {
            if (!HttpRequestUtil.sendAsyncGetRequest(url, new FeedResponseHandler(url))) {
                showError();
            }
        } else {
            displayRandomItem(rssItems);
        }
    }

    public String getFeedURL() {
        String flickrTag = flickrTags[Randomizer.getRandomNo(flickrTags.length)];
        return "/php/xmlProxy.php?url=" + URL.encodeComponent("http://www.flickr.com/services/feeds/photos_public.gne?tags="+flickrTag+"&format=rss_200");
    }

    protected void displayRandomItem(RSSItem[] rssItems) {
        if (rssItems != null && rssItems.length > 0) {
            if (lightbox == null) {
                Image[] images = getImages(rssItems);
                lightbox = new LightboxImage(images);
                addWidgetToBodyPanel(lightbox, "randomFlickrImage");
                Label arrow = new Label(">>");
                arrow.addClickListener(new ClickListener() {
                    public void onClick(Widget sender) {
                        retrieveRandomItem();
                    }
                });
                addWidgetToBodyPanel(arrow, "randomFlickrControl");
                addWidgetToBodyPanel(randomFlickrImageTitle, "randomFlickrHeader");
            }

            if (prevIdx > -1) {
                Element imageElement = DOM.getChild(lightbox.getElement(), prevIdx);
                UIObject.setVisible(imageElement, false);
            }


            int randomIdx = Random.nextInt(rssItems.length);
            RSSItem randomItem = (RSSItem) rssItems[randomIdx];

            Element imageElement = DOM.getChild(lightbox.getElement(), randomIdx);
            DOM.setInnerHTML(imageElement, StringUtil.grep(randomItem.getDesc(), "<img", ">"));

            UIObject.setVisible(imageElement, true);
            prevIdx = randomIdx;
            randomFlickrImageTitle.setText(randomItem.getTitle());
        }
    }

    private Image[] getImages(RSSItem rssItems[]) {
        Image[] images = new Image[rssItems.length];
        for (int i = 0; i < rssItems.length; i++) {
            RSSItem rssItem = (RSSItem) rssItems[i];
            images[i] = rssItem.getMedia().getContent();
            images[i].setVisible(false);
        }
        return images;
    }


    protected void handleResponse(String url, String responseText) {
        List itemsList = RSS2XMLDocumentParser.parse(responseText);
        if (itemsList.size() >= 10) {
            rssItems = new RSSItem[10];
            for (int i = 0; i < rssItems.length; i++) {
                rssItems[i] = (RSSItem) itemsList.get(i);
            }
        }
        displayRandomItem(rssItems);
    }

    protected void showError() {
        addWidgetToBodyPanel(new Label(ERROR_MESSAGE), "randomFlickrImage");
    }


    protected class FeedResponseHandler implements ResponseTextHandler {
        private String url;

        public FeedResponseHandler(String url) {
            this.url = url;
        }

        public void onCompletion(String responseText) {
            if (!HttpRequestUtil.isErrorResponse(responseText)) {
                handleResponse(url, responseText);
            }
        }

    }
}
