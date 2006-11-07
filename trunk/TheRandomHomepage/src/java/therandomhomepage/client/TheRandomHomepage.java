package therandomhomepage.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

public class TheRandomHomepage implements EntryPoint {

  public void onModuleLoad() {
    buildPageUsingDockPanel();
  }

  private void buildPageUsingDockPanel() {

    RootPanel mainPanel = RootPanel.get("divMain");
    DockPanel dockPanel = new DockPanel();
    dockPanel.setHeight("100%");

    Logo logo = new Logo();
    logo.setHeight("40%");
    dockPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_CENTER);
    dockPanel.add(logo, DockPanel.NORTH);

    Grid grid = new Grid(1, 3);
    grid.setCellSpacing(5);

    RandomNewsWidget newsWidget = new RandomNewsWidget("Random News");
    newsWidget.setSize("100%", "100%");
    grid.setWidget(0, 0, newsWidget);
//    grid.setBorderWidth(2);
    grid.getCellFormatter().setWidth(0, 0, "33%");

    RandomQuotesWidget quotesWidget = new RandomQuotesWidget("Random Quotes");
    quotesWidget.setSize("100%", "100%");
    grid.setWidget(0, 1, quotesWidget);
    grid.getCellFormatter().setWidth(0, 1, "33%");

    RandomRecipeWidget recipeWdiget = new RandomRecipeWidget("Random Recipe");
    recipeWdiget.setSize("100%", "100%");
    grid.setWidget(0, 2, recipeWdiget);
    grid.getCellFormatter().setWidth(0, 2, "33%");

    grid.getRowFormatter().setVerticalAlign(0, HasVerticalAlignment.ALIGN_TOP);

    dockPanel.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);
    dockPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_CENTER);
    dockPanel.add(grid, DockPanel.CENTER);
    mainPanel.add(dockPanel);
  }
}
