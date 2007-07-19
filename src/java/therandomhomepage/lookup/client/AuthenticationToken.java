package therandomhomepage.lookup.client;

import com.google.gwt.user.client.ResponseTextHandler;
import org.apache.xmlrpc.util.HttpUtil;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Jul 19, 2007
 * Time: 4:52:19 PM
 */
public class AuthenticationToken {


    String email = "googlookup@gmail.com";
    String passwd = "googlelookup";
    public String getAuthenticationToken(String email, String passwd){

        final String[] token = new String[]{null};
        String postData = "accountType=GOOGLE&Email="+email+"&Passwd="+passwd+"&source=quickadd-testapp-1&service=wise";
        String url ="https://www.google.com/accounts/ClientLogin";
        ResponseTextHandler handler = new ResponseTextHandler() {
            public void onCompletion( String responseText ) {
                try {
                    token[0] =parseAuth(responseText);
//                    notifyComplete();
                } catch ( Exception e ) {
//                    notifyFailed();
                }
            }
        };

//        HttpUtil.( url, postData, handler);

        return token[0];

    }

    static String parseAuth( String s ) {
        int i = s.indexOf("Auth");
        return s.substring(i+5, s.length()-1); // Auth=
    }
}
