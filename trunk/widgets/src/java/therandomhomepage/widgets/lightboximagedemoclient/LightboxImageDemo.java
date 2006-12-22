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
import therandomhomepage.widgets.client.LightboxImage;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 14, 2006
 * Time: 11:24:15 AM
 */
public class LightboxImageDemo implements EntryPoint {


    public void onModuleLoad() {
        TabPanel tabs = new TabPanel();
        tabs.setHeight("100%");
        tabs.setWidth("100%");

        tabs.add(buildSingleImageLightboxPanel(),"Single Image");
        tabs.add(buildMultiImageLightboxPanel(),"Multiple Images");
        tabs.add(buildMultiImageLightboxPanelWithSlideShow(),"Slideshow");

        tabs.addTabListener(new TabSelectionListener());

        tabs.selectTab(0);


        RootPanel.get().add(getPageHeader());
        RootPanel.get().add(tabs);
    }

    private Widget getPageHeader() {
        return new HTML("<p<b>Lightbox Image</b>, a GWT wrapper implementation for Lightbox JS by Lokesh Dhakar(<a target=\"_new\" href=\"http://www.huddletogether.com/projects/lightbox2/\">http://www.huddletogether.com/projects/lightbox2/</a>)" +
                "<ul>Features :" +
                "<li>built on top of prototype.js, scriptaculous(effects.js) & Lightbox JS</li>"+
                "<li>single image and multi-image with slideshow</li>"+
                "</ul>" +
                "</p>");
    }

    private LightboxImagePanel buildSingleImageLightboxPanel() {
        Image image = new Image("lightbox/image-1.jpg");
        image.setTitle("Image 1");
        LightboxImage lightboxImage = new LightboxImage(image);

        String desc = "Click on the image to see Lightbox in action";
        return new LightboxImagePanel(lightboxImage, "Single Image", desc);
    }


    private LightboxImagePanel buildMultiImageLightboxPanel() {
        Image image1 = new Image("lightbox/image-2.jpg");
        image1.setTitle("Image 2");
        image1.setStyleName("multipleImage");

        Image image2 = new Image("lightbox/image-3.jpg");
        image2.setTitle("Image 2");
        image2.setStyleName("multipleImage");

        Image image3 = new Image("lightbox/image-4.jpg");
        image3.setTitle("Image 3");
        image3.setStyleName("multipleImage");

        Image image4 = new Image("lightbox/image-5.jpg");
        image4.setTitle("Image 4");
        image4.setStyleName("multipleImage");

        Image images[] = {image1, image2, image3, image4};

        String desc = "Click on the image to see Lightbox in action. Mouse over on top of Lightbox image's right for next or left for previous image.";

        LightboxImage lightboxImage = new LightboxImage(images);
        return new LightboxImagePanel(lightboxImage, "Multiple Images", desc);
    }

    private LightboxImagePanel buildMultiImageLightboxPanelWithSlideShow() {
        Image image1 = new Image("lightbox/image-2.jpg");
        image1.setTitle("Image 1");
        Image image2 = new Image("lightbox/image-3.jpg");
        image2.setTitle("Image 2");
        Image image3 = new Image("lightbox/image-4.jpg");
        image3.setTitle("Image 3");
        Image image4 = new Image("lightbox/image-5.jpg");
        image4.setTitle("Image 3");

        Image images[] = {image1, image2, image3, image4};
        
        LightboxImage lightboxImage = new LightboxImage(images,true,3);

        String desc = "Click on the image to see Lightbox in action. Mouse over on top of Lightbox image's right for next or left for previous image.";

        return new LightboxImagePanel(lightboxImage, "Slideshow", desc);
    }

    private class TabSelectionListener implements TabListener{

        public boolean onBeforeTabSelected(SourcesTabEvents sender, int tabIndex) {
            return true;
        }

        public void onTabSelected(SourcesTabEvents sender, int tabIndex) {
            TabPanel tabPanel = (TabPanel) sender;

            LightboxImagePanel panel = (LightboxImagePanel) tabPanel.getWidget(tabIndex);
            if (panel.getHeader().equals("Slideshow")){
                panel.getLightboxImage().startSlideshow();
            }
        }
    }


}
