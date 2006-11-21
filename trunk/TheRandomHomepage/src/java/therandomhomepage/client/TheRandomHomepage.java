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


//        String randomFeedURL = "http://gmodules.com/ig/ifr?url=http://www.therandomhomepage.com/google/gadget/RandomFeedModule.xml&up_url1=http%3A%2F%2Fnews.google.com%2F%3Foutput%3Drss&up_url2=http%3A%2F%2Frss.news.yahoo.com%2Frss%2Ftopstories&up_url3=http%3A%2F%2Fwww.digg.com%2Frss%2Findex.xml&up_url4=http%3A%2F%2Frss.msnbc.msn.com%2Fid%2F3032091%2Fdevice%2Frss%2Frss.xml&up_url5=http%3A%2F%2Fwww.npr.org%2Frss%2Frss.php%3Fid%3D1001&up_autoplay=0&up_delay=10&synd=open&w=300&h=300&title=&output=js";
//        GoogleGadget randomFeedGadget = new GoogleGadget("Random News",randomFeedURL,300,300);
        GoogleGadgetUsingHTML randomFeedGadget = new GoogleGadgetUsingHTML("","",5,5);
        grid.setWidget(0, 0, randomFeedGadget);

        grid.setWidget(0,1,new HTML("<div style='width:10px'>&nbsp;</div>"));

//        String randomWikipediaModuleURL = "http://gmodules.com/ig/ifr?url=http://www.therandomhomepage.com/google/gadgets/randomwiki/RandomWikiModule.xml&up_moduletitle=Random%20Wikipedia%20Article&up_language=en&synd=open&w=300&h=300&title=&lang=de&country=ALL&border=%23ffffff%7C3px%2C1px+solid+%23999999&output=js";
//        String randomWikipediaModuleURL = "http://gmodules.com/ig/ifr?url=http://www.therandomhomepage.com/google/gadgets/randomwiki/RandomWikiModule.xml&up_moduletitle=Random%20Wikipedia%20Article&up_language=en&synd=open&w=300&h=300&title=&lang=de&country=ALL&output=js";
//        GoogleGadget randomWikipediaGadget = new GoogleGadget("Random Wikipedia Article",randomWikipediaModuleURL,300,300);
        GoogleGadgetUsingHTML randomWikipediaGadget = new GoogleGadgetUsingHTML("","",5,5);
        grid.setWidget(0, 2, randomWikipediaGadget);
        
        dockPanel.add(grid, DockPanel.CENTER);
        mainPanel.add(dockPanel);
    }
}
