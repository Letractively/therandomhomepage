package mooFxTestApp.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import mooFxTestApp.client.MooFxTestAppService;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Jan 17, 2007
 * Time: 3:05:23 PM
 */
public class MooFxTestAppServiceImpl extends RemoteServiceServlet implements MooFxTestAppService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}