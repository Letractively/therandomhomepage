package therandomhomepage.test;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FileReaderServiceAsync {
    void readFile(String fileName, AsyncCallback async);
}
