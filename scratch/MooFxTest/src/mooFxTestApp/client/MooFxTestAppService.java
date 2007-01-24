package mooFxTestApp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.rpc.RemoteService;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Jan 17, 2007
 * Time: 3:05:23 PM
 */
public interface MooFxTestAppService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convinience class.
     * Use MooFxTestAppService.App.getInstance () to access static instance of MooFxTestAppServiceAsync
     */
    public static class App {
        private static MooFxTestAppServiceAsync app = null;

        public static synchronized MooFxTestAppServiceAsync getInstance() {
            if (app == null) {
                app = (MooFxTestAppServiceAsync) GWT.create(MooFxTestAppService.class);
                ((ServiceDefTarget) app).setServiceEntryPoint("/MooFxTestAppService");
            }
            return app;
        }
    }
}
