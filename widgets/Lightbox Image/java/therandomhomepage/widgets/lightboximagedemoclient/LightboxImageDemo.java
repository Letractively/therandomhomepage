package therandomhomepage.widgets.lightboximagedemoclient;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.WindowResizeListener;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
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
        tabs.add(buildSingleImageLightbox(),"Single Image");
        tabs.add(buildMultiImageLightbox(),"Multiple Image");
        tabs.setHeight("100%");
        tabs.setWidth("100%");
        tabs.selectTab(0);

//        Image image = new Image("lightbox/image-1.jpg");
//        LightboxImage lightboxImage = new LightboxImage(image);
        RootPanel.get().add(tabs);

        addResizeListener();
    }

    private void addResizeListener() {
        Window.addWindowResizeListener(new WindowResizeListener(){

            public void onWindowResized(int width, int height) {
                Element element = DOM.getElementById("lightbox");
                System.out.println("lightbox html = "+DOM.getInnerHTML(element));
                Element overlayElement = DOM.getElementById("overlay");
                System.out.println("Overlay html = "+DOM.getInnerHTML(overlayElement));
            }
        });
    }


    private Panel buildMultiImageLightbox() {
        Image image2 = new Image("lightbox/image-2.jpg");
        Image image3 = new Image("lightbox/image-3.jpg");
        Image image4 = new Image("lightbox/image-4.jpg");
        Image image5 = new Image("lightbox/image-5.jpg");
        Image images[] = {image2, image3, image4, image5};

        VerticalPanel p = new VerticalPanel();
        p.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        p.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);
        LightboxImage lightboxImage = new LightboxImage(images);
        p.add(lightboxImage);

        return p;
    }

    private Panel buildSingleImageLightbox() {
        Image image = new Image("lightbox/image-1.jpg");

        VerticalPanel panel = new VerticalPanel();
        panel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        panel.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);

        panel.add(new Label("Single Image"));
        panel.add(new LightboxImage(image));

        return panel;
    }
}
