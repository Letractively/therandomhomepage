package therandomhomepage.common;

import com.google.gwt.user.client.ui.*;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Aug 6, 2006
 * Time: 12:15:23 PM
 */
public abstract class RandomWidget extends Composite implements ClickListener {
    protected String header;
    protected FlexTable table;
    protected static RSSCache cache = new RSSCache();

    protected static final String ERROR_MESSAGE = "Error retrieving content from the list of RSS/Atom feed!. Please make sure that the URL is accessible and it is a valid feed.";

    public RandomWidget(String header) {
        this.header = header;
        buildUI();
        retrieveRandomItem();
    }

    private void buildUI() {
        buildHeader();
        buildBody();
        buildFooter();
    }

    protected void buildHeader() {
        table = new FlexTable();
        table.setCellPadding(2);
        table.setCellSpacing(0);
        table.setWidth("50%");
        table.setText(0, 0, header);
        Label arrow = new Label(">>");
        //noinspection GWTStyleCheck
        arrow.setStyleName("randomWidgetHeader-arrow");
        arrow.addClickListener(this);
        table.setWidget(0, 1, arrow);
        table.getFlexCellFormatter().setColSpan(0, 0, 2);
        table.getRowFormatter().setStyleName(0, "randomWidgetHeader");
    }

    protected void buildBody() {
        setData(new Label("Loading content ..."));
        initWidget(table);
    }

    protected void setData(Widget widget) {
        table.setWidget(1, 0, widget);
        table.getFlexCellFormatter().setColSpan(1, 0, 2);
    }

    protected void buildFooter() {

    }

    protected abstract void retrieveRandomItem();


    public void onClick(Widget sender) {
        retrieveRandomItem();
    }
}
