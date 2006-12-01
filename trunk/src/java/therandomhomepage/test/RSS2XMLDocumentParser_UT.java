package therandomhomepage.test;

import com.google.gwt.user.client.ResponseTextHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Image;
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


    public void testParseSingleNode() throws Exception {
        delayTestFinish(5000);
        readFile("RandomFlickr_RSS_200_SingleNode.xml", new ResponseTextHandler() {
            public void onCompletion(String responseText) {
                processResult(responseText);
            }
        }
        );

    }

    private void processResult(String result) {
        List rssItems = RSS2XMLDocumentParser.parse(result);
        assertEquals(1,rssItems.size());
        for (Iterator iterator = rssItems.iterator(); iterator.hasNext();) {
            RSSItem rssItem = (RSSItem) iterator.next();
            System.out.println("rssItem = " + rssItem);
            assertEquals("hotel glória",rssItem.getTitle());
            assertEquals("http://www.flickr.com/photos/gastaum/310473631/",rssItem.getLink());
            String expectedDesc = "<p><a href=\"http://www.flickr.com/people/gastaum/\">ftrc</a> posted a photo:</p>\n" +
                    "\n" +
                    "<p><a href=\"http://www.flickr.com/photos/gastaum/310473631/\" title=\"hotel glória\"><img src=\"http://static.flickr.com/123/310473631_0f69135463_m.jpg\" width=\"240\" height=\"176\" alt=\"hotel glória\" style=\"border: 1px solid #ddd;\" /></a></p>\n" +
                    "\n" +
                    "<p>hotel glória<br />\n" +
                    "<br />\n" +
                    "djs<br />\n" +
                    "<br />\n" +
                    "joakim + marcos morcerf + luca &amp; liana + no porn<br />\n" +
                    "<br />\n" +
                    "<a href=\"http://www.clubegloria.com.br\">www.clubegloria.com.br</a></p>";
            System.out.println("rssItem.getDesc() = " + rssItem.getDesc());
            assertEquals(expectedDesc,rssItem.getDesc());

            String expectedContentImage = "<IMG class=gwt-Image style=\"WIDTH: 240px; HEIGHT: 176px\" height=176 src=\"http://static.flickr.com/123/310473631_0f69135463_m.jpg\" width=240 __eventBits=\"98429\" onchange=\"null\">";

            assertEquals(expectedContentImage,rssItem.getMedia().getContent().toString());
        }
        finishTest();
    }
}

