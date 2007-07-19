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

        final Button button = new Button("Click me");
        final Label label = new Label();

        button.addClickListener(new ClickListener() {
            public void onClick(Widget sender) {
                if (label.getText().equals("")) {

//                    String url = "http://spreadsheets.google.com/feeds/cells/pSYncC12rB8CTEnrWbHreeA/od6/public/values?alt=json";
//                    HTTPRequest.asyncGet(url, new CellbasedFeedResponseHandler(txtBox,label));

                    String postDataURL = "http://spreadsheets.google.com/feeds/cells/o13837216796238448969.8709533337254498963/od6/private/full";
                    RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, postDataURL);

                    builder.setHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8");

                    String postContent = "<entry>\n" +
                            "  <gsx:hours>1</gsx:hours>\n" +
                            "  <gsx:ipm>1</gsx:ipm>\n" +
                            "  <gsx:items>60</gsx:items>\n" +
                            "  <gsx:name>Elizabeth Bennet</gsx:name>\n" +
                            "</entry>";

                    try {
                        Request response = builder.sendRequest(postContent, new RequestCallback() {

                            public void onResponseReceived(Request request, Response response) {
                                System.out.println("response = " + response.getText());
                            }

                            public void onError(Request request, Throwable exception) {
                                exception.printStackTrace();
                            }
                        });

                    } catch (RequestException e) {
                        e.printStackTrace();
                    }

                } else
                    label.setText("");
            }
        });

        // Assume that the host HTML has elements defined whose
        // IDs are "slot1", "slot2".  In a real app, you probably would not want
        // to hard-code IDs.  Instead, you could, for example, search for all
        // elements with a particular CSS class and replace them with widgets.
        //
        RootPanel.get("inputSlot").add(txtBox);
        RootPanel.get("slot1").add(button);
        RootPanel.get("slot2").add(label);
    }

    static class MyAsyncCallback implements AsyncCallback {
        public void onSuccess(Object object) {
            DOM.setInnerHTML(label.getElement(), (String) object);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }

        Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }
    }
}
