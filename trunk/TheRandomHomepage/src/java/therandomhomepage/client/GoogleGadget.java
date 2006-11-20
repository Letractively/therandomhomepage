package therandomhomepage.client;

import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.Window;


/**
 * Created by IntelliJ IDEA.
 * User: sihameed
 * Date: Nov 10, 2006
 * Time: 2:18:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class GoogleGadget extends RandomWidget {

    private String moduleURL = null;

    public GoogleGadget(String header,String moduleURL) {
        super(header);
        this.moduleURL = moduleURL;
        this.setHeight("250px");
        this.setWidth("320px");
    }

    protected void retrieveRandomItem() {
        String url = "/php/GoogleGadget.php?url="+escapeURL(moduleURL);
        Window.alert("Retrieving google gadget with url = "+url);
        Frame gadgetIFrame = new Frame(url);
        gadgetIFrame.setStyleName("googleGadgetIFrame");
        setData(gadgetIFrame);
    }

    public static native String escapeURL(String url) /*-{
        if (url != null) {
            return escape(url);
        }
        return "";
    }-*/;
}
