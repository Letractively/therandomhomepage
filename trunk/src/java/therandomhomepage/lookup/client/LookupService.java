package therandomhomepage.lookup.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.rpc.RemoteService;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Jul 18, 2007
 * Time: 1:35:10 PM
 */
public interface LookupService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convinience class.
     * Use LookupService.App.getInstance () to access static instance of LookupServiceAsync
     */
    public static class App {
        private static LookupServiceAsync app = null;

        public static synchronized LookupServiceAsync getInstance() {
            if (app == null) {
                app = (LookupServiceAsync) GWT.create(LookupService.class);
                ((ServiceDefTarget) app).setServiceEntryPoint("/LookupService");
            }
            return app;
        }
    }
}
