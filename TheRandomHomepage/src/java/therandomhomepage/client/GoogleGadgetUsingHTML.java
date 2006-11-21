package therandomhomepage.client;

import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.DOM;

public class GoogleGadgetUsingHTML extends HTML {

    private String header;
    private String moduleURL = null;
    private int height;
    private int width;
//    private FlexTable table;

    public GoogleGadgetUsingHTML(String header, String moduleURL,int height,int width) {
        this.header = header;
        this.moduleURL = moduleURL;
        this.height = height;
        this.width = width;
//        buildHeader();
        initWidget();
    }

    private void initWidget() {
        StringBuffer html = new StringBuffer("    <TABLE class=\"ig_reset ig_tbl_line\">\n" +
                "      <TBODY>\n" +
                "        <TR>\n" +
                "          <TD style=\"vertical-align: bottom; text-align: center; width: 100%;\" colspan=\"2\">\n" +
                "            </TD>\n" +
                "        </TR>\n" +
                "        <TR>\n" +
                "          <TD style=\"height: 2px;\">\n" +
                "           </TD>\n" +
                "        </TR>\n" +
                "        <TR>\n" +
                "          <TD colspan=\"2\">\n" +
                "            <DIV style=\"border: 1px solid rgb(153, 153, 153); padding: 3px; background: white none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;\">\n" +
                "              <IFRAME frameborder=\"0\"\n" +
                "                      style=\"display: block; width: 320px; height: 350px;\" src=\"http://gmodules.com/ig/ifr?url=http://www.therandomhomepage.com/google/gadgets/randomwiki/RandomWikiModule.xml&amp;up_moduletitle=Random%20Wikipedia%20Article&amp;up_language=en&amp;synd=open&amp;w=320&amp;h=350&amp;title=&amp;lang=en&amp;country=ALL&amp;border=%23ffffff%7C3px%2C1px+solid+%23999999&amp;source=file%3A%2F%2F%2FC%3A%2Fsid%2Fscratch%2FRandomWikipediaArticle.html\"></IFRAME>\n" +
                "            </DIV>\n" +
                "          </TD>\n" +
                "        </TR>\n" +
                "        <TR>\n" +
                "          <TD style=\"text-align: left;\">\n" +
                "            <A href=\"http://fusion.google.com/ig/add?synd=open&amp;source=ggyp&amp;moduleurl=http://www.therandomhomepage.com/google/gadgets/randomwiki/RandomWikiModule.xml\">\n" +
                "              <IMG src=\"http://gmodules.com/ig/images/plus_google.gif\" style=\"border: 0pt none ; height: 17px; width: 68px;\"/>\n" +
                "            </A>\n" +
                "          </TD>\n" +
                "          <TD style=\"text-align: right; vertical-align: middle;\">\n" +
                "            <A href=\"http://www.google.com/webmasters/gadgets.html\" class=\"ig_smbluelink\">\n" +
                "Gadgets            </A>\n" +
                "            <SPAN class=\"ig_smbluetext\">\n" +
                " powered by Google            </SPAN>\n" +
                "          </TD>\n" +
                "        </TR>\n" +
                "      </TBODY>\n" +
                "    </TABLE>");
        setHTML(html.toString());
    }



    private void retrieveRandomItem() {
        String url = "/php/GoogleGadget.php?url=" + escapeURL(moduleURL);
//        table.setWidget(1, 0, new GoogleGadgetUsingHTML.GadgetIFrame(url,height,width));
    }

    public static native String escapeURL(String url) /*-{
        if (url != null) {
            return escape(url);
        }
        return "";
    }-*/;

    public void onClick(Widget sender) {
        retrieveRandomItem();
    }

    private class GadgetIFrame extends Widget{
        private int height;
        private int width;

        public GadgetIFrame(String url, int height, int width) {
            this.height = height;
            this.width = width;
            Element iframe = DOM.createIFrame();
            DOM.setAttribute(iframe,"frameborder","0");
            DOM.setAttribute(iframe,"src",url);
            DOM.setAttribute(iframe,"border","0");
            DOM.setAttribute(iframe,"scrolling","no");
            setElement(iframe);
            this.setHeight((height+20) +"px");
            this.setWidth((width+20) +"px");
        }
    }

}
