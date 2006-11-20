package therandomhomepage.client;

import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.DOM;

public class GoogleGadget extends Composite implements ClickListener {

    private String header;
    private String moduleURL = null;
    private int height;
    private int width;
    private FlexTable table;

    public GoogleGadget(String header, String moduleURL,int height,int width) {
        this.header = header;
        this.moduleURL = moduleURL;
        this.height = height;
        this.width = width;
        buildHeader();
        initWidget(table);
        retrieveRandomItem();
    }

    protected void buildHeader() {
        table = new FlexTable();
        table.setCellPadding(0);
        table.setCellSpacing(0);
        table.setText(0, 0, header);
        table.getRowFormatter().setStyleName(0, "randomWidgetHeader");
    }


    private void retrieveRandomItem() {
        String url = "/php/GoogleGadget.php?url=" + escapeURL(moduleURL);
        table.setWidget(1, 0, new GadgetIFrame(url,height,width));
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
            this.setHeight((height+10) +"px");
            this.setWidth((width+10) +"px");
        }
    }

}
