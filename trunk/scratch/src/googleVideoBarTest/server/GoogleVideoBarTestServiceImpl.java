package googleVideoBarTest.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import googleVideoBarTest.client.GoogleVideoBarTestService;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Feb 26, 2007
 * Time: 11:19:04 AM
 */
public class GoogleVideoBarTestServiceImpl extends RemoteServiceServlet implements GoogleVideoBarTestService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}