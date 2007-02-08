package therandomhomepage.mainclient;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import therandomhomepage.common.RSSCache;

public class AbstractRandomGadget extends Composite {

    protected String header;
    private String googleGadgetURL = null;
    private String netvibesModuleURL = null;
    private String widgetBoxURL;
    protected int height;
    protected int width;
    private String iframeURL;
    protected FlexTable table = new FlexTable();
    protected HTMLPanel bodyPanel;


    public AbstractRandomGadget(String header, String googleGadgetURL, String netvibesModuleURL,String widgetBoxURL, int width, int height) {
        this.header = header;
        this.googleGadgetURL = googleGadgetURL;
        this.netvibesModuleURL = netvibesModuleURL;
        this.widgetBoxURL = widgetBoxURL;
        this.height = height;
        this.width = width;
        buildUI();
    }

    public AbstractRandomGadget(String header, String iframeURL, int width, int height) {
        this.iframeURL = "/php/ajaxProxy.php?url=" + iframeURL + "&loadedIFrameId=myIframe&rightArrows=true";
        this.header = header;
        this.height = height;
        this.width = width;
        buildUI();
    }


    protected String getCompleteGoogleGadgetURL(String url) {
        return "http://gmodules.com/ig/ifr?url=" + url + "&amp;up_moduletitle=" + header + "&amp;up_language=en&amp;synd=open&amp;w=" + width + "&amp;h=" + height + "&amp;title=&amp;lang=en&amp;country=ALL&amp;border=%23ffffff%7C3px%2C1px+solid+%23999999&amp;";
    }

    //TODO: Convert this to HTMLPanel
    protected void buildUI() {
        StringBuffer html = new StringBuffer("<DIV class=\"divGadget\"><TABLE cellspacing=\"0\" cellpadding=\"2\" class=\"ig_reset ig_tbl_line\" align=\"center\">\n" +
                "        <TR>\n" +
                "          <TD class=\"tdGadgetHeader\">\n" +
                "            <DIV title=\"Click on the right arrows(&gt;&gt;) to see next random item.\" class=\"gadgetHeader\">&nbsp;\n" +
                header + "</div>" +
                "           </TD>\n" +
                "        </TR>\n" +
                "        <TR class=\"gadgetFrameTR\">\n" +
                "          <TD>\n" +
                "            <DIV class=\"gadgetFrame\">");
        if (googleGadgetURL != null) {
            html.append("<IFRAME frameborder=\"0\"\n" +
                    "                     style=\"display: block; margin-left: 5px; margin-right: 5px; width: " + width + "px; height: " + height + "px;\" src=\"" + getCompleteGoogleGadgetURL(googleGadgetURL) + "\"></IFRAME>\n");
        } else {
            html.append("<IFRAME id=\"myIframe\" frameborder=\"0\"\n" +
                    "                     style=\"display: block; margin-left: 5px; margin-right: 5px; width: " + width + "px; height: " + height + "px;\" src=\"" + iframeURL + "\"></IFRAME>\n");

        }

        html.append("            </DIV>\n" +
                "          </TD>\n" +
                "        </TR>\n" +
                "<TR><TD style=\"height:2px;\"></TD></TR>");

        if (googleGadgetURL != null && netvibesModuleURL != null) {
            html.append("        <TR>\n" +
                    "          <TD class=\"addToTD\">");
            html.append(getAddToTable());
            html.append("           </TD>" +
                    "        </TR>\n");
        }

        html.append("    </TABLE></DIV>");
        initWidget(new HTML(html.toString()));
    }

    protected String getAddToTable() {
        return "           <TABLE><TR><TD style=\"border: 0pt none ; height: 17px; \">" +
                "            <A href=\"http://fusion.google.com/ig/add?moduleurl=" + googleGadgetURL + "\">\n" +
                "              <IMG src=\"http://gmodules.com/ig/images/plus_google.gif\" style=\"border: 0pt none ; height: 17px; \"/>\n" +
                "            </A>" +
                "            </TD>" +
                "            <TD style=\"width:4px;\">&nbsp;</TD>" +
                "            <TD style=\"border: 0pt none ; width:91px; height: 17px; \">" +
                "            <a href=\"http://www.netvibes.com/subscribe.php?url=" + netvibesModuleURL + "&type=api\"><img border=\"0\" src=\"http://www.netvibes.com/img/add2netvibes.gif\" width=\"91\" height=\"17\" alt=\"Add to Netvibes\"/></a>" +
                "            </TD>" +
                "            <TD style=\"width:4px;\">&nbsp;</TD>" +
                "            <TD style=\"border: 0pt none ; width:91px; height: 17px; \">" +
                "            <a href=\"" + widgetBoxURL + "\" title=\"Get this widget from Widgetbox\"><img src=\"http://widgetserver.com/images/add-widgetbox.gif\" border=\"0\" alt=\"Get this widget from Widgetbox\" /></a>" +
                "            </TD>" +
                "           </TR></TABLE>";

    }

}
