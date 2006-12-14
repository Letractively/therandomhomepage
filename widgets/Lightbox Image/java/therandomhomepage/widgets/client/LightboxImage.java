package therandomhomepage.widgets.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 14, 2006
 * Time: 11:13:59 AM
 */
public class LightboxImage extends Widget{
    private Image image;

    public LightboxImage(Image image) {
        this.image = image;
        Element anchorElement = DOM.createAnchor();
        DOM.setAttribute(anchorElement,"rel","lightbox");
        DOM.setAttribute(anchorElement,"href",image.getUrl());
        DOM.appendChild(anchorElement,image.getElement());
        setElement(anchorElement);
    }


    protected void onLoad() {
        init();
    }

    public static native void init() /*-{
        $wnd.initLightbox();
    }-*/;
}
