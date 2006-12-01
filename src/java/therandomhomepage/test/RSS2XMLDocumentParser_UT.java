package therandomhomepage.test;

import com.google.gwt.user.client.ResponseTextHandler;
import therandomhomepage.common.rss.RSS2XMLDocumentParser;
import therandomhomepage.common.rss.RSSItem;

import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Nov 29, 2006
 * Time: 3:55:10 PM
 */
public class RSS2XMLDocumentParser_UT extends TheRandomHomepageAbstract_UT {


    public void testSimpleParsing() throws Exception {
        delayTestFinish(5000);
        readFile("RandomFlickr_RSS_200.xml", new ResponseTextHandler() {
            public void onCompletion(String responseText) {
                processResult(responseText);
            }
        }
        );

    }

    private void processResult(String result) {
        List rssItems = RSS2XMLDocumentParser.parse(result);
        assertEquals(3,rssItems.size());
        for (Iterator iterator = rssItems.iterator(); iterator.hasNext();) {
            RSSItem rssItem = (RSSItem) iterator.next();
            System.out.println("rssItem = " + rssItem);
        }
        finishTest();
    }
}

