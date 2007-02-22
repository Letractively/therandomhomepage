package therandomhomepage.lightboximagedemoclient;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HTML;
import therandomhomepage.widgets.client.GoogleVideoBar;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 19, 2006
 * Time: 12:10:58 PM
 */
public class TestPanel extends Composite {

    public TestPanel(){
        VerticalPanel panel = new VerticalPanel();
        panel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        panel.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);

        GoogleVideoBar videoBar = new GoogleVideoBar("random");
        panel.add(videoBar);
        initWidget(panel);
    }

}
