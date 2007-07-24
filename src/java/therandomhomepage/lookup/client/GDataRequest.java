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
public class GDataRequest {

    private String url;
    private RequestBuilder requestBuilder = null;


    public GDataRequest(String url) {
        this.url = url;
    }


    public Request sendGetRequest(RequestCallback callback) {
        try {
            initRequestBuilder(RequestBuilder.GET);
            return requestBuilder.sendRequest(null, callback);
        } catch (RequestException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Request sendPostRequest(String postData,RequestCallback callback) {
        try {
            initRequestBuilder(RequestBuilder.POST);
            requestBuilder.setHeader("Content-Type","application/atom+xml");
            return requestBuilder.sendRequest(postData, callback);
        } catch (RequestException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void initRequestBuilder(RequestBuilder.Method requestMethod) {
        requestBuilder = new RequestBuilder(requestMethod,url);
        requestBuilder.setHeader("Authorization", "GoogleLogin auth=" + Authentication.getToken());
    }
}
