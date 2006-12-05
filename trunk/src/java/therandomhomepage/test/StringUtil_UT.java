package therandomhomepage.test;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.Element;
import therandomhomepage.common.rss.RSS2XMLDocumentParser;
import therandomhomepage.common.StringUtil;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 4, 2006
 * Time: 9:00:28 AM
 */
public class StringUtil_UT extends TheRandomHomepageAbstract_UT{

    public void testGrep() throws Exception{
        String desc = "<p><a href=\"http://www.flickr.com/people/gastaum/\">ftrc</a> posted a photo:</p>\n" +
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

        String expectedStr = "<img src=\"http://static.flickr.com/123/310473631_0f69135463_m.jpg\" width=\"240\" height=\"176\" alt=\"hotel glória\" style=\"border: 1px solid #ddd;\" />";

        String actualStr = StringUtil.grep(desc,"<img",">");
        assertEquals(expectedStr,actualStr);

    }

    public void testGrep_CaseInsensitive() throws Exception{
        String desc = "<p><a href=\"http://www.flickr.com/people/gastaum/\">ftrc</a> posted a photo:</p>\n" +
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

        String expectedStr = "<img src=\"http://static.flickr.com/123/310473631_0f69135463_m.jpg\" width=\"240\" height=\"176\" alt=\"hotel glória\" style=\"border: 1px solid #ddd;\" />";

        String actualStr = StringUtil.grep(desc,"<IMG",">");
        assertEquals(expectedStr,actualStr);
    }

    public void testGrep_ExtractSrcFromImg() throws Exception{
        String desc = "<p><a href=\"http://www.flickr.com/people/gastaum/\">ftrc</a> posted a photo:</p>\n" +
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

        String expectedStr = "<img src=\"http://static.flickr.com/123/310473631_0f69135463_m.jpg\" width=\"240\" height=\"176\" alt=\"hotel glória\" style=\"border: 1px solid #ddd;\" />";

        String actualStr = StringUtil.grep(desc,"<IMG",">");
        assertEquals(expectedStr,actualStr);

        String expectedSrc = "\"http://static.flickr.com/123/310473631_0f69135463_m.jpg\"";

        String srcStr = StringUtil.grep(actualStr,"\"","\"");
        assertEquals(expectedSrc,srcStr);
    }
}
