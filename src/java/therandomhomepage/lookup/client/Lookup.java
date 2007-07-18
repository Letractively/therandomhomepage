package therandomhomepage.lookup.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.HTTPRequest;
import com.google.gwt.user.client.ResponseTextHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONArray;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Lookup implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        final TextBox txtBox = new TextBox();

        final Button button = new Button("Click me");
        final Label label = new Label();

        button.addClickListener(new ClickListener() {
            public void onClick(Widget sender) {
                if (label.getText().equals("")) {

                    String url = "http://spreadsheets.google.com/feeds/cells/pSYncC12rB8CTEnrWbHreeA/od6/public/values?alt=json";

                    HTTPRequest.asyncGet(url,new ResponseTextHandler(){

                        public void onCompletion(String responseText) {
                            Window.alert("responseText = "+responseText);
                            JSONValue jsonValue = JSONParser.parse(responseText);
                            JSONObject jsonObject = jsonValue.isObject();

                            if (jsonObject != null){
                                JSONValue feedValue = jsonObject.get("feed");
                                if (feedValue != null && feedValue.isObject() != null){
                                    JSONObject feedObject = feedValue.isObject();
                                        JSONValue entryObject = feedObject.get("entry");
                                        if (entryObject != null && entryObject.isArray() != null){
                                            JSONArray entryArray = entryObject.isArray();
                                            for(int i=0; i < entryArray.size(); i++){
                                                JSONValue entryValue = entryArray.get(i);
                                                if (entryValue != null && entryValue.isObject() != null){
                                                    JSONValue cell = entryValue.isObject().get("gs$cell");
                                                    System.out.println("cell.toString() = " + cell.toString());
                                                }
                                            }
                                        }

                                }
                            }

                        }
                    });

//                    LookupService.App.getInstance().getMessage("Hello, World!", new MyAsyncCallback(label));
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
