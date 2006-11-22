package therandomhomepage.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

public class TheRandomHomepage implements EntryPoint {

  public void onModuleLoad() {
      buildBody();
  }

    private void buildBody() {
        RootPanel body = RootPanel.get("divBody");

        FlexTable flexTable = new FlexTable();
        flexTable.setCellPadding(2);
        flexTable.setCellSpacing(5);
        flexTable.setHeight("100%");
        flexTable.setWidth("100%");
        body.add(flexTable);
        
        flexTable.getRowFormatter().setVerticalAlign(0, HasVerticalAlignment.ALIGN_TOP);

        String randomFeedURL = "http://www.therandomhomepage.com/google/gadget/RandomFeedModule.xml";
        String randomFeedNetvibesModuleURL = "http://www.therandomhomepage.com/netvibes/modules/RandomFeed/index.php";
        AbstractRandomGadget randomFeedGadget = new AbstractRandomGadget("Random News",randomFeedURL, randomFeedNetvibesModuleURL, 300, 300);
        flexTable.setWidget(0, 0, randomFeedGadget);
        flexTable.getCellFormatter().setHorizontalAlignment(0,0, HasHorizontalAlignment.ALIGN_CENTER);
        flexTable.getCellFormatter().setWidth(0, 0, "33%");

        String randomWikipediaModuleURL = "http://www.therandomhomepage.com/google/gadgets/randomwiki/RandomWikiModule.xml";
        String randomWikipediaNetvibesModuleURL = "http://www.therandomhomepage.com/netvibes/modules/RandomWikipediaArticle/index.php";
        AbstractRandomGadget randomWikipediaGadget = new AbstractRandomGadget("Random Wikipedia Article",randomWikipediaModuleURL, randomWikipediaNetvibesModuleURL, 320, 350);
        flexTable.setWidget(0, 1, randomWikipediaGadget);
        flexTable.getCellFormatter().setHorizontalAlignment(0,1, HasHorizontalAlignment.ALIGN_CENTER);
        flexTable.getCellFormatter().setWidth(0, 1, "33%");

        String randomQuotesURL = "http://quotes4all.net/quotations.html";
        AbstractRandomGadget randomQuotesWidget = new AbstractRandomGadget("Random Quotes",randomQuotesURL, 300, 300);
        flexTable.setWidget(0, 2, randomQuotesWidget);
        flexTable.getCellFormatter().setHorizontalAlignment(0,2, HasHorizontalAlignment.ALIGN_CENTER);
        flexTable.getCellFormatter().setWidth(0, 2, "33%");

    }

    private void getInnerHTML(String id){
        Element element = DOM.getElementById(id);
        if (element != null) {
            Window.alert(DOM.getInnerHTML(element));
        }
        else {
            Window.alert("iframe not found");            
        }
    }

     public static native void showIFrameHTML(String id) /*-{
        this.@therandomhomepage.client.TheRandomHomepage::getInnerHTML(Ljava/lang/String;)(id);
    }-*/;
}
