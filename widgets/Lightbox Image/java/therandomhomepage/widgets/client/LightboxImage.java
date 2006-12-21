/*
 * Copyright 2006 Siddique Hameed <siddii AT gmail.com> - http://www.TheRandomHomepage.com
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package therandomhomepage.widgets.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.*;

/**
 * LightboxImage widget, a GWT wrapper for Lightbox JS by Lokesh Dhakar.
 *
 * @author Siddique Hameed
 * @version 0.1
 * @see <a target="_new" href="http://www.huddletogether.com/projects/lightbox2/">http://www.huddletogether.com/projects/lightbox2/</a>
 */
public class LightboxImage extends Widget implements SourcesClickEvents {

    private boolean slideshow;
    private int slideshowDelayInSeconds;
    private boolean slideshowForever;

    private Element childrens[] = null;
    private static int imagesets = 0;
    private LightboxImageTimer timer = null;

    private int prevIdx = 0;
    private int currentIdx = 0;
    private String backgroundMusicURL;
    private boolean slideshowRunning = false;
    private ClickListenerCollection clickListeners;

    /**
     * Create LightboxImage with a single image
     *
     * @param image image for the Lightbox
     */

    public LightboxImage(Image image) {
        setElement(createAnchor(image, "lightbox"));
    }

    /**
     * Create LightboxImage with multiple images
     *
     * @param images images for the Lightbox
     */

    public LightboxImage(Image images[]) {
        this(images, false, 0);
    }

    /**
     * Create LightboxImage with multiple images and with slideshow options
     *
     * @param images                  images for the Lightbox
     * @param slideshow               Is slideshow
     * @param slideshowDelayInSeconds Slideshow delay in seconds
     */

    public LightboxImage(Image images[], boolean slideshow, int slideshowDelayInSeconds) {
        setElement(DOM.createDiv());
        this.slideshow = slideshow;
        this.slideshowDelayInSeconds = slideshowDelayInSeconds;
        //TODO: Move this to common place ? May be onLoad() ?
        childrens = new Element[images.length];
        for (int i = 0; i < images.length; i++) {
            childrens[i] = createAnchor(images[i], "lightbox[" + imagesets + "]");
            DOM.setAttribute(childrens[i], "startslideshow", Boolean.toString(slideshow));
            if (slideshow) {
                DOM.setAttribute(childrens[i], "slideDuration", String.valueOf(slideshowDelayInSeconds));
            }
            DOM.appendChild(getElement(), childrens[i]);
        }
        imagesets++;

        if (slideshow) {
            // show the first image
            toggleSlideshowImage(currentIdx);
        }
    }

    /**
     * Overridden method to capture browser event
     *
     * @param event Event object
     */

    public void onBrowserEvent(Event event) {
        switch (DOM.eventGetType(event)) {
            case Event.ONCLICK:
                if (clickListeners != null) {
                    clickListeners.fireClick(this);
                }
                break;
        }
    }

    /**
     * Set background music url. Works fine with mp3 files. Not sure about other formats :)
     *
     * @param backgroundMusicURL String
     */


    public void setBackgroundMusicURL(String backgroundMusicURL) {
        this.backgroundMusicURL = backgroundMusicURL;
    }


    /**
     * Get background music url
     *
     * @return backgroundMusicURL String
     */

    public String getBackgroundMusicURL() {
        return backgroundMusicURL;
    }

    /**
     * Start the slideshow
     */

    public void startSlideshow() {
        if (timer == null) {
            timer = new LightboxImageTimer();
            timer.scheduleRepeating(slideshowDelayInSeconds * 1000);
            slideshowRunning = true;
        }
    }


    /**
     * Stop the slideshow
     */

    public void stopSlideshow() {
        if (timer != null) {
            timer.cancel();
            timer = null;
            slideshowRunning = false;
        }
    }

    /**
     * Returns boolean flag indicating if the slideshow is running
     *
     * @return slideshowRunning boolean
     */

    public boolean isSlideshowRunning() {
        return slideshowRunning;
    }

    /**
     * Utility method to create anchor tags
     *
     * @param image    Image
     * @param relValue anchor "rel" attribute value
     * @return anchorElement Element
     */

    private Element createAnchor(Image image, String relValue) {
        Element anchorElement = DOM.createAnchor();
        DOM.setAttribute(anchorElement, "rel", relValue);
        DOM.setAttribute(anchorElement, "href", image.getUrl());
        DOM.setAttribute(anchorElement, "title", image.getTitle());
        DOM.appendChild(anchorElement, image.getElement());
        return anchorElement;
    }

    /**
     * Set the visibility of all the childrens to the specified value
     *
     * @param visible boolean flag
     */

    private void setAllVisibility(boolean visible) {
        for (int i = 0; i < childrens.length; i++) {
            setVisibility(i, visible);
        }
    }

    /**
     * Set the visibility of particular child for the specified index
     *
     * @param idx Child index
     * @param visible boolean flag
     */

    private void setVisibility(int idx, boolean visible) {
        Element anchorElem = childrens[idx];
        UIObject.setVisible(anchorElem, visible);
    }

    /**
     * Toggles the slideshow image by hiding all the images and displaying only one
     *
     * @param imageIdx Index of the image to show
     */

    public void toggleSlideshowImage(int imageIdx) {
        setAllVisibility(false);
        setVisibility(imageIdx, true);
    }

    /**
     * Is it running in slideshow mode ?
     *
     * @return slideshow boolean flag
     */

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
        if (DOM.getElementById("overlay") != null || DOM.getElementById("lightbox") != null) {
            clear();
        }
        if (childrens != null && slideshow && (backgroundMusicURL != null || slideshowForever)) {
            for (int i = 0; i < childrens.length; i++) {
                Element children = childrens[i];
                setAttribute(children, "music", backgroundMusicURL);
                setAttribute(children, "forever", Boolean.toString(slideshowForever));
            }
        }
        init();
    }

    public void addClickListener(ClickListener listener) {
        if (clickListeners == null) {
            clickListeners = new ClickListenerCollection();
        }
        clickListeners.add(listener);
    }

    public void removeClickListener(ClickListener listener) {
        if (clickListeners != null) {
            clickListeners.remove(listener);
        }
    }

    public boolean isSlideshowForever() {
        return slideshowForever;
    }

    public void setSlideshowForever(boolean slideshowForever) {
        this.slideshowForever = slideshowForever;
    }

    private class LightboxImageTimer extends Timer {

        public void run() {
            setVisibility(prevIdx, false);
            currentIdx++;
            if (currentIdx == childrens.length) {
                currentIdx = 0;
            }
            setVisibility(currentIdx, true);
            prevIdx = currentIdx;
        }
    }

    protected static native void init() /*-{
        $wnd.initLightbox();
    }-*/;

    protected static native void clear() /*-{
        $wnd.Element.remove('overlay');
        $wnd.Element.remove('lightbox');
    }-*/;

    /**
     * Native implementation of DOM.setAttribute(element,attributeName,attributeValue)
     * DOM.setAttribute() doesn't work for non-defined attributes. For eg. <a music="song.mp3" />
     * Hence, this method
     *
     * @param element     DOM element
     * @param attribName  attribute name
     * @param attribValue attribute value
     */
    protected static native void setAttribute(Element element, String attribName, String attribValue) /*-{
        var attrib = $wnd.document.createAttribute(attribName);
        attrib.nodeValue = attribValue;
        element.setAttributeNode(attrib);
    }-*/;

}
