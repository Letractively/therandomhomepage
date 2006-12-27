package therandomhomepage.mainclient;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.*;

public class TheRandomHomepage implements EntryPoint {

    TabPanel tabs;

    public void onModuleLoad() {
        buildBody();
    }

    private void buildBody() {

        tabs = new TabPanel();
        tabs.setWidth("100%");

        tabs.add(getMainPanel(), "");
        tabs.add(new AboutUsPanel(), "");
        tabs.add(new DevelopersPanel(), "");
        tabs.add(new FeedbackPanel(), "");


        RootPanel.get().add(tabs);
        tabs.selectTab(0);
        tabs.setHeight("80%");

        RootPanel.get().add(getFooter());
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
        AbstractRandomGadget randomFeedGadget = new AbstractRandomGadget("Random News", randomFeedURL, randomFeedNetvibesModuleURL, 300, 300);
        flexTable.setWidget(0, 0, randomFeedGadget);
        flexTable.getCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_TOP);
        flexTable.getCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
        flexTable.getCellFormatter().setWidth(0, 0, "33%");


        RandomFlickrWidget randomFlickrWidget = new RandomFlickrWidget();
        flexTable.setWidget(0, 1, randomFlickrWidget);
        flexTable.getCellFormatter().setVerticalAlignment(0, 1, HasVerticalAlignment.ALIGN_TOP);
        flexTable.getCellFormatter().setHorizontalAlignment(0, 1, HasHorizontalAlignment.ALIGN_CENTER);
        flexTable.getCellFormatter().setWidth(0, 1, "33%");



        String randomQuotesURL = "http://quotes4all.net/quotations.html";
        AbstractRandomGadget randomQuotesWidget = new AbstractRandomGadget("Random Quotes", randomQuotesURL, 300, 150);
        flexTable.setWidget(1, 1, randomQuotesWidget);
        flexTable.getCellFormatter().setVerticalAlignment(1, 1, HasVerticalAlignment.ALIGN_TOP);
        flexTable.getCellFormatter().setHorizontalAlignment(1, 1, HasHorizontalAlignment.ALIGN_CENTER);
        flexTable.getCellFormatter().setWidth(1, 1, "33%");


        String randomWikipediaModuleURL = "http://www.therandomhomepage.com/google/gadgets/randomwiki/RandomWikiModule.xml";
        String randomWikipediaNetvibesModuleURL = "http://www.therandomhomepage.com/netvibes/modules/RandomWikipediaArticle/index.php";
        AbstractRandomGadget randomWikipediaGadget = new AbstractRandomGadget("Random Wikipedia Article", randomWikipediaModuleURL, randomWikipediaNetvibesModuleURL, 320, 350);
        flexTable.setWidget(0, 2, randomWikipediaGadget);
        flexTable.getCellFormatter().setVerticalAlignment(0, 2, HasVerticalAlignment.ALIGN_TOP);
        flexTable.getCellFormatter().setHorizontalAlignment(0, 2, HasHorizontalAlignment.ALIGN_CENTER);
        flexTable.getCellFormatter().setWidth(0, 2, "33%");

        return flexTable;
    }

    private VerticalPanel getFooter() {
        VerticalPanel footerPanel = new VerticalPanel();
        footerPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        footerPanel.setStyleName("footerPanel");
        DOM.setAttribute(footerPanel.getElement(), "align", "center");

        MenuBar footerMenu = new MenuBar();
        footerMenu.setStyleName("footerMenuBar");

        FooterMenuItem home = new FooterMenuItem("TheRandomHomepage", tabs, 0);
        footerMenu.addItem(home);

        FooterMenuItem aboutUs = new FooterMenuItem("What's this site?", tabs, 1);
        footerMenu.addItem(aboutUs);

        FooterMenuItem developers = new FooterMenuItem("Developers", tabs, 2);
        footerMenu.addItem(developers);

        FooterMenuItem feedback = new FooterMenuItem("Feedback", tabs, 3);
        footerMenu.addItem(feedback);

        DOM.setAttribute(DOM.getFirstChild(footerMenu.getElement()), "align", "center");

        footerPanel.add(footerMenu);
        return footerPanel;
    }
}
