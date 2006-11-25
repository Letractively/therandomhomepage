package randomFlickr.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import randomFlickr.client.RandomFlickrService;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Nov 25, 2006
 * Time: 3:08:07 PM
 */
public class RandomFlickrServiceImpl extends RemoteServiceServlet implements RandomFlickrService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}