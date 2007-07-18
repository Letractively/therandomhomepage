package therandomhomepage.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.*;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Nov 7, 2006
 * Time: 3:57:26 PM
 */
public class TheRandomHomepageProxyServlet extends RemoteServiceServlet {

    private static String ACTUAL_BASE_URL = "http://www.therandomhomepage.com";

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpURLConnection connection = null;
        PrintWriter pw = null;
        try {
            URL actualURL = getActualURL(httpServletRequest);

            connection = (HttpURLConnection) actualURL.openConnection();

            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line = reader.readLine();

            pw = httpServletResponse.getWriter();
            while (line != null) {
                pw.println(line);
                line = reader.readLine();
            }
        }
        catch (Throwable th) {
            th.printStackTrace();
        }
        finally {
            if (pw != null) {
                pw.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private URL getActualURL(HttpServletRequest httpServletRequest) throws MalformedURLException {
        String requestURI = httpServletRequest.getRequestURI();
        String url = ACTUAL_BASE_URL + requestURI;
        if (httpServletRequest.getQueryString() != null && httpServletRequest.getQueryString().trim().length() > 0) {
            url += "?" + httpServletRequest.getQueryString();
        }
        return new URL(url);
    }
}
