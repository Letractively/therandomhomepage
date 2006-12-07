package therandomhomepage.randomflickrclient;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HTML;
import org.gwtwidgets.client.wrap.Effect;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Nov 27, 2006
 * Time: 1:36:37 PM
 */
public class RandomFlickr implements EntryPoint {
    public void onModuleLoad() {
        RandomFlickrWidget widget = new RandomFlickrWidget(new RandomFlickrPreferenceMap());
//        HTML widget = new HTML("<a href='images/image-1.jpg' rel='lightbox'><img src='images/image-1.jpg'/></a>");
        RootPanel divMainPanel = RootPanel.get("divMain");
        divMainPanel.add(widget);
//        EffectsCallback.callLightbox();
    }
}
