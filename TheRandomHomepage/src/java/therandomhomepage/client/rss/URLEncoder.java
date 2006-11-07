package therandomhomepage.client.rss;

/**
 * Created by IntelliJ IDEA.
 * User: shameed
 * Date: Jul 7, 2006
 * Time: 3:49:31 PM
 */
public class URLEncoder {

  public static final String REDIRECT_SOURCE = "http://local.randompage.com/Redirect.php?url=";

  public static String getRedirectURL(String actualURL) {
    if (actualURL != null) {
      return REDIRECT_SOURCE + actualURL;
    }
    return null;
  }
}
