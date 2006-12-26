package therandomhomepage.mainclient;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 26, 2006
 * Time: 10:06:06 AM
 */
public class AboutUsPanel extends Composite {


    public AboutUsPanel() {
        VerticalPanel panel = new VerticalPanel();
        panel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        panel.setVerticalAlignment(VerticalPanel.ALIGN_TOP);

        HTML frameHTML = new HTML("<IFRAME scrolling=\"no\" frameborder=\"0\"\n" +
                " style=\"display: block; margin-left: 5px; margin-right: 5px; width: 70%; height: 500px;\" src=\"AboutUs.html\"></IFRAME>");
        panel.add(frameHTML);

        initWidget(panel);
    }
}
