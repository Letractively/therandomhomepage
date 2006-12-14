package therandomhomepage.widgets.lightboximagedemoclient;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import therandomhomepage.widgets.client.LightboxImage;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 14, 2006
 * Time: 11:24:15 AM
 */
public class LightboxImageDemo implements EntryPoint {
    public void onModuleLoad() {
        LightboxImage lightboxImage = buildMultiImageLightbox();
        RootPanel.get().add(lightboxImage);
    }

    private LightboxImage buildMultiImageLightbox() {
        Image image1 = new Image("lightbox/image-1.jpg");
        Image image2 = new Image("lightbox/image-2.jpg");
        Image image3 = new Image("lightbox/image-3.jpg");
        Image image4 = new Image("lightbox/image-4.jpg");
        Image image5 = new Image("lightbox/image-5.jpg");
        Image images[] = {image1, image2, image3, image4, image5};
        return new LightboxImage(images);
    }

    private LightboxImage buildSingleImageLightbox() {
        Image image = new Image("lightbox/image-1.jpg");
        return new LightboxImage(image);
    }
}
