package therandomhomepage.client;

import com.google.gwt.user.client.ui.*;

public class AbstractRandomGadget extends HTML {

    private String header;
    private String moduleURL = null;
    private int height;
    private int width;

    public AbstractRandomGadget(String header, String moduleURL,int height,int width) {
        this.header = header;
        this.moduleURL = moduleURL;
        this.height = height;
        this.width = width;
        initWidget();
    }

    protected void initWidget() {
        StringBuffer html = new StringBuffer("<TABLE cellspacing=\"0\" cellpadding=\"2\" class=\"ig_reset ig_tbl_line\" style=\"border: 1px solid rgb(153, 153, 153); border-spacing:0;\">\n" +
                "        <TR>\n" +
                "          <TD valign=\"middle\" colspan=\"2\">\n" +
                "            <DIV style=\"height:32px; vertical-align: text-bottom; border-bottom: 1px solid rgb(153, 153, 153);border-spacing:0px; background-image: url(./images/gray_gradient.gif);background-repeat: repeat-x;font-weight: bold; heigth: 30px -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;\">\n" +
                header+"</div>"+
                "           </TD>\n" +
                "        </TR>\n" +
                "        <TR>\n" +
                "          <TD colspan=\"2\">\n" +
                "            <DIV style=\"background: white none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;\">\n" +
                "              <IFRAME frameborder=\"0\"\n" +
                "                      style=\"display: block; width: "+width+"px; height: "+height+"px;\" src=\"http://gmodules.com/ig/ifr?url="+moduleURL+"&amp;up_moduletitle="+header+"&amp;up_language=en&amp;synd=open&amp;w="+width+"&amp;h="+height+"&amp;title=&amp;lang=en&amp;country=ALL&amp;border=%23ffffff%7C3px%2C1px+solid+%23999999&amp;\"></IFRAME>\n" +
                "            </DIV>\n" +
                "          </TD>\n" +
                "        </TR>\n" +
                "        <TR>\n" +
                "          <TD style=\"text-align: left;\">\n" +
                "            <A href=\"http://fusion.google.com/ig/add?synd=open&amp;source=ggyp&amp;moduleurl="+moduleURL+"\">\n" +
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
                "    </TABLE>");
        setHTML(html.toString());
    }

}
