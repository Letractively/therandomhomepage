/*
 * Copyright 2006 Siddique Hameed <siddii AT gmail.com> - http://www.therandomhomepage.com
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
 * @see <a target="_new" href="http://www.huddletogether.com/projects/lightbox2/">http://www.huddletogether.com/projects/lightbox2/</a>
 *
 * @author Siddique Hameed
 * @version 1.0
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
