package therandomhomepage.client;

import com.google.gwt.user.client.ui.*;

public class AbstractRandomGadget extends HTML {

    private String header;
    private String moduleURL = null;
    private String netvibesModuleURL = null;
    private int height;
    private int width;

    public AbstractRandomGadget(String header, String moduleURL,int height,int width,String netvibesModuleURL) {
        this.netvibesModuleURL = netvibesModuleURL;
        this.header = header;
        this.moduleURL = moduleURL;
        this.height = height;
        this.width = width;
        initWidget();
    }

    protected void initWidget() {
        StringBuffer html = new StringBuffer("<TABLE cellspacing=\"0\" cellpadding=\"2\" class=\"ig_reset ig_tbl_line\" align=\"center\">\n" +
                "        <TR>\n" +
                "          <TD valign=\"middle\">\n" +
                "            <DIV style=\"height:32px; vertical-align: text-bottom; border: 1px solid rgb(153, 153, 153); border-spacing:0; background-image: url(./images/gray_gradient.gif);background-repeat: repeat-x;font-weight: bold; heigth: 30px -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;\">\n" +
                header+"</div>"+
                "           </TD>\n" +
                "        </TR>\n" +
                "        <TR style=\"border: 1px solid rgb(153, 153, 153); border-spacing:0;\">\n" +
                "          <TD>\n" +
                "            <DIV style=\"background: white none repeat scroll 0%; border-left: 1px solid rgb(153, 153, 153);border-bottom: 1px solid rgb(153, 153, 153); border-right: 1px solid rgb(153, 153, 153); border-spacing:0; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;\">\n" +
                "              <IFRAME frameborder=\"0\"\n" +
                "                      style=\"display: block; width: "+width+"px; height: "+height+"px;\" src=\"http://gmodules.com/ig/ifr?url="+moduleURL+"&amp;up_moduletitle="+header+"&amp;up_language=en&amp;synd=open&amp;w="+width+"&amp;h="+height+"&amp;title=&amp;lang=en&amp;country=ALL&amp;border=%23ffffff%7C3px%2C1px+solid+%23999999&amp;\"></IFRAME>\n" +
                "            </DIV>\n" +
                "          </TD>\n" +
                "        </TR>\n" +
                "        <TR>\n" +
                "          <TD style=\"text-align: left;vertical-align: middle; \">\n" +
                "            <div>"+
                "            <A href=\"http://fusion.google.com/ig/add?synd=open&amp;source=ggyp&amp;moduleurl="+moduleURL+"\">\n" +
                "              <IMG src=\"http://gmodules.com/ig/images/plus_google.gif\" style=\"border: 0pt none ; height: 17px; \"/>\n" +
                "            </A>" +
                "            </div>"+
                "            <div>"+
                "            <a href=\"http://www.netvibes.com/subscribe.php?url=\""+netvibesModuleURL+"&type=api\"><img border=\"0\" src=\"http://www.netvibes.com/img/add2netvibes.gif\" width=\"91\" height=\"17\" alt=\"Add to Netvibes\"/></a>"+
                "            </div>"+
                "           </TD>"+
                "        </TR>\n" +
                "    </TABLE>");
        setHTML(html.toString());
    }

}
