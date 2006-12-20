package therandomhomepage.widgets.lightboximagedemoclient;

import therandomhomepage.widgets.client.LightboxImage;
import com.google.gwt.user.client.ui.Image;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 19, 2006
 * Time: 12:10:58 PM
 */
public class MultiLightboxImagePanel extends LightboxImagePanel {

    private static final String HEADER = "Multiple Images";
    private static final String DESC = "Click on any of the image. Mouse over on top of Lightbox image's right for next or left for previous image.";
    private static final String SNIPPET = "<p><b>Code Snippet :</b><div class=\"codeSnippet\"></div></p>";

    public MultiLightboxImagePanel(){
        super(createLightboxImage(), HEADER, DESC, SNIPPET);
    }
    

    private static LightboxImage createLightboxImage() {
        Image image1 = new Image("image-2.jpg");
        image1.setTitle("Image 2");
        image1.setStyleName("multipleImage");

        Image image2 = new Image("image-3.jpg");
        image2.setTitle("Image 2");
        image2.setStyleName("multipleImage");

        Image image3 = new Image("image-4.jpg");
        image3.setTitle("Image 3");
        image3.setStyleName("multipleImage");

        Image image4 = new Image("image-5.jpg");
        image4.setTitle("Image 4");
        image4.setStyleName("multipleImage");

        Image images[] = {image1, image2, image3, image4};

        return new LightboxImage(images);
    }
}
