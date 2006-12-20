package therandomhomepage.widgets.lightboximagedemoclient;

import therandomhomepage.widgets.client.LightboxImage;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.Window;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 19, 2006
 * Time: 12:10:58 PM
 */
public class SlideshowLightboxWithBackgroundMusicPanel extends LightboxImagePanel {
    private static final String HEADER = "Slideshow With Background Music";
    private static final String DESC = "Slideshow in action";
    private static final String SNIPPET = "<p><b>Code Snippet :</b><div class=\"codeSnippet\"></div></p>";


    public SlideshowLightboxWithBackgroundMusicPanel(){
        super(createLightboxImage(), HEADER, DESC, SNIPPET);
    }

    private static LightboxImage createLightboxImage() {
        Image image1 = new Image("image-2.jpg");
        image1.setTitle("Image 1");
        Image image2 = new Image("image-3.jpg");
        image2.setTitle("Image 2");
        Image image3 = new Image("image-4.jpg");
        image3.setTitle("Image 3");
        Image image4 = new Image("image-5.jpg");
        image4.setTitle("Image 3");

        Image images[] = {image1, image2, image3, image4};

        LightboxImage lightboxImage = new LightboxImage(images, true, 3);
        lightboxImage.setSlideshowBackgroundMusicURL("song.mp3");
        return lightboxImage;
    }
}

