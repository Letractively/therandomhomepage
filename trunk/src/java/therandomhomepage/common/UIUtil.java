package therandomhomepage.common;

import com.google.gwt.user.client.ui.Image;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 4, 2006
 * Time: 4:33:48 PM
 */
public class UIUtil {

    public static String reduceSize(String pixel,int perc){
        try {
            return (Integer.parseInt(pixel) * perc /100) + "px";
        } catch (NumberFormatException e) {
            return pixel+"px";
        }
    }
}
