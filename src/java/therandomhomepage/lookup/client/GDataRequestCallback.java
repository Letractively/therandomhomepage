package therandomhomepage.lookup.client;

import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Request;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Jul 23, 2007
 * Time: 5:03:45 PM
 */
public abstract class GDataRequestCallback implements RequestCallback {
    public void onError(Request request, Throwable exception) {
        exception.printStackTrace();
    }

    public void waitUntilTheRequestIsProcessed(Request request){
        while (request.isPending()){
            //do nothing
            System.out.println("Waiting ....");
        }
    }
}
