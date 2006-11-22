package therandomhomepage.client;

import com.google.gwt.user.client.ui.*;

public class AbstractRandomGadget extends HTML {

    private String header;
    private String googleGadgetURL = null;
    private String netvibesModuleURL = null;
    private int height;
    private int width;
    private String iframeURL;

    public AbstractRandomGadget(String header, String googleGadgetURL, String netvibesModuleURL, int width, int height) {
        this.netvibesModuleURL = netvibesModuleURL;
        this.header = header;
        this.googleGadgetURL = getCompleteGoogleGadgetURL(googleGadgetURL);
        this.height = height;
        this.width = width;
        initWidget();
    }

    public AbstractRandomGadget(String header, String iframeURL, int width, int height) {
        this.iframeURL = "/php/ajaxProxy.php?url="+iframeURL+"&loadedIFrameId=myIframe";
        this.header = header;
        this.height = height;
        this.width = width;
        initWidget();
    }

    private String getCompleteGoogleGadgetURL(String url) {
        return "http://gmodules.com/ig/ifr?url=" + url + "&amp;up_moduletitle=" + header + "&amp;up_language=en&amp;synd=open&amp;w=" + width + "&amp;h=" + height + "&amp;title=&amp;lang=en&amp;country=ALL&amp;border=%23ffffff%7C3px%2C1px+solid+%23999999&amp;";
    }

    protected void initWidget() {
        StringBuffer html = new StringBuffer("<TABLE cellspacing=\"0\" cellpadding=\"2\" class=\"ig_reset ig_tbl_line\" align=\"center\">\n" +
                "        <TR>\n" +
                "          <TD valign=\"middle\">\n" +
                "            <DIV class=\"gadgetHeader\">\n" +
                header + "</div>" +
                "           </TD>\n" +
                "        </TR>\n" +
                "        <TR class=\"gadgetFrameTR\">\n" +
                "          <TD>\n" +
                "            <DIV class=\"gadgetFrame\">");
        if (googleGadgetURL != null) {
            html.append("<IFRAME frameborder=\"0\"\n" +
                    "                     style=\"display: block; width: " + width + "px; height: " + height + "px;\" src=\"" + googleGadgetURL + "\"></IFRAME>\n");
        } else {
            html.append("<IFRAME id=\"myIframe\" frameborder=\"0\"\n" +
                    "                     style=\"display: block; width: " + width + "px; height: " + height + "px;\" src=\"" + iframeURL + "\"></IFRAME>\n");

        }

        html.append("            </DIV>\n" +
                "          </TD>\n" +
                "        </TR>\n");


        if (googleGadgetURL != null && netvibesModuleURL != null) {
            html.append("        <TR>\n" +
                    "          <TD class=\"addToTD\">\n" +
                    "            <div>" +
                    "            <A href=\"http://fusion.google.com/ig/add?synd=open&amp;source=ggyp&amp;moduleurl=" + googleGadgetURL + "\">\n" +
                    "              <IMG src=\"http://gmodules.com/ig/images/plus_google.gif\" style=\"border: 0pt none ; height: 17px; \"/>\n" +
                    "            </A>" +
                    "            </div>" +
                    "            <div>" +
                    "            <a href=\"http://www.netvibes.com/subscribe.php?url=\"" + netvibesModuleURL + "&type=api\"><img border=\"0\" src=\"http://www.netvibes.com/img/add2netvibes.gif\" width=\"91\" height=\"17\" alt=\"Add to Netvibes\"/></a>" +
                    "            </div>" +
                    "           </TD>" +
                    "        </TR>\n");
        }

        html.append("    </TABLE>");
        setHTML(html.toString());
    }

}
