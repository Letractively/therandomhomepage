package therandomhomepage.widgets.lightboximagedemoclient;

import com.google.gwt.user.client.ui.*;
import therandomhomepage.widgets.client.LightboxImage;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 19, 2006
 * Time: 12:10:58 PM
 */
public class SetupPanel extends Composite {

    public SetupPanel(){
        VerticalPanel panel = new VerticalPanel();
        panel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        panel.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);

        Label headerLabel = new Label("Setup");
        panel.add(headerLabel);
        panel.add(getDescription());

        Image image = new Image("image.jpg");
        image.setTitle("Image Title"); // Not required, but will be used as caption
        LightboxImage lightboxImage = new LightboxImage(image);

        panel.add(lightboxImage);
        panel.add(getCodeSnippet());
        initWidget(panel);
    }

    private HTML getDescription() {
        return new HTML("<br/>Click on the image to see Lightbox in action.<br/><br/>");
    }

    private HTML getCodeSnippet() {
        return new HTML("<h3>&nbsp;&nbsp;&nbsp;Code Snippet : </h3><pre class=\"code\">        Image image = new Image(\"image.jpg\");\n" +
                "        image.setTitle(\"Image Title\"); // Not required, but will be used as caption\n" +
                "        LightboxImage lightboxImage = new LightboxImage(image);</pre>");
    }
}
