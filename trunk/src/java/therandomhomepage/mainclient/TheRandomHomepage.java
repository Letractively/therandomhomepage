package therandomhomepage.mainclient;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Command;

public class TheRandomHomepage implements EntryPoint {

  public void onModuleLoad() {
      buildBody();
  }

    private void buildBody() {
        RootPanel body = RootPanel.get("divBody");

        TabPanel tabs = new TabPanel();
        tabs.setWidth("100%");
        tabs.add(getMainPanel(),"");
        body.add(tabs);
        tabs.selectTab(0);
        tabs.setHeight("70%");

        body.add(getFooter());
    }

    private FlexTable getMainPanel() {
        FlexTable flexTable = new FlexTable();
        flexTable.setCellPadding(2);
        flexTable.setCellSpacing(5);
        flexTable.setHeight("100%");
        flexTable.setWidth("100%");

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
        return flexTable;
    }

    private VerticalPanel getFooter() {
        VerticalPanel footerPanel = new VerticalPanel();
        footerPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        footerPanel.setStyleName("footerPanel");
        DOM.setAttribute(footerPanel.getElement(),"align","center");


        MenuItem home = new MenuItem("TheRandomHomepage",true,new Command(){
            public void execute() {
            }
        });
        home.setStyleName("footerMenuItem");
        MenuItem aboutUs = new MenuItem("What's this site",true,new Command(){
            public void execute() {
            }
        });

        aboutUs.setStyleName("footerMenuItem");

        MenuItem feedback = new MenuItem("Feedback",true,new Command(){
            public void execute() {
            }
        });
        feedback.setStyleName("footerMenuItem");

        MenuBar footerMenu = new MenuBar();
        footerMenu.setStyleName("footerMenuBar");
        footerMenu.addItem(home);
        footerMenu.addItem(aboutUs);
        footerMenu.addItem(feedback);
        DOM.setAttribute(DOM.getFirstChild(footerMenu.getElement()),"align","center");

        footerPanel.add(footerMenu);
        return footerPanel;
    }
}
