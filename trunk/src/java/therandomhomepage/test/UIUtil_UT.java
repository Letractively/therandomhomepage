package therandomhomepage.test;

import therandomhomepage.common.StringUtil;
import therandomhomepage.common.HTMLImage;
import therandomhomepage.common.UIUtil;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.DOM;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 5, 2006
 * Time: 11:46:58 AM
 */
public class UIUtil_UT extends TheRandomHomepageAbstract_UT{

    public void testGenerateImageFromInnerHTML() throws Exception{
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
        System.out.println("desc = " + desc);
        String imgInnerHTML = StringUtil.grep(desc, "<IMG", ">");
        Image image = UIUtil.getImageFromInnerHTML(imgInnerHTML);
        assertEquals("http://static.flickr.com/123/310473631_0f69135463_m.jpg",image.getUrl());
    }

    public void testGenerateImageFromInnerHTML_UpperCase() throws Exception{
        String desc = "<P><A HREF=\"HTTP://WWW.FLICKR.COM/PEOPLE/GASTAUM/\">FTRC</A> POSTED A PHOTO:</P>\n" +
                "\n" +
                "<P><A HREF=\"HTTP://WWW.FLICKR.COM/PHOTOS/GASTAUM/310473631/\" TITLE=\"HOTEL GLÓRIA\"><IMG SRC=\"http://static.flickr.com/123/310473631_0f69135463_m.jpg\" WIDTH=\"240\" HEIGHT=\"176\" ALT=\"HOTEL GLÓRIA\" STYLE=\"BORDER: 1PX SOLID #DDD;\" /></A></P>\n" +
                "\n" +
                "<P>HOTEL GLÓRIA<BR />\n" +
                "<BR />\n" +
                "DJS<BR />\n" +
                "<BR />\n" +
                "JOAKIM + MARCOS MORCERF + LUCA &AMP; LIANA + NO PORN<BR />\n" +
                "<BR />\n" +
                "<A HREF=\"HTTP://WWW.CLUBEGLORIA.COM.BR\">WWW.CLUBEGLORIA.COM.BR</A></P>";
        System.out.println("desc = " + desc);
        String imgInnerHTML = StringUtil.grep(desc, "<IMG", ">");
        Image image = UIUtil.getImageFromInnerHTML(imgInnerHTML);
        assertEquals("http://static.flickr.com/123/310473631_0f69135463_m.jpg",image.getUrl());
    }

    public void testGenerateImageFromInnerHTML_UpperCase_SingleQuotes() throws Exception{
        String desc = "<P><A HREF=\"HTTP://WWW.FLICKR.COM/PEOPLE/GASTAUM/\">FTRC</A> POSTED A PHOTO:</P>\n" +
                "\n" +
                "<P><A HREF=\"HTTP://WWW.FLICKR.COM/PHOTOS/GASTAUM/310473631/\" TITLE=\"HOTEL GLÓRIA\"><IMG SRC='http://static.flickr.com/123/310473631_0f69135463_m.jpg' WIDTH=\"240\" HEIGHT=\"176\" ALT=\"HOTEL GLÓRIA\" STYLE=\"BORDER: 1PX SOLID #DDD;\" /></A></P>\n" +
                "\n" +
                "<P>HOTEL GLÓRIA<BR />\n" +
                "<BR />\n" +
                "DJS<BR />\n" +
                "<BR />\n" +
                "JOAKIM + MARCOS MORCERF + LUCA &AMP; LIANA + NO PORN<BR />\n" +
                "<BR />\n" +
                "<A HREF=\"HTTP://WWW.CLUBEGLORIA.COM.BR\">WWW.CLUBEGLORIA.COM.BR</A></P>";
        System.out.println("desc = " + desc);
        String imgInnerHTML = StringUtil.grep(desc, "<IMG", ">");
        Image image = UIUtil.getImageFromInnerHTML(imgInnerHTML);
        assertEquals("http://static.flickr.com/123/310473631_0f69135463_m.jpg",image.getUrl());
    }
}
