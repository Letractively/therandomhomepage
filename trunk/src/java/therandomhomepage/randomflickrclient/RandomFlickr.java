package therandomhomepage.randomflickrclient;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import org.gwtwidgets.client.wrap.Effect;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Nov 27, 2006
 * Time: 1:36:37 PM
 */
public class RandomFlickr implements EntryPoint {
    public void onModuleLoad() {
        RandomFlickrWidget widget = new RandomFlickrWidget("Random Flickr");
        RootPanel.get("divMain").add(widget);
    }
}
