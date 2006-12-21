package therandomhomepage.widgets.lightboximagedemoclient;

import com.google.gwt.user.client.ui.*;
import therandomhomepage.widgets.client.LightboxImage;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 19, 2006
 * Time: 12:10:58 PM
 */
public class ImageSetsPanel extends Composite {

    public ImageSetsPanel() {
        VerticalPanel panel = new VerticalPanel();
        panel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        panel.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);

        Label headerLabel = new Label("Image Sets Demo");
        panel.add(headerLabel);
        panel.add(getDescription());

        Image image1 = new Image("image-1.jpg");
        image1.setTitle("Image 1");
        image1.setStyleName("imageset");

        Image image2 = new Image("image-2.jpg");
        image2.setTitle("Image 2");
        image2.setStyleName("imageset");

        Image image3 = new Image("image-3.jpg");
        image3.setTitle("Image 3");
        image3.setStyleName("imageset");

        Image image4 = new Image("image-4.jpg");
        image4.setTitle("Image 4");
        image4.setStyleName("imageset");

        Image image5 = new Image("image-5.jpg");
        image5.setTitle("Image 5");
        image5.setStyleName("imageset");

        Image images[] = {image1, image2, image3, image4, image5};
        LightboxImage lightboxImage = new LightboxImage(images);
        panel.add(lightboxImage);

        panel.add(getCodeSnippet());
        initWidget(panel);
    }

    private HTML getDescription() {
        return new HTML("<br/>Click on any of the image to see lightbox effect. Mouse over on Lightbox image's <b>top right</b> for 'next' or <b>top left</b> for 'previous' image.<br/>During lightbox effect, press '<b>N</b>' for next image, '<b>P</b>' for previous image, or '<b>X</b>' to close.<br/><br/>");
    }

    private HTML getCodeSnippet() {
        return new HTML("<h3>&nbsp;&nbsp;&nbsp;Code Snippet : </h3><pre class=\"code\">        Image image1 = new Image(\"image-1.jpg\");\n" +
                "        image1.setTitle(\"Image 1\");\n" +
                "        image1.setStyleName(\"imageset\");\n" +
                "\n" +
                "        Image image2 = new Image(\"image-2.jpg\");\n" +
                "        image2.setTitle(\"Image 2\");\n" +
                "        image2.setStyleName(\"imageset\");\n" +
                "\n" +
                "        Image image3 = new Image(\"image-3.jpg\");\n" +
                "        image3.setTitle(\"Image 3\");\n" +
                "        image3.setStyleName(\"imageset\");\n" +
                "\n" +
                "        Image image4 = new Image(\"image-4.jpg\");\n" +
                "        image4.setTitle(\"Image 4\");\n" +
                "        image4.setStyleName(\"imageset\");\n" +
                "        \n" +
                "        Image image5 = new Image(\"image-5.jpg\");\n" +
                "        image4.setTitle(\"Image 5\");\n" +
                "        image4.setStyleName(\"imageset\");\n" +
                "\n" +
                "        Image images[] = {image1, image2, image3, image4, image5};\n" +
                "        LightboxImage lightboxImage = new LightboxImage(images);</pre>");
    }
}
