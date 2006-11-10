package therandomhomepage.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: sihameed
 * Date: Nov 10, 2006
 * Time: 2:18:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class GoogleGadget extends Composite {    
    private static String BASE_URL = "http://gmodules.com/ig/ifr";

    private String moduleURL = null;
    private Map preferencesMap;


    public GoogleGadget(String moduleURL) {
        this.moduleURL = moduleURL;
    }

    public GoogleGadget(String moduleURL, Map preferencesMap) {
        this.moduleURL = moduleURL;
        this.preferencesMap = preferencesMap;
    }

    protected void onLoad() {
        super.onLoad();
        String src = getModuleSrc();
        ScriptTag tag = new ScriptTag();
        initWidget(tag);
    }

    private String getModuleSrc() {
        StringBuffer stringBuffer = new StringBuffer(BASE_URL);
        stringBuffer.append("?url="+moduleURL);



        //http://gmodules.com/ig/ifr?url=http://www.therandomhomepage.com/google/gadget/RandomFeedModule.xml&up_url1=http%3A%2F%2Fnews.google.com%2F%3Foutput%3Drss&up_url2=&up_url3=&up_autoplay=0&up_delay=10&synd=open&w=320&h=250&title=&border=%23ffffff%7C3px%2C1px+solid+%23999999&output=js

        


        return null;
    }

}
