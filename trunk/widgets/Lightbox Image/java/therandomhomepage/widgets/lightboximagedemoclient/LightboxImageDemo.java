/*
 * Copyright 2006 Siddique Hameed - http://www.therandomhomepage.com
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

package therandomhomepage.widgets.lightboximagedemoclient;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 14, 2006
 * Time: 11:24:15 AM
 */
public class LightboxImageDemo implements EntryPoint {

    public void onModuleLoad() {
        TabPanel tabs = new TabPanel();
        tabs.setWidth("100%");

        tabs.add(new SingleLightboxImagePanel(), "Single Image");
        tabs.add(new ImageSetsPanel(), "Image Sets");
        tabs.add(new SlideshowLightboxImagePanel(), "Slideshow");
        tabs.add(new SlideshowLightboxWithBackgroundMusicPanel(), "Slideshow with music");
        tabs.add(new SetupPanel(), "Setup");

        tabs.selectTab(0);


        RootPanel.get().add(getPageHeader());
        RootPanel.get().add(tabs);
    }

    private Widget getPageHeader() {
        return new HTML("<p><b>Lightbox Image</b> widget, a GWT wrapper for Lightbox JS (<a target=\"_new\" class=\"borderBottom\" href=\"http://www.huddletogether.com/projects/lightbox2/\">http://www.huddletogether.com/projects/lightbox2/)</a>. " +
                "It's a lightweight widget, that overlays image on top of browser window with amazing visual effects. Currently supports single image, image sets, slideshow and background music playback during slideshow." +
                "<ul><b>Features :</b>" +
                "<li>Easier image navigation (Please see '<b>Image Sets</b>' demo)</li>" +
                "<li>Automatic image resizing based on available window size.</li>" +
                "<li>Toggle slideshow.</li>" +
                "<li>Simplified setup and supposed to work on all modern browsers.</li>" +
                "</ul>" +
                "</p>");
    }

}
