package therandomhomepage.server;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Nov 30, 2006
 * Time: 12:48:18 PM
 */
public class FileReaderServlet extends RemoteServiceServlet {

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        try {
            String fileName = httpServletRequest.getParameter("fileName");
            if (fileName != null) {
                if (fileName.endsWith(".xml")) {
                    httpServletResponse.setContentType("text/xml");
                }
                httpServletResponse.getWriter().print(readFile(fileName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readFile(String fileName) {

        FileReader fileReader = null;
        try {
            StringBuffer fileContent = new StringBuffer();
            if (fileName != null) {

                File file = new File("therandomhomepage/server/" + fileName);
                fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
                String line = reader.readLine();
                while (line != null) {
                    fileContent.append(line).append("\n");
                    line = reader.readLine();
                }
                return fileContent.toString();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public String processCall
            (String
                    payload) throws SerializationException {
        System.out.println("payload = " + payload);
        return super.processCall(payload);
    }
}
