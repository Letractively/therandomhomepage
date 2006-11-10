package therandomhomepage.client;

import com.google.gwt.user.client.ui.HTML;

/**
 * Created by IntelliJ IDEA.
 * User: sihameed
 * Date: Nov 10, 2006
 * Time: 12:58:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class ScriptTag extends HTML {
    private String src = null;

    public ScriptTag() {
    }

    public ScriptTag(String src) {
        this.src = src;
    }


    public String getHTML() {
        StringBuffer html = new StringBuffer("<script ");
        if (src != null){
            html.append(" src = \""+src+"\"");
        }
        html.append(" />");
        return html.toString();
    }
}
