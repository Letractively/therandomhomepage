package therandomhomepage.common;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 5, 2006
 * Time: 1:23:51 PM
 */
public abstract class AbstractPreferenceMap extends HashMap {


    protected AbstractPreferenceMap() {
        super();
        initPreferenceValues();
    }

    private void initPreferenceValues() {
        String[] preferenceKeys = getPreferenceKeys();
        for (int i = 0; i < preferenceKeys.length; i++) {
            String preferenceKey = preferenceKeys[i];
            put(preferenceKey, "");
        }
    }


    public Object put(Object key, Object value) {
        if (!this.containsKey(key.toString())) {
            logInvalidPreference(key, value);
            return null;
        } else {
            return super.put(key, value);
        }
    }


    public Object get(Object key) {
        if (!this.containsKey(key.toString())) {
            logInvalidPreference(key);
            return null;
        } else {
            return super.get(key);
        }
    }

    private void logInvalidPreference(Object key) {
        System.out.println("Invalid preference. Key = " + key);
    }

    private void logInvalidPreference(Object key, Object value) {
        System.out.println("Invalid preference. Key = " + key + ", value = " + value);
    }

    public abstract String[] getPreferenceKeys();
}
