package therandomhomepage.randomflickrclient;

import therandomhomepage.common.AbstractPreferenceMap;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 5, 2006
 * Time: 1:27:11 PM
 */
public class RandomFlickrPreferenceMap extends AbstractPreferenceMap {
    private static final String TAGS_PREFERENCE_NAME = "up_tags";
    private static final String SLIDESHOW_PREFERENCE_NAME = "up_slideshow";
    private static final String TRANSITION_EFFECT_PREFERENCE_NAME = "up_transition_effect";


    public String[] getPreferenceKeys() {
        return new String[]{TAGS_PREFERENCE_NAME, SLIDESHOW_PREFERENCE_NAME, TRANSITION_EFFECT_PREFERENCE_NAME};
    }

    public String getTags(){
        return (String) get(TAGS_PREFERENCE_NAME);
    }

    public boolean isSlideshow(){
        return getBoolPrefValue(SLIDESHOW_PREFERENCE_NAME);
    }

    public int getTransitionEffectConstant(){
        return getIntPrefValue(TRANSITION_EFFECT_PREFERENCE_NAME);
    }

}
