package therandomhomepage.widgets.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 14, 2006
 * Time: 11:13:59 AM
 */
public class LightboxImage extends Widget {

    private Element anchor = null;
    private Element anchors[] = null;

    private boolean slideshow;
    private int slideshowDelayInSeconds;

    public LightboxImage(Image image) {
        anchor = createAnchor(image, "lightbox");
        setElement(anchor);
    }

    private Element createAnchor(Image image, String relValue) {
        Element anchorElement = DOM.createAnchor();
        DOM.setAttribute(anchorElement, "rel", relValue);
        DOM.setAttribute(anchorElement, "href", image.getUrl());
        DOM.setAttribute(anchorElement, "title", image.getTitle());
        DOM.appendChild(anchorElement, image.getElement());
        return anchorElement;
    }

    public LightboxImage(Image images[]) {
        anchors = new Element[images.length];
        Element tempDiv = DOM.createDiv();
        for (int i = 0; i < images.length; i++) {
            anchors[i] = createAnchor(images[i], "lightbox[imageset]");
            DOM.setAttribute(anchors[i], "startslideshow", "false");
            DOM.appendChild(tempDiv, anchors[i]);
        }
        setElement(tempDiv);
    }

    public LightboxImage(Image images[], boolean slideshow, int slideshowDelayInSeconds) {
        this(images);
        this.slideshow = slideshow;
        this.slideshowDelayInSeconds = slideshowDelayInSeconds;
        for (int i = 0; i < anchors.length; i++) {
            Element element = anchors[i];
            DOM.setAttribute(element, "slideDuration", String.valueOf(slideshowDelayInSeconds));
        }
        setAllVisibility(false);
    }

    private void setAllVisibility(boolean visible) {
        for (int i = 0; i < anchors.length; i++) {
            setVisibility(i, visible);
        }
    }

    private void setVisibility(int idx, boolean visible) {
        Element anchorElem = anchors[idx];
        UIObject.setVisible(anchorElem, visible);
    }

    public void showSlideshowImage(int imageIdx) {
        setAllVisibility(false);
        setVisibility(imageIdx, true);
    }


    public boolean isSlideshow() {
        return slideshow;
    }

    public void setSlideshow(boolean slideshow) {
        this.slideshow = slideshow;
    }

    public int getSlideshowDelayInSeconds() {
        return slideshowDelayInSeconds;
    }

    public void setSlideshowDelayInSeconds(int slideshowDelayInSeconds) {
        this.slideshowDelayInSeconds = slideshowDelayInSeconds;
    }

    protected void onLoad() {
        init();
    }

    public static native void init() /*-{
        $wnd.initLightbox();
    }-*/;
}
