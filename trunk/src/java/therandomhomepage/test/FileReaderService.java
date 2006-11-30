package therandomhomepage.test;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Nov 30, 2006
 * Time: 12:56:55 PM
 */
public interface FileReaderService extends RemoteService {
    public String readFile(String fileName);
}
