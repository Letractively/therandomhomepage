package therandomhomepage.widgets.lightboximagedemoclient;

import com.google.gwt.user.client.ui.*;
import therandomhomepage.widgets.client.LightboxImage;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 15, 2006
 * Time: 9:40:47 AM
 */
public class LightboxImagePanel extends Composite {
    private String header;
    private LightboxImage lightboxImage;

    public LightboxImagePanel(LightboxImage lightboxImage, String header, String description) {
        this.header = header;
        this.lightboxImage = lightboxImage;
        VerticalPanel panel = new VerticalPanel();
        panel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        panel.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);

        Label headerLabel = new Label(header);
        panel.add(headerLabel);
        panel.add(new HTML(description));
        panel.add(lightboxImage);
        initWidget(panel);
    }

    public String getHeader() {
        return header;
    }

    public LightboxImage getLightboxImage() {
        return lightboxImage;
    }
}
