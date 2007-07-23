package therandomhomepage.lookup.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.*;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Lookup implements EntryPoint {

    /**
     * This is the entry point method.
     */

    //cell-based feed http://spreadsheets.google.com/feeds/cells/o13837216796238448969.8709533337254498963/od6/private/full

    //POST-URL http://spreadsheets.google.com/feeds/cells/o13837216796238448969.8709533337254498963/od6/private/full
    public void onModuleLoad() {
        final TextBox txtBox = new TextBox();

        final Button button = new Button("Show Token");
        final Label label = new Label();

        Authentication.login();

        button.addClickListener(new ClickListener() {
            public void onClick(Widget sender) {
                label.setText(Authentication.getToken());
                GData gdata = new GData();
                gdata.showMetafeed();
            }
        });

        RootPanel.get("inputSlot").add(txtBox);
        RootPanel.get("slot1").add(button);
        RootPanel.get("slot2").add(label);
    }
}
