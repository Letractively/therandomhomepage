package therandomhomepage.lightboximagedemoclient;

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

        HTML frameHTML = new HTML("<IFRAME scrolling=\"no\" frameborder=\"0\"\n" +
                    "                     style=\"display: block; margin-left: 5px; margin-right: 5px; width: 100%; height: 400px;\" src=\"setup.html\"></IFRAME>");
        panel.add(frameHTML);

        initWidget(panel);
    }

}
