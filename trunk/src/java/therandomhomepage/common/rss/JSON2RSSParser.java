package therandomhomepage.common.rss;


import com.google.gwt.json.client.*;

import java.util.ArrayList;
import java.util.List;

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