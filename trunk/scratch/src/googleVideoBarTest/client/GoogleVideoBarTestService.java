package googleVideoBarTest.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.rpc.RemoteService;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Feb 26, 2007
 * Time: 11:19:04 AM
 */
public interface GoogleVideoBarTestService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convinience class.
     * Use GoogleVideoBarTestService.App.getInstance () to access static instance of GoogleVideoBarTestServiceAsync
     */
    public static class App {
        private static GoogleVideoBarTestServiceAsync app = null;

        public static synchronized GoogleVideoBarTestServiceAsync getInstance() {
            if (app == null) {
                app = (GoogleVideoBarTestServiceAsync) GWT.create(GoogleVideoBarTestService.class);
                ((ServiceDefTarget) app).setServiceEntryPoint("/GoogleVideoBarTestService");
            }
            return app;
        }
    }
}
