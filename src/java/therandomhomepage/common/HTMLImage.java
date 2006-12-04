package therandomhomepage.common;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.DOM;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 4, 2006
 * Time: 11:00:14 AM
 */
public class HTMLImage extends Image {
    public HTMLImage(String imageInnerHTML){
        Element imgElement = DOM.createImg();
        DOM.setInnerHTML(imgElement,imageInnerHTML);
        setElement(imgElement);
    }
}
