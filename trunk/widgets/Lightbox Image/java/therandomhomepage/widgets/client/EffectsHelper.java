package therandomhomepage.widgets.client;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Random;
import com.google.gwt.core.client.JavaScriptObject;
import org.gwtwidgets.client.wrap.EffectOption;
import org.gwtwidgets.client.wrap.Effect;
import org.gwtwidgets.client.wrap.Callback;
import org.gwtwidgets.client.style.Color;
import therandomhomepage.randomflickrclient.EffectsCallback;

public class EffectsHelper {

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
    private static final String AFTER_FINISH_EFFECT_OPTION = "afterFinish";


    public static void applyEffects(Widget widget, int effectConst) {
        
        System.out.println("EffectsHelper.applyEffects effectConst = "+effectConst);
        if (widget != null) {
            switch (effectConst) {
                case RANDOM:
                    int i = Random.nextInt(SLIDEUP);
                    applyEffects(widget, i);
                    break;
                case FADE:
//                    fade(widget.getElement(), new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
                case BLINDOWN:
//                    Effect.blindDown(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
                case BLINDUP:
//                    Effect.blindUp(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
                case HIGHLIGHT:
//                    Effect.highlight(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
                case DROPOUT:
//                    Effect.dropOut(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
                case SHAKE:
//                    Effect.shake(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
                case PULSATE:
//                    Effect.pulsate(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
                case PUFF:
//                    Effect.puff(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
                case SLIDEDOWN:
//                    Effect.slideDown(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
                case SLIDEUP:
//                    Effect.slideUp(widget, new EffectOption[]{new EffectOption(AFTER_FINISH_EFFECT_OPTION, new EffectsCallback(widget))});
                    break;
            }
        }
    }

    private native static void appear (Element element, JavaScriptObject opts) /*-{
        new $wnd.Effect.Appear(element, opts);
    }-*/;


    private native static void blindDown (Element element, JavaScriptObject opts) /*-{
        new $wnd.Effect.BlindDown(element, opts);
    }-*/;

    private native static void blindUp (Element element, JavaScriptObject opts) /*-{
        new $wnd.Effect.BlindUp(element, opts);
    }-*/;

    private native static void dropOut (Element element, JavaScriptObject opts) /*-{
        new $wnd.Effect.DropOut(element, opts);
    }-*/;

    private native static void fade (Element element, JavaScriptObject opts) /*-{
        new $wnd.Effect.Fade(element, opts);
    }-*/;

    private native static void fold (Element element, JavaScriptObject opts) /*-{
        new $wnd.Effect.Fold(element, opts);
    }-*/;

    private native static void grow (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.Grow(element, opts);
    }-*/;

    public static void highlight (Widget widget)
    {
        highlight(widget.getElement(), null);
    }

    public static void highlight (Widget widget, EffectOption[] opts)
    {
        highlight(widget.getElement(), buildOptions(opts));
    }

    public static void highlight (Widget widget, Color startColor, Color endColor, double duration)
    {
        highlight(widget, new EffectOption[] {
                new EffectOption("startcolor", startColor.getHexValue()),
                new EffectOption("endcolor", endColor.getHexValue()),
                new EffectOption("duration", duration) });
    }

    private native static void highlight (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.Highlight(element, opts);
    }-*/;

    public static void keepFixed (Widget widget)
    {
        keepFixed(widget.getElement(), null);
    }

    public static void keepFixed (Widget widget, EffectOption[] opts)
    {
        keepFixed(widget.getElement(), buildOptions(opts));
    }

    private native static void keepFixed (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.KeepFixed(element, opts);
    }-*/;

    public static void move (Widget widget)
    {
        move(widget.getElement(), null);
    }

    public static void move (Widget widget, EffectOption[] opts)
    {
        move(widget.getElement(), buildOptions(opts));
    }

    private native static void move (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.Move(element, opts);
    }-*/;


    public static void moveBy (Widget widget, int y, int x)
    {
        moveBy(widget.getElement(), y, x, null);
    }

    public static void moveBy (Widget widget, int y, int x, EffectOption[] opts)
    {
        moveBy(widget.getElement(), y, x, buildOptions(opts));
    }

    /**
     * @depricated bad method, doesn't work
     */
    public static void moveBy (Widget widget)
    {
        moveBy(widget.getElement(), null);
    }

    /**
     * @depricated bad method, doesn't work
     */
    public static void moveBy (Widget widget, EffectOption[] opts)
    {
        moveBy(widget.getElement(), buildOptions(opts));
    }

    private native static void moveBy (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.MoveBy(element, opts);
    }-*/;

    private native static void moveBy (Element element, int y, int x, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.MoveBy(element, y, x, opts);
    }-*/;


    public static void opacity (Widget widget)
    {
        opacity(widget.getElement(), null);
    }

    public static void opacity (Widget widget, EffectOption[] opts)
    {
        opacity(widget.getElement(), buildOptions(opts));
    }

    private native static void opacity (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.Opacity(element, opts);
    }-*/;

    public static void parallel (Widget widget)
    {
        parallel(widget.getElement(), null);
    }

    public static void parallel (Widget widget, EffectOption[] opts)
    {
        parallel(widget.getElement(), buildOptions(opts));
    }

    private native static void parallel (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.Parallel(element, opts);
    }-*/;

    public static void puff (Widget widget)
    {
        puff(widget.getElement(), null);
    }

    public static void puff (Widget widget, EffectOption[] opts)
    {
        puff(widget.getElement(), buildOptions(opts));
    }

    private native static void puff (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.Puff(element, opts);
    }-*/;

    public static void pulsate (Widget widget)
    {
        pulsate(widget.getElement(), null);
    }

    public static void pulsate (Widget widget, EffectOption[] opts)
    {
        pulsate(widget.getElement(), buildOptions(opts));
    }

    private native static void pulsate (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.Pulsate(element, opts);
    }-*/;

    public static void scale (Widget widget)
    {
        scale(widget.getElement(), null);
    }

    public static void scale (Widget widget, EffectOption[] opts)
    {
        scale(widget.getElement(), buildOptions(opts));
    }

    private native static void scale (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.Scale(element, opts);
    }-*/;

    public static void scrollTo (Widget widget)
    {
        scrollTo(widget.getElement(), null);
    }

    public static void scrollTo (Widget widget, EffectOption[] opts)
    {
        scrollTo(widget.getElement(), buildOptions(opts));
    }

    private native static void scrollTo (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.ScrollTo(element, opts);
    }-*/;

    public static void shake (Widget widget)
    {
        shake(widget.getElement(), null);
    }

    public static void shake (Widget widget, EffectOption[] opts)
    {
        shake(widget.getElement(), buildOptions(opts));
    }

    private native static void shake (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.Shake(element, opts);
    }-*/;

    public static void shrink (Widget widget)
    {
        shrink(widget.getElement(), null);
    }

    public static void shrink (Widget widget, EffectOption[] opts)
    {
        shrink(widget.getElement(), buildOptions(opts));
    }

    private native static void shrink (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.Shrink(element, opts);
    }-*/;

    public static void slideDown (Widget widget)
    {
        slideDown(widget.getElement(), null);
    }

    public static void slideDown (Widget widget, EffectOption[] opts)
    {
        slideDown(widget.getElement(), buildOptions(opts));
    }

    private native static void slideDown (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.SlideDown(element, opts);
    }-*/;

    public static void slideUp (Widget widget)
    {
        slideUp(widget.getElement(), null);
    }

    public static void slideUp (Widget widget, EffectOption[] opts)
    {
        slideUp(widget.getElement(), buildOptions(opts));
    }

    private native static void slideUp (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.SlideUp(element, opts);
    }-*/;

    public static void squish (Widget widget)
    {
        squish(widget.getElement(), null);
    }

    public static void squish (Widget widget, EffectOption[] opts)
    {
        squish(widget.getElement(), buildOptions(opts));
    }

    private native static void squish (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.Squish(element, opts);
    }-*/;

    public static void switchOff (Widget widget)
    {
        switchOff(widget.getElement(), null);
    }

    public static void switchOff (Widget widget, EffectOption[] opts)
    {
        switchOff(widget.getElement(), buildOptions(opts));
    }

    private native static void switchOff (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.SwitchOff(element, opts);
    }-*/;



    public static void toggle (Widget w, String fxFamily, EffectOption[] opts)
    {
        toggle(w.getElement(), fxFamily, buildOptions(opts));
    }

    public static void toggle (Widget w, String fxFamily)
    {
        toggle(w.getElement(), fxFamily, null);
    }

    private native static void toggle(Element element, String fxFamily, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.toggle(element, fxFamily, opts);
    }-*/;





    private static JavaScriptObject buildOptions (EffectOption[] opts)
    {
        JavaScriptObject jso = createJsObject();
        for (int i = 0; i < opts.length; i++) {
            Object value = opts[i].getValue();
            if (value instanceof Callback)
                addCallback(jso, opts[i].getName(), new CallbackDelegate((Callback) value));
            else
                addOption(jso, opts[i].getName(), value);
        }
        return jso;
    }

    private static native void addCallback (JavaScriptObject jso, String name,
            CallbackDelegate callback) /*-{
        jso[name] = function(obj)
        {
            callback.@org.gwtwidgets.client.wrap.CallbackDelegate::execute()();
        };
    }-*/;

    private static native void addOption (JavaScriptObject jso, String name, Object value) /*-{
        jso[name] = value;
    }-*/;

    private static native JavaScriptObject createJsObject () /*-{
        return new Object();
    }-*/;

}
