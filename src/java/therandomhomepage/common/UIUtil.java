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

    public static Image getImageFromInnerHTML(String imgInnerHTML) {
        String imgTag = StringUtil.grep(imgInnerHTML, "<IMG", ">");
        String srcStr = null;
        if (imgTag != null) {
            srcStr = StringUtil.grepBetween(imgTag,"src=\"","\"");
            if (srcStr != null)  {
                return new Image(escapeLeadingAndTrailingQuotes(srcStr));
            }
            else {
                srcStr = StringUtil.grep(imgTag,"src='","'");
                if (srcStr == null) {
                    srcStr = StringUtil.grep(imgTag,"src="," ");                    
                }
                return new Image(escapeLeadingAndTrailingQuotes(srcStr));
            }
        }
        return null;
    }

    public static String escapeLeadingAndTrailingQuotes(String str){
        if (str.startsWith("\"") && str.endsWith("\"")){
            return str.replaceAll("\"","");
        }
        else if (str.startsWith("'") && str.endsWith("'")){
            return str.replaceAll("'","");
        }
        return str;
    }
}
