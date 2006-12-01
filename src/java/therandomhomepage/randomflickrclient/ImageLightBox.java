package therandomhomepage.randomflickrclient;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HTML;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 1, 2006
 * Time: 2:13:28 PM
 */
public class ImageLightBox extends HTML {

    private static boolean initialized = false;

    public static native void init() /*-{
        $wnd.initLightbox();
    }-*/;

    public ImageLightBox(Image image) {
        if (!initialized) {
            init();
        }
        setHTML("<a href=\""+image.getUrl()+"\" rel=\"lightbox\">"+DOM.getInnerHTML(image.getElement())+"</a>");
        System.out.println("<a href=\""+image.getUrl()+"\" rel=\"lightbox\">"+DOM.getInnerHTML(image.getElement())+"</a>");
    }

}
