package googleVideoBarTest.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Feb 26, 2007
 * Time: 11:19:04 AM
 */
public interface GoogleVideoBarTestServiceAsync {
    void getMessage(String msg, AsyncCallback async);
}
