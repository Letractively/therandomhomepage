package therandomhomepage.mainclient;

import com.google.gwt.user.client.*;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.TabPanel;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 26, 2006
 * Time: 9:35:42 AM
 */
public class FooterMenuItem extends MenuItem implements EventListener, Command {
    private TabPanel tabs;
    private int tabIdx;


    public FooterMenuItem(String text, TabPanel tabs,int tabIdx){
        this(text,null);
        this.tabs = tabs;
        this.tabIdx = tabIdx;
    }

    public FooterMenuItem(String text, Command cmd) {
        super(text, cmd);
        setStyleName("footerMenuItem");
        DOM.setEventListener(getElement(),this);
        if (cmd == null) {
            setCommand(this);
        }
    }

    public void onBrowserEvent(Event event) {
        switch (DOM.eventGetType(event)) {
            case Event.ONCLICK: {
                getCommand().execute();
                break;
            }
            case Event.ONMOUSEOVER: {
                addStyleName("footerMenuItemSelected");
                break;
            }

            case Event.ONMOUSEOUT: {
                removeStyleName("footerMenuItemSelected");
                break;
            }
        }

    }

    public void execute() {
        tabs.selectTab(tabIdx);
    }
}
