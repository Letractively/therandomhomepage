package mooFxTestApp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Jan 17, 2007
 * Time: 3:05:23 PM
 */
public interface MooFxTestAppServiceAsync {
    void getMessage(String msg, AsyncCallback async);
}
