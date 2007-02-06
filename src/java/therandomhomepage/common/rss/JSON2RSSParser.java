package therandomhomepage.common.rss;


import com.google.gwt.json.client.*;
import com.google.gwt.core.client.GWT;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Jul 8, 2006
 * Time: 11:27:21 PM
 */
public class JSON2RSSParser {

    public static List parse(String jsonText) {
        JSONValue jsonValue;
        List rssItems = null;
        try {
            jsonValue = JSONParser.parse(jsonText);
            if (jsonValue != null) {
                JSONArray jsonArray = jsonValue.isArray();

                if (jsonArray != null) {
                    rssItems = new ArrayList();
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONValue jsonObject = (JSONValue) jsonArray.get(i);
                        rssItems.add(parseChild(jsonObject));
                    }
                }
            }
        } catch (JSONException e) {
        }
        return rssItems;
    }

    public static RSSItem[] parseAsArray(String jsonText,int elementCount) {
        JSONValue jsonValue;
        RSSItem rssItems[] = null;
        try {
            jsonValue = JSONParser.parse(jsonText);
            if (jsonValue != null) {
                if (jsonValue.isArray() != null) {
                    rssItems = new RSSItem[elementCount];
                    for (int i = 0; i < jsonValue.isArray().size() && i < elementCount; i++) {
                        JSONValue jsonObject = (JSONValue) jsonValue.isArray().get(i);
                        rssItems[i] = parseChild(jsonObject);
                    }
                }
                else if (jsonValue.isObject() != null){
                    JSONObject jsonObject = jsonValue.isObject();
                    System.out.println("jsonObject.size() = " + jsonObject.size());

                    JSONObject childObject = (JSONObject) jsonObject.get("ResultSet");

                    if (childObject.isArray() != null) {
                        System.out.println("childObject.isArray().size() = " + childObject.isArray().size());
                    }

                }
            }
        } catch (JSONException e) {
            GWT.log("Unable to parse RSS Items",e);
        }
        return rssItems;
    }

    private static RSSItem parseChild(JSONValue jsonValue) {
        if (jsonValue.isObject() != null) {
            JSONValue title = parseChildAttribute(jsonValue, "title");
            JSONValue link = parseChildAttribute(jsonValue, "link");
            JSONValue guid = parseChildAttribute(jsonValue, "guid");

            if (guid == null) {
                guid = parseChildAttribute(jsonValue, "id");
            }

            JSONValue publishedDate = parseChildAttribute(jsonValue, "pubdate");
            JSONValue description = parseChildAttribute(jsonValue, "description");
            if (description == null) {
                description = parseChildAttribute(jsonValue, "atom_content");
            }

            RSSItem rssItem = new RSSItem(parseString(title), parseString(link), parseString(description));
            rssItem.setGuid(parseString(guid));
            rssItem.setPublishedDate(parseString(publishedDate));
            return rssItem;
        }
        return null;
    }

    private static String parseString(JSONValue str) {
        if (str != null && str.isString() != null){
            return str.isString().stringValue().trim();
        }
        return "";
    }

    private static JSONValue parseChildAttribute(JSONValue childObject, String attributeKey) {
        if (childObject.isObject() != null && childObject.isObject().get(attributeKey) != null) {
            return childObject.isObject().get(attributeKey);
        }
        return null;
    }
}
