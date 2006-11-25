package randomFlickr.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.rpc.RemoteService;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Nov 25, 2006
 * Time: 3:08:06 PM
 */
public interface RandomFlickrService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convinience class.
     * Use RandomFlickrService.App.getInstance () to access static instance of RandomFlickrServiceAsync
     */
    public static class App {
        private static RandomFlickrServiceAsync app = null;

        public static synchronized RandomFlickrServiceAsync getInstance() {
            if (app == null) {
                app = (RandomFlickrServiceAsync) GWT.create(RandomFlickrService.class);
                ((ServiceDefTarget) app).setServiceEntryPoint("/RandomFlickrService");
            }
            return app;
        }
    }
}
