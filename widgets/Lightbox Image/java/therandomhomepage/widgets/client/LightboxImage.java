package therandomhomepage.widgets.client;

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
    private Image[] images;
    private boolean slideshow;
    private int slideshowDelayInSeconds;

    public LightboxImage(Image image) {
        this.image = image;
        setElement(createAnchor(image, "lightbox"));
    }

    private Element createAnchor(Image image, String relValue) {
        Element anchorElement = DOM.createAnchor();
        DOM.setAttribute(anchorElement,"rel", relValue);
        DOM.setAttribute(anchorElement,"href",image.getUrl());
        DOM.setAttribute(anchorElement,"title",image.getTitle());
        DOM.appendChild(anchorElement,image.getElement());
        return anchorElement;
    }

    public LightboxImage(Image images[]) {
        this.images = images;
        Element tempDiv = DOM.createDiv();
        for (int i = 0; i < images.length; i++) {
            String imageSetName = String.valueOf(images[i].hashCode());
            DOM.appendChild(tempDiv,createAnchor(images[i],"lightbox["+imageSetName+"]"));
        }
        setElement(tempDiv);
    }

    public LightboxImage(Image images[],boolean slideshow,int slideshowDelayInSeconds) {
        this.images = images;
        this.slideshow = slideshow;
        this.slideshowDelayInSeconds = slideshowDelayInSeconds;
        Element tempDiv = DOM.createDiv();
        for (int i = 0; i < images.length; i++) {
            String imageSetName = String.valueOf(images[i].hashCode());
            DOM.appendChild(tempDiv,createAnchor(images[i],"lightbox["+imageSetName+"]"));
        }

        //TODO: Implement this        
        setElement(tempDiv);
    }


    protected void onLoad() {
        init();
    }

    public static native void init() /*-{
        $wnd.initLightbox();
    }-*/;
}
