package therandomhomepage.lookup.client;

import com.google.gwt.user.client.ResponseTextHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONArray;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Jul 19, 2007
 * Time: 4:03:27 PM
 */
public class CellbasedFeedResponseHandler implements ResponseTextHandler {
    private TextBox txtBox;
    private Label label;

    public CellbasedFeedResponseHandler(TextBox txtBox, Label label) {
        this.txtBox = txtBox;
        this.label = label;
    }

    public void onCompletion(String responseText) {
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
                                JSONObject cellObject = cell.isObject();
                                System.out.println("cellObject = " + cellObject);
                                JSONValue cellStr = cellObject.get("$t");
                                System.out.println("cellStr = " + cellStr);
                                label.setText(cellStr.toString());
                            }
                        }
                    }

            }
        }
    }
}
