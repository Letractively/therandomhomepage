package therandomhomepage.common;

import com.google.gwt.user.client.ui.*;
import therandomhomepage.common.URLHelper;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Jul 9, 2006
 * Time: 11:56:52 PM
 */
public class RandomQuotesWidget extends RandomWidget{

  protected static final String ERROR_MESSAGE = "Error retrieving random content !";

  public RandomQuotesWidget(String header) {
    super(header);
  }

  protected void retrieveRandomItem() {
    String url = "http://quotes4all.net/quotations.html";
    URLHelper helper = new URLHelper();
    String redirectURL = helper.getRedirectScriptURL() + "?url=" + url;
    System.out.println("redirectURL = " + redirectURL);  
    setData(new Frame(redirectURL));
  }
}
