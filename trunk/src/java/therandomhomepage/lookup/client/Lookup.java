package therandomhomepage.lookup.client;

import com.google.gwt.core.client.EntryPoint;
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

    private GData gData = null;

    public void onModuleLoad() {
        final TextBox txtBox = new TextBox();

        final Button button = new Button("Show Token");
        final Label answerLabel = new Label();

        gData = new GData();

        button.addClickListener(new ClickListener() {
            public void onClick(Widget sender) {
                gData.lookupAnswer(txtBox.getText(),answerLabel);
            }
        });

        RootPanel.get("tdInput").add(txtBox);
        RootPanel.get("tdButton").add(button);
        RootPanel.get("tdAnswer").add(answerLabel);
    }
}
