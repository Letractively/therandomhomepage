package therandomhomepage.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

public class TheRandomHomepage implements EntryPoint {

  public void onModuleLoad() {
      buildBody();
  }

    private void buildBody() {
        RootPanel mainPanel = RootPanel.get("divBody");
        DockPanel dockPanel = new DockPanel();
        dockPanel.setHeight("100%");

        Grid grid = new Grid(1, 3);


        String randomFeedURL = "http://www.therandomhomepage.com/google/gadget/RandomFeedModule.xml";
        GoogleGadgetUsingHTML randomFeedGadget = new GoogleGadgetUsingHTML("Random News",randomFeedURL,300,300);
        grid.setWidget(0, 0, randomFeedGadget);

        grid.setWidget(0,1,new HTML("<div style='width:10px'>&nbsp;</div>"));

        String randomWikipediaModuleURL = "http://www.therandomhomepage.com/google/gadgets/randomwiki/RandomWikiModule.xml";
        GoogleGadgetUsingHTML randomWikipediaGadget = new GoogleGadgetUsingHTML("Random Wikipedia Article",randomWikipediaModuleURL,350,320);
        grid.setWidget(0, 2, randomWikipediaGadget);
        
        dockPanel.add(grid, DockPanel.CENTER);
        mainPanel.add(dockPanel);
    }
}
