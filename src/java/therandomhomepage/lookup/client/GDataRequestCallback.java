package therandomhomepage.lookup.client;

import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Jul 23, 2007
 * Time: 5:03:45 PM
 */
public abstract class GDataRequestCallback implements RequestCallback {
    private boolean requestComplete = false;

    public void onResponseReceived(Request request, Response response) {
        requestComplete = true;
        processResponse(response);
    }

    public void onError(Request request, Throwable exception) {
        requestComplete = true;
        exception.printStackTrace();
    }

    public boolean isRequestComplete() {
        return requestComplete;
    }

    public abstract void processResponse(Response response);
}
