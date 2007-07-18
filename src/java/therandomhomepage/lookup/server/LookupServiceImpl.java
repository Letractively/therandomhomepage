package therandomhomepage.lookup.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import therandomhomepage.lookup.client.LookupService;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Jul 18, 2007
 * Time: 1:35:10 PM
 */
public class LookupServiceImpl extends RemoteServiceServlet implements LookupService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}