package therandomhomepage.widgets.lightboximagedemoclient;

import com.google.gwt.user.client.ui.*;
import therandomhomepage.widgets.client.LightboxImage;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 15, 2006
 * Time: 9:40:47 AM
 */
public abstract class LightboxImagePanel extends Composite {

    private String header;
    private LightboxImage lightboxImage;

    public LightboxImagePanel(LightboxImage lightboxImage, String header, String description, String codeSnippet) {
        this(lightboxImage,header,new HTML(description),codeSnippet);
    }

    public LightboxImagePanel(LightboxImage lightboxImage, String header, Widget description, String codeSnippet) {
        this.header = header;
        this.lightboxImage = lightboxImage;
        VerticalPanel panel = new VerticalPanel();
        panel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        panel.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);

        Label headerLabel = new Label(header);
        panel.add(headerLabel);
        panel.add(description);
        panel.add(lightboxImage);
        panel.add(new HTML(codeSnippet));
        initWidget(panel);
    }

    public String getHeader() {
        return header;
    }

    public LightboxImage getLightboxImage() {
        return lightboxImage;
    }
}
