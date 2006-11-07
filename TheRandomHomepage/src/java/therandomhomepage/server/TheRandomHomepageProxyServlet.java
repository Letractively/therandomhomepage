package therandomhomepage.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: sihameed
 * Date: Nov 7, 2006
 * Time: 3:57:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class TheRandomHomepageProxyServlet extends RemoteServiceServlet {

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        try
        {

        }
        catch(Throwable th){
            th.printStackTrace();
        }
    }
}
