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
        tabs.add(new MultiLightboxImagePanel(), "Image Sets");
        tabs.add(new SlideshowLightboxImagePanel(), "Slideshow");
        tabs.add(new SlideshowLightboxWithBackgroundMusicPanel(), "Slideshow with music");

        tabs.addTabListener(new TabSelectionListener());

        tabs.selectTab(0);


        RootPanel.get().add(getPageHeader());
        RootPanel.get().add(tabs);
    }

    private Widget getPageHeader() {
        return new HTML("<p><b>Lightbox Image</b> widget, a GWT wrapper for Lightbox JS (<a target=\"_new\" class=\"borderBottom\" href=\"http://www.huddletogether.com/projects/lightbox2/\">http://www.huddletogether.com/projects/lightbox2/)</a>. " +
                "Lightbox JS is an <I>unobtrusive</I> script used for overlaying image on browser window and it was built on top of prototype.js & scriptaculous (effects.js)." +
                "<ul><b>Features :</b>" +
                "<li>Single and Image Sets with slideshow feature</li>" +
                "<li>Easier image navigation (Please see '<b>Image Sets</b>' demo)</li>" +
                "<li>Automatic image resizing based on available window size.</li>" +
                "<li>Toggle slideshow.</li>" +
                "<li>Background music while slideshow</li>" +
                "<li>Easy installation and supposed to work on all modern browsers.</li>" +
                "</ul>" +
                "</p>");
    }

    private class TabSelectionListener implements TabListener {

        public boolean onBeforeTabSelected(SourcesTabEvents sender, int tabIndex) {
            return true;
        }

        public void onTabSelected(SourcesTabEvents sender, int tabIndex) {
            TabPanel tabPanel = (TabPanel) sender;

            LightboxImagePanel panel = (LightboxImagePanel) tabPanel.getWidget(tabIndex);
            if (panel.getHeader().equals("Slideshow")) {
                panel.getLightboxImage().startSlideshow();
            }
        }
    }


}
