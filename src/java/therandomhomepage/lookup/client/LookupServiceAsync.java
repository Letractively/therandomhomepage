package therandomhomepage.lookup.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Jul 18, 2007
 * Time: 1:35:10 PM
 */
public interface LookupServiceAsync {
    void getMessage(String msg, AsyncCallback async);
}
