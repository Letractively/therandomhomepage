package therandomhomepage.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;

import java.util.Map;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: sihameed
 * Date: Nov 10, 2006
 * Time: 2:18:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class GoogleGadget extends HTML {
    private static String BASE_URL = "http://gmodules.com/ig/ifr?synd=open&title=&output=js";

    private String moduleURL = null;
    private Map preferencesMap;
    private int width = 320;
    private int height = 250;
    private String borderStyle = "%23ffffff%7C3px%2C1px+solid+%23999999";


    public GoogleGadget(String moduleURL) {
        this.moduleURL = moduleURL;
        initWidget();
    }

    public GoogleGadget(String moduleURL, Map preferencesMap) {
        this.moduleURL = moduleURL;
        this.preferencesMap = preferencesMap;
        initWidget();
    }


    private void initWidget() {
//        if (moduleURL != null) {
//            Element scriptElement = DOM.createElement("script");
//            //DOM.setAttribute(scriptElement, "src", getModuleSrc());
//            DOM.setAttribute(scriptElement,"src","http://gmodules.com/ig/ifr?url=http://www.therandomhomepage.com/google/gadgets/randomwiki/RandomWikiModule.xml&up_moduletitle=Random%20Wikipedia%20Article&up_language=en&synd=open&w=320&h=350&title=&lang=en&country=ALL&border=%23ffffff%7C3px%2C1px+solid+%23999999&output=js");
//            this.setElement(scriptElement);
//        } else {
//            Window.alert("Please initialise the module !!!");
//        }
        setHTML("<table class=\"ig_reset ig_tbl_line\"><tbody><tr><td colspan=\"2\" style=\"vertical-align: bottom; text-align: center; width: 100%;\">  </td></tr><tr><td style=\"height: 2px;\"> </td></tr><tr><td colspan=\"2\"><div style=\"border: 1px solid rgb(153, 153, 153); padding: 3px; background: white none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;\"><iframe src=\"http://gmodules.com/ig/ifr?url=http://www.therandomhomepage.com/google/gadgets/randomwiki/RandomWikiModule.xml&amp;up_moduletitle=Random%20Wikipedia%20Article&amp;up_language=en&amp;synd=open&amp;w=320&amp;h=350&amp;title=&amp;lang=de&amp;country=ALL&amp;border=%23ffffff%7C3px%2C1px+solid+%23999999&amp;source=http%3A%2F%2Flocalhost%3A8888%2Ftherandomhomepage.TheRandomHomepage%2FTheRandomHomepage.html\" style=\"display: block; width: 320px; height: 350px;\" frameborder=\"0\"></iframe></div></td></tr><tr><td style=\"text-align: left;\"><a href=\"http://fusion.google.com/ig/add?synd=open&amp;source=ggyp&amp;moduleurl=http://www.therandomhomepage.com/google/gadgets/randomwiki/RandomWikiModule.xml\"><img style=\"border: 0pt none ; height: 17px; width: 68px;\" src=\"http://gmodules.com/ig/images/plus_google.gif\"></a></td><td style=\"text-align: right; vertical-align: middle;\"><a class=\"ig_smbluelink\" href=\"http://www.google.com/webmasters/gadgets.html\">Gadgets</a><span class=\"ig_smbluetext\"> powered by Google</span></td></tr></tbody></table>");
    }


    private String getModuleSrc() {
        StringBuffer srcURL = new StringBuffer(BASE_URL);
        srcURL.append("?url=" + moduleURL);

        if (preferencesMap != null) {
            for (Iterator iterator = preferencesMap.keySet().iterator(); iterator.hasNext();) {
                String key = (String) iterator.next();
                srcURL.append("?" + key + "=" + preferencesMap.get(key));
            }
        }
        srcURL.append("?height=" + height + "&width=" + width);
        return srcURL.toString();
    }

}
