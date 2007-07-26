package therandomhomepage.lookup.client;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Jul 23, 2007
 * Time: 2:09:48 PM
 */
public class GDataRequest extends RequestBuilder {

    public GDataRequest(String httpMethod, String url) {
        super(httpMethod, url);
        setHeader("Authorization", "GoogleLogin auth=" + Authentication.getToken());
    }


    protected GDataRequest(Method httpMethod, String url) {
        this(httpMethod.toString(), url);
    }

    public GDataRequest(String url) {
        this("GET", url);
    }

    public Request sendGetRequest(RequestCallback callback) {
        try {
            return sendRequest(null, callback);
        } catch (RequestException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Request sendSynchronousGetRequest(GDataRequestCallback callback) {
        Request request = sendGetRequest(callback);
        waitUntilTheRequestIsProcessed(callback);
        return request;
    }

    public Request sendSynchronousPostRequest(String postData, GDataRequestCallback callback) {
        Request request = sendPostRequest(postData,callback);
        waitUntilTheRequestIsProcessed(callback);
        return request;
    }

    private void waitUntilTheRequestIsProcessed(final GDataRequestCallback callback) {
        final Timer timer = new Timer() {
            public void run() {
                if (callback.isRequestComplete()){
                    cancel();
                }
            }
        };
        timer.schedule(100);
    }

    public Request sendPostRequest(String postData, RequestCallback callback) {
        try {
            setHeader("Content-Type", "application/atom+xml");
            sendRequest(postData, callback);
        } catch (RequestException e) {
            e.printStackTrace();
        }
        return null;
    }
}
