package therandomhomepage.client;

import com.google.gwt.user.client.ResponseTextHandler;
import com.google.gwt.user.client.ui.*;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Jul 9, 2006
 * Time: 11:56:52 PM
 */
public class RandomQuotesWidget extends RandomWidget{

  private String url = "http://quotes4all.net/quotations.html";
  protected static final String ERROR_MESSAGE = "Error retrieving random content !";

  public RandomQuotesWidget(String header) {
    super(header);
  }

  protected void retrieveRandomItem() {
    URLHelper helper = new URLHelper();
    String redirectURL = helper.getRedirectScriptURL() + "?url=" + url;
    setData(new Frame(redirectURL));
  }
}
