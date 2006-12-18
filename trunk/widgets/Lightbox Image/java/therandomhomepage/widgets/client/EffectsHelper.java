package therandomhomepage.widgets.client;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import com.google.gwt.core.client.JavaScriptObject;
import org.gwtwidgets.client.wrap.EffectOption;
import org.gwtwidgets.client.wrap.Effect;
import org.gwtwidgets.client.wrap.Callback;
import org.gwtwidgets.client.style.Color;

/**
 * Effect is a wrapper for the Scriptaculous effects JavaScript library, which
 * can be found at http://script.aculo.us/.
 *
 * Example of using an effect with options:
 *
 * <pre>
 * Effect.highlight(widget, new EffectOption[] { new EffectOption(&quot;startcolor&quot;, &quot;#ff0000&quot;) });
 * </pre>
 *
 * Example of using an effect with a callback:
 *
 * <pre>
 * Callback callback = new Callback(){
 *     public void execute()
 *     {
 *         Window.alert("done!");
 *     }
 * };
 *
 * Effect.fade(widget, new EffectOption[]{new EffectOption("afterFinish", callback)});
 *
 * </pre>
 *
 * Example of using an effect with no options:
 *
 * <pre>
 * Effect.fade(widget);
 * </pre>
 *
 * Example of using an effect on a specific element id:
 *
 * <pre>
 * Effect.switchOff(RootPanel.get(&quot;leftNav&quot;));
 * </pre>
 *
 * You must reference the Scriptaculous JavaScript code in your HTML page to be
 * able to use the wrapper. Failure to do so will result in error messages
 * similar to this, "'$wnd.Effect.Fade' is null or not an object".
 *
 * <pre>
 *
 *   &lt;script type=&quot;text/javascript&quot; src=&quot;script/prototype.js&quot;&gt;&lt;/script&gt;
 *   &lt;script type=&quot;text/javascript&quot; src=&quot;script/effects.js&quot;&gt;&lt;/script&gt;
 * </pre>
 *
 * You will also need to add the gwt-widgets jar file to your project classpath,
 * and add the following reference in your .gwt.xml file:
 *
 * <pre>
 *   &lt;inherits name='org.gwtwidgets.WidgetLibrary'/&gt;
 * </pre>
 *
 * @author Robert Hanson <iamroberthanson[at]gmail.com>
 * @author George Georgovassilis <g.georgovassilis[at]gmail.com>
 */
public class EffectsHelper {
    public static void appear (Widget widget)
    {
        appear(widget.getElement(), null);
    }

    public static void appear (Widget widget, EffectOption[] opts)
    {
        appear(widget.getElement(), buildOptions(opts));
    }

    private native static void appear (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.Appear(element, opts);
    }-*/;

    public static void blindDown (Widget widget)
    {
        blindDown(widget.getElement(), null);
    }

    public static void blindDown (Widget widget, EffectOption[] opts)
    {
        blindDown(widget.getElement(), buildOptions(opts));
    }

    private native static void blindDown (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.BlindDown(element, opts);
    }-*/;

    public static void blindUp (Widget widget)
    {
        blindUp(widget.getElement(), createJsObject());
    }

    public static void blindUp (Widget widget, EffectOption[] opts)
    {
        blindUp(widget.getElement(), buildOptions(opts));
    }

    private native static void blindUp (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.BlindUp(element, opts);
    }-*/;

    public static void dropOut (Widget widget)
    {
        dropOut(widget.getElement(), null);
    }

    public static void dropOut (Widget widget, EffectOption[] opts)
    {
        dropOut(widget.getElement(), buildOptions(opts));
    }

    private native static void dropOut (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.DropOut(element, opts);
    }-*/;

    public static void fade (Widget widget)
    {
        fade(widget.getElement(), null);
    }

    public static void fade (Widget widget, EffectOption[] opts)
    {
        fade(widget.getElement(), buildOptions(opts));
    }

    private native static void fade (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.Fade(element, opts);
    }-*/;

    public static void fold (Widget widget)
    {
        fold(widget.getElement(), null);
    }

    public static void fold (Widget widget, EffectOption[] opts)
    {
        fold(widget.getElement(), buildOptions(opts));
    }

    private native static void fold (Element element, JavaScriptObject opts) /*-{
        $wnd._nativeExtensions = false;
        new $wnd.Effect.Fold(element, opts);
    }-*/;

    public static void grow (Widget widget)
    {
        grow(widget.getElement(), null);
    }

    public static void grow (Widget widget, EffectOption[] opts)
    {
        grow(widget.getElement(), buildOptions(opts));
    }

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
