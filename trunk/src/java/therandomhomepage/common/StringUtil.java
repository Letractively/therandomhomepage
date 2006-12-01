package therandomhomepage.common;

/**
 * Created by IntelliJ IDEA.
 * User: shameed
 * Date: Jul 14, 2006
 * Time: 2:58:33 PM
 */
public class StringUtil {
    public static boolean isNull(String str) {
        if ((str == null) || (str.trim().length() == 0) || str.equalsIgnoreCase("null")) {
            return true;
        }
        return false;
    }

  
}
