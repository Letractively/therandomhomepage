package therandomhomepage.client;

import com.google.gwt.user.client.HTTPRequest;
import com.google.gwt.user.client.ResponseTextHandler;
import com.google.gwt.user.client.ui.*;
import therandomhomepage.client.rss.JSON2RSSParser;
import therandomhomepage.client.rss.RSSItem;
import therandomhomepage.core.Randomizable;
import therandomhomepage.core.Randomizer;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Jul 9, 2006
 * Time: 11:56:52 PM
 */
public class RandomRecipeWidget extends RandomWidget{
  protected static final String ERROR_MESSAGE = "Error retrieving random content !";

  public RandomRecipeWidget(String header) {
    super(header);
  }

  protected void retrieveRandomItem() {
    String url = new URLHelper().getRecipeFeedURL();
    if (!HTTPRequest.asyncGet(url, new RSSItemResponseHandler())) {
      setData(new Label(RandomRecipeWidget.ERROR_MESSAGE));
    }
  }

  private class RSSItemResponseHandler implements ResponseTextHandler {
    public void onCompletion(String responseText) {
      RSSItem randomItem = (RSSItem) Randomizer.getRandomItem(getData(responseText));
      displayRandomItem(randomItem);
    }

    private void displayRandomItem(RSSItem randomItem) {
      if (randomItem != null) {
        RSSItemLink itemLink = new RSSItemLink(randomItem);
        setData(itemLink);
        table.setWidget(2, 0, new HTML(randomItem.getDesc()));
      }
    }

    private Randomizable[] getData(String responseText) {
      return JSON2RSSParser.parse(responseText);
    }
  }
}