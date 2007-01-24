package therandomhomepage.test;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ResponseTextHandler;
import com.google.gwt.user.client.HTTPRequest;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Jul 9, 2006
 * Time: 5:08:01 AM
 */
public abstract class TheRandomHomepageAbstract_UT extends GWTTestCase {
    public String getModuleName() {
        return "therandomhomepage.TheRandomHomepageTest";
    }

    protected void readFile(String fileName, ResponseTextHandler responseHandler) {
//        if (!HTTPRequest.asyncGet(GWT.getModuleBaseURL()+"/readfile?fileName="+fileName,responseHandler)){
//            fail("Unable to read file - "+fileName);
//        }
        if (!HTTPRequest.asyncGet(GWT.getModuleBaseURL()+"/"+fileName,responseHandler)){
            fail("Unable to read file - "+fileName);
        }
    }
}
