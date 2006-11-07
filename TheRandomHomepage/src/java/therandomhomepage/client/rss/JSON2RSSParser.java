package therandomhomepage.client.rss;


import com.google.gwt.json.client.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Jul 8, 2006
 * Time: 11:27:21 PM
 */
public class JSON2RSSParser {

    public static RSSItem[] parse(String jsonText) {

        JSONValue jsonValue;
        RSSItem rssItems[] = null;
        try {
            jsonValue = JSONParser.parse(jsonText);
            if (jsonValue != null) {

                JSONArray jsonArray = jsonValue.isArray();

                if (jsonArray != null) {
                    rssItems = new RSSItem[jsonArray.size()];
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                        rssItems[i] = parseChildrens(jsonObject);
                    }
                }
            }
        } catch (JSONException e) {
        }
        return rssItems;
    }

    public static List parseAndReturnRSSItems(String jsonText) {
        JSONObject jsonObject;
        List rssItems = new ArrayList();
        try {
            jsonObject = (JSONObject) JSONParser.parse(jsonText);

            JSONArray jsonArray = jsonObject.isArray();
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONValue jsonValue = jsonArray.get(i);

                }
                /*
                Set keys = jsonObject.keySet();

                for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
                    String key = (String) iterator.next();
                    rssItems.add(JSON2RSSParser.parseChildrens(jsonObject, key));
                }
                */

            }
        } catch (JSONException e) {
        }
        return rssItems;
    }

    private static RSSItem parseChildrens(JSONObject jsonObject) {
        if (jsonObject.isObject() != null) {
            JSONValue title = parseChildAttribute(jsonObject, "title");
            JSONValue link = parseChildAttribute(jsonObject, "link");
            JSONValue guid = parseChildAttribute(jsonObject, "guid");
            JSONValue publishedDate = parseChildAttribute(jsonObject, "pubdate");
            JSONValue description = parseChildAttribute(jsonObject, "description");

            RSSItem rssItem = new RSSItem(parseString(title), parseString(link), parseString(description));
            rssItem.setGuid(parseString(guid));
            rssItem.setPublishedDate(parseString(publishedDate));
            return rssItem;
        }
        return null;
    }

    private static String parseString(JSONValue title) {
        return title != null ? title.toString().trim() : "";
    }

    private static JSONValue parseChildAttribute(JSONValue childObject, String attributeKey) {
        if (childObject.isObject() != null && childObject.isObject().get(attributeKey) != null) {
            return childObject.isObject().get(attributeKey);
        }
        return null;
    }
}
