package therandomhomepage.test;

import therandomhomepage.lookup.client.GDataRequest;
import therandomhomepage.lookup.client.GDataRequestCallback;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Timer;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Jul 26, 2007
 * Time: 3:40:06 PM
 */
public class GDataRequest_UT extends TheRandomHomepageAbstract_UT {

    public void testInit() {
        GDataRequest request = new GDataRequest("test");
        assertNotNull(request);
    }

    public void testInvalidURL() {
        try {
            new GDataRequest("");
        } catch (IllegalArgumentException e) {
            assertEquals("url can not be empty", e.getMessage());
        }
    }

    public void testNullURL() {
        try {
            new GDataRequest(null);
        } catch (NullPointerException e) {
            assertEquals("url can not be null", e.getMessage());
        }
    }

    public void testInvalidMethod() {
        try {
            new GDataRequest("", "asdasd");
        } catch (IllegalArgumentException e) {
            assertEquals("httpMethod can not be empty", e.getMessage());
        }
    }

    public void testNullMethod() {
        try {
            new GDataRequest(null,"ajdkasd");
        } catch (NullPointerException e) {
            assertEquals("httpMethod can not be null", e.getMessage());
        }
    }

    public void testSendAsyncGetRequest() throws Exception{
        GDataRequest gdataRequest = new GDataRequest("http://www.therandomhomepage.com");
        
        Request sentRequest = gdataRequest.sendGetRequest(new RequestCallback(){

            public void onResponseReceived(Request request, Response response) {
                assertTrue(!request.isPending());
                System.out.println("response = " + response.getText());
                finishTest();
            }

            public void onError(Request request, Throwable exception) {
                fail("Shouldn't have come here");
            }
        });

        assertTrue(sentRequest.isPending());
        delayTestFinish(1000 * 60);
    }

    public void testSendSyncGetRequest() throws Exception{
        GDataRequest gdataRequest = new GDataRequest("http://www.therandomhomepage.com");

        final MyRequestCallback requestCallback = new MyRequestCallback();
        Request sentRequest = gdataRequest.sendGetRequest(requestCallback);

        Timer timer = new Timer(){

            public void run() {
                System.out.println("requestCallback.isRequestComplete() = " + requestCallback.isRequestComplete());
                if (requestCallback.isRequestComplete()){
                    cancel();
                }
            }
        };
        timer.scheduleRepeating(100);
        System.out.println("After Schedule Repeating");

        delayTestFinish(1000 * 60);
    }

    private class MyRequestCallback extends GDataRequestCallback {

        public void processResponse(Response response) {
            System.out.println("response.getText() = " + response.getText());
            finishTest();
        }
    }

}
