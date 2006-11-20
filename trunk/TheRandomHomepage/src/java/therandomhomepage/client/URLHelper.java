package therandomhomepage.client;

import com.google.gwt.user.client.Random;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: shameed
 * Date: Jul 13, 2006
 * Time: 9:30:30 AM
 */
public class URLHelper {
  private HashMap paramsMap = new HashMap();
  private ArrayList feedURLs = new ArrayList();
  private static final String USER_PREF_PREFIX = "up_";
  private static final String USER_PREF_URL_PREFIX = "up_url";
  private static final String AUTO_PLAY_PREF_KEY = "up_autoplay";
  private static final String AUTO_PLAY_DELAY_KEY = "up_delay";
  private static final String LOCAL_BASE_URL = "/";

  private static final String GET_RANDOM_FEED_URL = "php/GetRandomFeed.php";
  private static final String GET_RANDOM_NEWS_FEED_URL = "php/GetRandomNewsfeed.php";
  private static final String GET_RECIPE_FEED_URL = "php/GetRandomRecipe.php";
  private static final String REDIRECT_SCRIPT_URL = "php/Redirect.php";

  public static native String getQueryString() /*-{
        return $wnd.location.search.substring(1);
    }-*/;

  public static native String getWindowLocation() /*-{
        return $wnd.location.href;
    }-*/;

  public String getBaseURL() {
//    String windowLocation = URLHelper.getWindowLocation();
//    if (windowLocation.startsWith("http://local")) {
//      return URLHelper.LOCAL_BASE_URL;
//    }
    //return URLHelper.SERVER_BASE_URL;
    return URLHelper.LOCAL_BASE_URL;      
  }

  public String getRandomFeedURL() {
    return getBaseURL() + GET_RANDOM_FEED_URL;
  }

  public String getRandomNewsFeedURL() {
    return getBaseURL() + GET_RANDOM_NEWS_FEED_URL + "?rnd="+Random.nextInt(10);
  }

  public String getRecipeFeedURL() {
    return getBaseURL() + GET_RECIPE_FEED_URL;
  }

  public String getRedirectScriptURL() {
    return getBaseURL() + REDIRECT_SCRIPT_URL;
  }

  private void initParamsMapAndFeedURLs() {
    if (paramsMap.size() == 0) {
      String query = URLHelper.getQueryString();
      if ((query != null) && query.trim().length() > 0) {
        String[] params = query.split("&");
        parseURLParams(params);
      }
    }
  }

  private void parseURLParams(String[] params) {
    for (int i = 0; i < params.length; i++) {
      int ix = params[i].indexOf('=');
      if (ix > 0) {
        String key = params[i].substring(0, ix);
        String value = params[i].substring(ix + 1);
        loadKeyAndValue(key, value);
      }
    }
  }

  private void loadKeyAndValue(String key, String value) {
    if ((key != null) && (key.startsWith(URLHelper.USER_PREF_PREFIX))) {
      paramsMap.put(key, value);
      if (key.startsWith(URLHelper.USER_PREF_URL_PREFIX) && !StringUtil.isNull(value)) {
        feedURLs.add(value);
      }
    }
  }

  public ArrayList getFeedURLs() {
    initParamsMapAndFeedURLs();
    return feedURLs;
  }

  public boolean isAutoPlayMode() {
    if ((paramsMap.get(URLHelper.AUTO_PLAY_PREF_KEY) != null) && ((String) paramsMap.get(URLHelper.AUTO_PLAY_PREF_KEY)).equalsIgnoreCase("1")) {
      return true;
    }
    return false;
  }

  public int getAutoPlayDelay() {
    int delay = 0;
    if (paramsMap.get(URLHelper.AUTO_PLAY_DELAY_KEY) != null) {
      delay = Integer.parseInt((String) paramsMap.get(URLHelper.AUTO_PLAY_DELAY_KEY));
    }
    return delay;
  }
}
