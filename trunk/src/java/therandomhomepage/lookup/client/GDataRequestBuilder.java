package therandomhomepage.lookup.client;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Jul 23, 2007
 * Time: 2:09:48 PM
 */
public class GDataRequestBuilder extends RequestBuilder {

    public GDataRequestBuilder(Method method, String url) {
        super(method, url);
        setHeader("Authorization", "GoogleLogin auth=" + Authentication.getToken());
    }


    public GDataRequestBuilder(String url) {
        this(RequestBuilder.GET, url);
    }


    public Request sendRequest(RequestCallback callback) {
        try {
            return super.sendRequest(null, callback);
        } catch (RequestException e) {
            e.printStackTrace();
        }
        return null;
    }
}
