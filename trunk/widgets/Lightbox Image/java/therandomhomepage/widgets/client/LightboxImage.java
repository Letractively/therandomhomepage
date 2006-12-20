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
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

/**
 * LightboxImage widget, a GWT wrapper for Lightbox JS by Lokesh Dhakar.
 *
 * @author Siddique Hameed
 * @version 0.1
 * @see <a target="_new" href="http://www.huddletogether.com/projects/lightbox2/">http://www.huddletogether.com/projects/lightbox2/</a>
 */
public class LightboxImage extends Widget {

    private Element childrens[] = null;
    private boolean slideshow;
    private int slideshowDelayInSeconds;
    private static int imagesets = 0;
    private LightboxImageTimer timer = null;

    private int prevIdx = 0;
    private int currentIdx = 0;
    private String mp3URL;

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
        this.slideshow = slideshow;
        this.slideshowDelayInSeconds = slideshowDelayInSeconds;
        Element anchorsDiv = DOM.createDiv();
        childrens = new Element[images.length];
        for (int i = 0; i < images.length; i++) {
            childrens[i] = createAnchor(images[i], "lightbox[" + imagesets + "]");
            DOM.setAttribute(childrens[i], "startslideshow", Boolean.toString(slideshow));
            if (slideshow) {
                DOM.setAttribute(childrens[i], "slideDuration", String.valueOf(slideshowDelayInSeconds));
            }
            DOM.appendChild(anchorsDiv, childrens[i]);
        }
        imagesets++;
        setElement(anchorsDiv);
        if (slideshow) {
            // show the first image
            toggleSlideshowImage(currentIdx);
        }
    }

    public void setSlideshowBackgroundMusicURL(String mp3URL){
        this.mp3URL = mp3URL;
        for (int i = 0; i < childrens.length; i++) {
            Element children = childrens[i];
            DOM.setAttribute(children,"music",mp3URL);
        }
    }


    public String getMp3URL() {
        return mp3URL;
    }

    public void startSlideshow() {
        if (timer == null) {
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
        if (DOM.getElementById("overlay") != null || DOM.getElementById("lightbox") != null) {
            clear();
        }
        init();
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

}
