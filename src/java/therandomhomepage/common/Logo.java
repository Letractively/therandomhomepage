package therandomhomepage.common;

import com.google.gwt.user.client.ui.*;

/**
 * Created by IntelliJ IDEA.
 * User: shameed
 * Date: Jul 5, 2006
 * Time: 1:26:55 PM
 */
public class Logo extends Composite {
  public Logo() {
    HorizontalPanel panel = new HorizontalPanel();
    Image logo = new Image("images/logos/logo.png");
    logo.setSize("531px","108px");
    panel.setHorizontalAlignment(HorizontalPanel.ALIGN_CENTER);
    panel.add(logo);
    setWidget(panel);
  }
}
