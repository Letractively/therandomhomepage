package therandomhomepage.common;

import com.google.gwt.user.client.ResponseTextHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Aug 6, 2006
 * Time: 12:15:23 PM
 */
public abstract class RandomWidget extends Composite implements ClickListener {
    protected String header;
    private FlexTable table = new FlexTable();
    protected static RSSCache cache = new RSSCache();
    protected boolean shouldBeRunning = false;

    protected static final String ERROR_MESSAGE = "Error retrieving content !. Please try later...";
    protected AbstractPreferenceMap preferenceMap;

    public RandomWidget(AbstractPreferenceMap preferenceMap) {
        this.preferenceMap = preferenceMap;
        buildUI();
        retrieveRandomItem();
    }

    private void buildUI() {
        initTable();
        setContent(new Label("Loading..."));
    }

    private void initTable() {
        table.getCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
        table.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);
        table.setCellPadding(2);
        table.setCellSpacing(0);
        initWidget(table);
    }

    protected void addStarter() {
        Image start = new Image("images/start.png");
        start.addClickListener(new StartListener());
        setActionWidget(start);
    }

    protected void addStopper() {
        Image stop = new Image("images/stop.png");
        stop.addClickListener(new StopListener());
        setActionWidget(stop);
    }

    protected void setActionWidget(Widget stop) {
        table.setWidget(0, 1, stop);
    }

    protected void addArrow() {
        Label arrow = new Label(">>");
        arrow.setStyleName("randomWidgetHeader-arrow");
        setActionWidget(arrow);
        arrow.addClickListener(this);
    }

    protected void setHeader(String header) {
        table.setWidget(0, 0, new Label(header));
    }

    protected void setContent(Widget widget) {
        table.setWidget(1, 0, widget);
        table.getFlexCellFormatter().setColSpan(1, 0, 2);
    }

    protected void retrieveRandomItem() {
        String url = getFeedURL();
        if (cache.getFromCache(url) == null) {
            if (!HttpRequestUtil.sendAsyncGetRequest(url, new FeedResponseHandler(url))) {
                showError();
            }
        } else {
            List itemList = cache.getFromCache(url);
            displayRandomItem(itemList);
        }
    }

    protected void showError() {
        setContent(new Label(ERROR_MESSAGE));
    }

    protected abstract void displayRandomItem(List itemList);

    public abstract String getFeedURL();

    protected abstract void handleResponse(String url, String responseText);


    public void onClick(Widget sender) {
        retrieveRandomItem();
    }

    private void addStartStopControl() {
        if (shouldBeRunning) {
            addStopper();
        } else {
            addStarter();
        }
    }

    protected class WidgetTimer extends Timer {
        public void run() {
            if (shouldBeRunning) {
                retrieveRandomItem();
            }
        }
    }

    protected class StartListener implements ClickListener {
        public void onClick(Widget sender) {
            shouldBeRunning = true;
            addStartStopControl();
        }
    }

    private class StopListener implements ClickListener {
        public void onClick(Widget sender) {
            shouldBeRunning = false;
            addStartStopControl();
        }
    }

    protected class FeedResponseHandler implements ResponseTextHandler {
        private String url;

        public FeedResponseHandler(String url) {
            this.url = url;
        }

        public void onCompletion(String responseText) {
            if (!HttpRequestUtil.isErrorResponse(responseText)) {
                handleResponse(url, responseText);
            }
        }

    }

}
