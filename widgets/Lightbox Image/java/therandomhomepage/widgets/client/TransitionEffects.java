package therandomhomepage.widgets.client;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Widget;

public class TransitionEffects {

    public static final int NONE = -1;
    public static final int RANDOM = 0;
    public static final int BLINDOWN = 1;
    public static final int BLINDUP = 2;
    public static final int HIGHLIGHT = 3;
    public static final int DROPOUT = 4;
    public static final int SHAKE = 5;
    public static final int PULSATE = 6;
    public static final int FOLD = 7;
    public static final int GROW = 8;
    public static final int SHRINK = 9;
    public static final int PUFF = 10;
    public static final int SLIDEDOWN = 11;
    public static final int SLIDEUP = 12;
    public static final int FADE = 13;


    public static void applyEffects(Element element, int effectConst) {
        if (element != null) {
            applyNativeEffects(element,effectConst);
        }
    }

    private native static void applyNativeEffects(Element element, int effectConst)/*-{

        callBackOnFinish = function(obj){
                try
                {
                   for(var i in obj.effects){
                     if (!Element.visible(obj.effects[i]['element']))
                     {
                        new Effect.Appear(obj.effects[i]['element']);
                     }
                   }
                }
                catch (e)
                {
                    alert("Error while callback = "+e);
                }
        };

        switch(effectConst){
            case @therandomhomepage.widgets.client.TransitionEffects::BLINDOWN:
                new $wnd.Effect.BlindDown(element,{afterFinish: callBackOnFinish});
                break;
//            case TRANSITION_EFFECT_HIGHLIGHT:
//                new $wnd.Effect.Highlight(element,{afterFinish: callBackOnFinish});
//                break;
//            case TRANSITION_EFFECT_SHAKE:
//                new $wnd.Effect.Shake(element,{afterFinish: callBackOnFinish});
//                break;
//            case TRANSITION_EFFECT_PULSATE:
//                new $wnd.Effect.Pulsate(element,{afterFinish: callBackOnFinish});
//                break;
//            case TRANSITION_EFFECT_GROW:
//                new $wnd.Effect.Grow(element,{afterFinish: callBackOnFinish});
//                break;
//            case TRANSITION_EFFECT_SLIDEDOWN:
//                new $wnd.Effect.SlideDown(element,{afterFinish: callBackOnFinish});
//                break;
        }
    }-*/;
}
