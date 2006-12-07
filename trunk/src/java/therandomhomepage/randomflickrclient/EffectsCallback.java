package therandomhomepage.randomflickrclient;

import com.google.gwt.user.client.ui.Widget;
import org.gwtwidgets.client.wrap.Callback;
import org.gwtwidgets.client.wrap.Effect;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 1, 2006
 * Time: 10:28:43 AM
 */
public class EffectsCallback implements Callback {
    private Widget widget;

    EffectsCallback(Widget widget) {
        this.widget = widget;
    }

    public void execute() {
        if (widget != null) {
            Effect.appear(widget);
            callLightbox();
        }
    }

    public static native void callLightbox() /*-{
        if ($wnd.callLightbox) {
            alert("Calling from widget");
            $wnd.callLightbox();
        }
    }-*/;

}
