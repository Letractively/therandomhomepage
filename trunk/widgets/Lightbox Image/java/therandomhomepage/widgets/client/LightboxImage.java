package therandomhomepage.widgets.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Timer;
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

    private Element childrens[] = null;
    private boolean slideshow;
    private int slideshowDelayInSeconds;
    private static int instance = 0;
    private static int loadedInstance = 0;
    private LightboxImageTimer timer = null;

    public LightboxImage(Image image) {
        setElement(createAnchor(image, "lightbox"));
        instance++;
    }

    public LightboxImage(Image images[]) {
        childrens = new Element[images.length];
        Element tempDiv = DOM.createDiv();
        for (int i = 0; i < images.length; i++) {
            childrens[i] = createAnchor(images[i], "lightbox[imageset]");
            DOM.setAttribute(childrens[i], "startslideshow", "false");
            DOM.appendChild(tempDiv, childrens[i]);
        }
        setElement(tempDiv);
        instance++;
    }

    public LightboxImage(Image images[], boolean slideshow, int slideshowDelayInSeconds) {
        this(images);
        this.slideshow = slideshow;
        this.slideshowDelayInSeconds = slideshowDelayInSeconds;
        for (int i = 0; i < childrens.length; i++) {
            Element element = childrens[i];
            DOM.setAttribute(element, "slideDuration", String.valueOf(slideshowDelayInSeconds));
        }
        setAllVisibility(false);
        setVisibility(0, true);
    }

    public void startSlideshow() {
        if (timer != null) {
            timer = new LightboxImageTimer();
            timer.scheduleRepeating(slideshowDelayInSeconds * 1000);
        }
    }

    public void stopSlideshow() {
        if (timer != null) {
            timer.cancel();
        }
    }

    private Element createAnchor(Image image, String relValue) {
        Element anchorElement = DOM.createAnchor();
        DOM.setAttribute(anchorElement, "rel", relValue);
        DOM.setAttribute(anchorElement, "href", image.getUrl());
        DOM.setAttribute(anchorElement, "title", image.getTitle());
        DOM.appendChild(anchorElement, image.getElement());
        return anchorElement;
    }

    private void setAllVisibility(boolean visible) {
        for (int i = 0; i < childrens.length; i++) {
            setVisibility(i, visible);
        }
    }

    private void setVisibility(int idx, boolean visible) {
        Element anchorElem = childrens[idx];
        UIObject.setVisible(anchorElem, visible);
    }

    public void toggleSlideshowImage(int imageIdx) {
        if (slideshow) {
            setAllVisibility(false);
            setVisibility(imageIdx, true);
        }
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
        loadedInstance++;
        if (loadedInstance == instance) {
            init();
            loadedInstance--;
        }
    }

    private class LightboxImageTimer extends Timer {
        int prevIdx = -1;
        int currentIdx = 0;

        public void run() {
            if (prevIdx > -1) {
                setVisibility(prevIdx, false);
            }
            if (currentIdx == childrens.length) {
                currentIdx = 0;
            }
            setVisibility(currentIdx, true);
            prevIdx = currentIdx;
            currentIdx++;
        }
    }

    public static native void init() /*-{
        $wnd.initLightbox();
    }-*/;
}
