package therandomhomepage.client;

import com.google.gwt.user.client.ResponseTextHandler;
import com.google.gwt.user.client.HTTPRequest;

/**
 * Created by IntelliJ IDEA.
 * User: shameed
 * Date: Jul 14, 2006
 * Time: 3:49:07 PM
 */
public class HttpRequestUtil {
  public static boolean sendAsyncGetRequest(String randomFeedScriptURL, ResponseTextHandler responseHandler) {
    return HTTPRequest.asyncGet(randomFeedScriptURL, responseHandler);
  }

  public static boolean isErrorResponse(String responseText){
    if (!StringUtil.isNull(responseText)){
      return responseText.indexOf("MagpieRSS:") != -1;
    }
    return true;
  }
}
