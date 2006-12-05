package therandomhomepage.randomflickrclient;

import therandomhomepage.common.AbstractPreferenceMap;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 5, 2006
 * Time: 1:27:11 PM
 */
public class RandomFlickrPreferenceMap extends AbstractPreferenceMap {

    public String[] getPreferenceKeys() {
        return new String[]{"up_tags","up_transition_effect"};
    }
}
