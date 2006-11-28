package therandomhomepage.common;

import com.google.gwt.user.client.ResponseTextHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import therandomhomepage.common.rss.JSON2RSSParser;
import therandomhomepage.common.rss.RSSItem;
import therandomhomepage.common.URLHelper;
import therandomhomepage.common.Randomizer;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Jul 12, 2006
 * Time: 11:44:43 PM
 */
public class RandomNewsWidget extends RandomWidget {

  private static final String ERROR_MESSAGE = "Error retrieving content from the list of RSS/Atom feed!. Please make sure that the URL is accessible and it is a valid feed.";
  private String randomFeedScriptURL = null;
  private static RSSCache cache = new RSSCache();

  public RandomNewsWidget(String header) {
    super(header);
  }

  protected void buildFooter() {
    table.setWidget(3, 0, getAddToGoogleButton());
  }

  protected void retrieveRandomItem() {
    randomFeedScriptURL = new URLHelper().getRandomNewsFeedURL();
    if (cache.getFromCache(randomFeedScriptURL) == null) {
      if (!HttpRequestUtil.sendAsyncGetRequest(randomFeedScriptURL, new RSSItemResponseHandler(this))) {
        showError();
      }
    } else {
      List itemList = cache.getFromCache(randomFeedScriptURL);
      RSSItem rssItem = (RSSItem) Randomizer.getRandomItem(itemList);
      displayRandomItem(rssItem);
    }
  }

  private void showError() {
    Label errorLabel = new Label(RandomNewsWidget.ERROR_MESSAGE);
      //noinspection GWTStyleCheck
      errorLabel.setStyleName("randomWidgetHeader-errorMessage");
    table.setWidget(1, 0, errorLabel);
  }

  private class RSSItemResponseHandler implements ResponseTextHandler {

    private String feedURL;
    private RandomNewsWidget widget;

    public RSSItemResponseHandler(RandomNewsWidget widget) {
      this.widget = widget;
    }

    public RSSItemResponseHandler(RandomNewsWidget widget, String feedURL) {
      this(widget);
      this.feedURL = feedURL;
    }

    public void onCompletion(String responseText) {
      System.out.println("responseText = " + responseText);  
      if (!HttpRequestUtil.isErrorResponse(responseText)) {
        List rssItems = JSON2RSSParser.parse(responseText);
        if (feedURL == null) {
          widget.addToCache(randomFeedScriptURL, rssItems);
        } else {
          widget.addToCache(feedURL, rssItems);
        }
        RSSItem randomItem = (RSSItem) Randomizer.getRandomItem(rssItems);
        displayRandomItem(randomItem);
      }
    }
  }

  private void displayRandomItem(RSSItem randomItem) {
    if (randomItem != null) {
      RSSItemLink itemLink = new RSSItemLink(randomItem);
      table.setWidget(1, 0, itemLink);
      table.getFlexCellFormatter().setColSpan(1, 0, 2);
      table.getFlexCellFormatter().setVerticalAlignment(0, 1, HasVerticalAlignment.ALIGN_TOP);
      table.setWidget(2, 0, new HTML(randomItem.getDesc()));
      table.getFlexCellFormatter().setColSpan(2, 0, 2);
    }
  }

  private void addToCache(String feedURL, List rssItems) {
    cache.addToCache(feedURL, rssItems);
  }

  private HTML getAddToGoogleButton() {
    return new HTML("<a href=\"http://fusion.google.com/add?moduleurl=http%3A//www.therandomhomepage.com/google/gadget/RandomFeedModule.xml\"><img src=\"http://buttons.googlesyndication.com/fusion/add.gif\" width=\"104\" height=\"17\" border=\"0\" alt=\"Add to Google\"></a>");
  }
}
