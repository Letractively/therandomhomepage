package therandomhomepage.randomflickrclient;

import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Widget;
import org.gwtwidgets.client.wrap.Callback;
import org.gwtwidgets.client.wrap.Effect;
import org.gwtwidgets.client.wrap.EffectOption;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Nov 29, 2006
 * Time: 2:31:48 PM
 */
public class EffectsHelper {

    public static final int RANDOM = -1;
    public static final int FADE = 0;
    public static final int BLINDOWN = 1;
    public static final int BLINDUP = 2;
    public static final int SWITCHOFF = 3;
    public static final int HIGHLIGHT = 4;
    public static final int DROPOUT = 5;
    public static final int SHAKE = 6;
    public static final int PULSATE = 7;
    public static final int SQUISH = 8;
    public static final int FOLD = 9;
    public static final int GROW = 10;
    public static final int SHRINK = 11;
    public static final int PUFF = 12;
    public static final int SLIDEDOWN = 13;
    public static final int SLIDEUP = 14;
    private static final String AFTER_FINISH_EFFECT_OPTION = "afterFinish";


    public static void applyEffects(Widget widget, int effectConst) {
        if (widget != null) {
            switch (effectConst) {
                case RANDOM:
                    int i = Random.nextInt(SLIDEUP);
                    applyEffects(widget, i);
                    break;
                case FADE:
                    Effect.fade(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
                case BLINDOWN:
                    Effect.blindDown(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
                case BLINDUP:
                    Effect.blindUp(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
                case SWITCHOFF:
                    Effect.switchOff(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
                case HIGHLIGHT:
                    Effect.highlight(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
                case DROPOUT:
                    Effect.dropOut(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
                case SHAKE:
                    Effect.shake(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
                case PULSATE:
                    Effect.pulsate(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
                case SQUISH:
                    Effect.squish(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
                case PUFF:
                    Effect.puff(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
                case SLIDEDOWN:
                    Effect.slideDown(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
                case SLIDEUP:
                    Effect.slideUp(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
            }
        }
    }


    public static native void initLightbox() /*-{
        $wnd.initLightbox();
    }-*/;

}
