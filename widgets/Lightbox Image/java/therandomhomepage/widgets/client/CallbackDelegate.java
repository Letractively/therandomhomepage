package therandomhomepage.widgets.client;

import org.gwtwidgets.client.wrap.Callback;

/**
 * In GWT 1.0.21 JSNI insists on knowing the precise implementing class of the method being invoked,
 * which does not allow for interfaces. Thus we provide an internal wrapper around the interface which
 * in turn provides the 'precise implementation class' to JSNI.
 * @author george georgovassilis
 *
 */
class CallbackDelegate implements Callback {
    private Callback callback;



    public CallbackDelegate(Callback callback)
    {
        this.callback = callback;
    }

    public void execute ()
    {
        callback.execute();
    }
}
