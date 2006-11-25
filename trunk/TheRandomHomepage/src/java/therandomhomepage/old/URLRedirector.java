package therandomhomepage.old;

import com.google.gwt.user.client.HTTPRequest;
import com.google.gwt.user.client.ResponseTextHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONException;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.json.client.JSONParser;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Jun 30, 2006
 * Time: 12:20:38 AM
 */
public class URLRedirector {

    public static final String GET_WEBSITES_URL = "/GetRandomWebsite.php";

    public final void redirectToRandomWebsite() {
        HTTPRequest.asyncGet(GET_WEBSITES_URL, new JSONResponseTextHandler());
    }

    private class JSONResponseTextHandler implements ResponseTextHandler {
        /*
        *  (non-Javadoc)
        * @see com.google.gwt.user.client.ResponseTextHandler#onCompletion(java.lang.String)
        */

        public void onCompletion(String responseText) {
            /*
            *  When the fetch has been completed we parse the JSON response and
            *  display the result
            */

            String randomWebsite = getRandomWebsite(responseText);
            if (randomWebsite != null && randomWebsite.trim().length() > 0) {
                redirectURL(randomWebsite);
            }
        }

        private String getRandomWebsite(String responseText) {

            JSONObject jsonValue;
            try {
                jsonValue = (JSONObject) JSONParser.parse(responseText);
                JSONValue randomWebsite = jsonValue.get("RandomWebsite");
                if (randomWebsite != null) {
                    JSONObject urlObject = randomWebsite.isObject();
                    if (urlObject != null) {
                        return urlObject.get("URL").toString();
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static native void redirectURL(String url) /*-{
    $wnd.location=url;
}-*/;
}