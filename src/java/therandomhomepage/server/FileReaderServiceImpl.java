package therandomhomepage.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import therandomhomepage.test.FileReaderService;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Nov 30, 2006
 * Time: 12:48:18 PM
 */
public class FileReaderServiceImpl extends RemoteServiceServlet implements FileReaderService {
    public String readFile(String fileName) {
        return "Hello";
    }
}
