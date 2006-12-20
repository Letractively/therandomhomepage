package therandomhomepage.widgets.lightboximagedemoclient;

import therandomhomepage.widgets.client.LightboxImage;
import com.google.gwt.user.client.ui.*;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 19, 2006
 * Time: 12:10:58 PM
 */
public class SlideshowLightboxImagePanel extends LightboxImagePanel {
    private static String HEADER = "Slideshow Demo";
    private static VerticalPanel descriptionPanel = new VerticalPanel();
    private static String SNIPPET = "<p><b>Code Snippet :</b><div class=\"codeSnippet\"></div></p>";

    private static LightboxImage lightboxImage = null;

    static {
        Button btnSlideshow = new Button("Start Slideshow");
        btnSlideshow.addClickListener(new SlideshowButtonListener(btnSlideshow));
        descriptionPanel.add(btnSlideshow);
        lightboxImage = createLightboxImage();        
    }


    public SlideshowLightboxImagePanel(){
        super(lightboxImage, HEADER, descriptionPanel, SNIPPET);
    }

    private static LightboxImage createLightboxImage() {
        Image image1 = new Image("image-2.jpg");
        image1.setTitle("Image 1");
        Image image2 = new Image("image-3.jpg");
        image2.setTitle("Image 2");
        Image image3 = new Image("image-4.jpg");
        image3.setTitle("Image 3");

        Image images[] = {image1, image2, image3};

        return new LightboxImage(images,true,3);
    }

    private static class SlideshowButtonListener implements ClickListener {
        private Button button;

        SlideshowButtonListener(Button button) {
            this.button = button;
        }

        public void onClick(Widget sender) {
            if (button.getText().equals("Start Slideshow")) {
                lightboxImage.stopSlideshow();
                button.setText("Stop Slideshow");
            }
            else {
                lightboxImage.startSlideshow();
                button.setText("Start Slideshow");
            }
        }
    }
}
