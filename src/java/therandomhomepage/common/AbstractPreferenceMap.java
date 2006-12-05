package therandomhomepage.common;

import org.gwtwidgets.client.util.WindowUtils;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 5, 2006
 * Time: 3:34:55 PM
 */
public abstract class AbstractPreferenceMap extends HashMap {

    protected AbstractPreferenceMap() {
        super(WindowUtils.getLocation().getParameterMap());
    }

    public abstract String[] getPreferenceKeys();

    protected boolean getBoolPrefValue(String prefName) {
        if ((get(prefName) != null) && (get(prefName).toString().equals("1"))) {
            return true;
        }
        return false;
    }

    protected int getIntPrefValue(String prefName) {
        if ((get(prefName) != null)) {
            try {
                return Integer.parseInt(get(prefName).toString());
            } catch (NumberFormatException e) {
                //ignore
            }
        }
        return -1;
    }
}
