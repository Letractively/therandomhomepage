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


    public static String grep(String actualString, String startsWith, String endsWith) {
        if (actualString != null) {
            int startIdx = actualString.indexOf(startsWith.toUpperCase()) < 0  ? actualString.indexOf(startsWith.toLowerCase()) : actualString.indexOf(startsWith.toUpperCase()) ;
            int endIdx = actualString.indexOf(endsWith.toUpperCase(),startIdx+1) < 0  ? actualString.indexOf(endsWith.toLowerCase(),startIdx+1) : actualString.indexOf(endsWith.toUpperCase(),startIdx+1);
            if (startIdx > -1 && endIdx > -1) {
                return actualString.substring(startIdx, endIdx + 1);
            }
        }
        return null;
    }
}
