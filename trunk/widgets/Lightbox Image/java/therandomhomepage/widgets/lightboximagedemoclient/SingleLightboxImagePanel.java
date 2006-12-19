package therandomhomepage.widgets.lightboximagedemoclient;

import com.google.gwt.user.client.ui.Image;
import therandomhomepage.widgets.client.LightboxImage;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 19, 2006
 * Time: 12:10:58 PM
 */
public class SingleLightboxImagePanel extends LightboxImagePanel {

    private static final String HEADER = "Single Image";
    private static final String DESC = "Click on the image to see Lightbox in action";

    public SingleLightboxImagePanel(){
        super(createLightboxImage(), HEADER, DESC);
    }

    private static LightboxImage createLightboxImage() {
        Image image = new Image("lightbox/image-1.jpg");
        image.setTitle("Image 1");
        return new LightboxImage(image);
    }
}
