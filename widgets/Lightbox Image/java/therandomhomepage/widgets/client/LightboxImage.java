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
    private Image images;

    public LightboxImage(Image image) {
        this.image = image;
        Element anchorElement = DOM.createAnchor();
        DOM.setAttribute(anchorElement,"rel","lightbox");
        DOM.setAttribute(anchorElement,"href",image.getUrl());
        DOM.appendChild(anchorElement,image.getElement());
        setElement(anchorElement);
    }

    public LightboxImage(Image images[]) {
        this.images = image;
        Element tempDiv = DOM.createDiv();
        for (int i = 0; i < images.length; i++) {
            Element anchorElement = DOM.createAnchor();
            DOM.setAttribute(anchorElement,"rel","lightbox["+images.hashCode()+"]");
            DOM.setAttribute(anchorElement,"href",images[i].getUrl());
            DOM.appendChild(anchorElement,images[i].getElement());
            DOM.appendChild(tempDiv,anchorElement);
        }
        setElement(tempDiv);
    }


    protected void onLoad() {
        init();
    }

    public static native void init() /*-{
        $wnd.initLightbox();
    }-*/;
}
