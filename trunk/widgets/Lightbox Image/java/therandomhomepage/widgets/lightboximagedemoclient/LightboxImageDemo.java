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
        tabs.add(buildMultiImageLightboxPanel(),"Multiple Image");
        tabs.add(buildMultiImageLightboxPanelWithSlideShow(),"Slideshow");

        tabs.addTabListener(new TabSelectionListener());

        tabs.selectTab(0);
        RootPanel.get().add(tabs);
    }

    private LightboxImagePanel buildSingleImageLightboxPanel() {
        Image image = new Image("lightbox/image-1.jpg");
        image.setTitle("Image 1");
        LightboxImage lightboxImage = new LightboxImage(image);
        return new LightboxImagePanel("Single Image",lightboxImage);
    }


    private LightboxImagePanel buildMultiImageLightboxPanel() {
        Image image1 = new Image("lightbox/image-2.jpg");
        image1.setTitle("Image 1");
        Image image2 = new Image("lightbox/image-3.jpg");
        image2.setTitle("Image 2");
        Image image3 = new Image("lightbox/image-4.jpg");
        image3.setTitle("Image 3");
        Image image4 = new Image("lightbox/image-5.jpg");
        image4.setTitle("Image 3");

        Image images[] = {image1, image2, image3, image4};

        LightboxImage lightboxImage = new LightboxImage(images);
        return new LightboxImagePanel("Multiple Images",lightboxImage);
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
        
        LightboxImage lightboxImage = new LightboxImage(images,true,2);
        return new LightboxImagePanel("Slideshow",lightboxImage);
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
