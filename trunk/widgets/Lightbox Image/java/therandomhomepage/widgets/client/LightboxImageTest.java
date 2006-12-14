package therandomhomepage.widgets.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 14, 2006
 * Time: 11:24:15 AM
 */
public class LightboxImageTest implements EntryPoint {
    public void onModuleLoad() {        
        Image image = new Image("lightbox/image-1.jpg");
        LightboxImage lightboxImage = new LightboxImage(image);
        RootPanel.get().add(lightboxImage);
    }
}
