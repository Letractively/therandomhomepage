package randomFlickr.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Nov 25, 2006
 * Time: 3:08:06 PM
 */
public interface RandomFlickrServiceAsync {
    void getMessage(String msg, AsyncCallback async);
}
