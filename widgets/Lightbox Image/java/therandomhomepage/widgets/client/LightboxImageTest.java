package therandomhomepage.widgets.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 14, 2006
 * Time: 11:24:15 AM
 */
public class LightboxImageTest implements EntryPoint {
    public void onModuleLoad() {
//        LightboxImage lightboxImage = buildSingleImageLightbox();
        LightboxImage lightboxImage = buildMultiImageLightbox();
        RootPanel.get().add(lightboxImage);
    }

    private LightboxImage buildMultiImageLightbox() {
        Image image1 = new Image("lightbox/image-1.jpg");
        Image image2 = new Image("lightbox/image-1.jpg");
        Image image3 = new Image("lightbox/image-1.jpg");
        Image images[] = {image1,image2,image3};
        return new LightboxImage(images);
    }

    private LightboxImage buildSingleImageLightbox() {
        Image image = new Image("lightbox/image-1.jpg");
        return new LightboxImage(image);
    }
}
