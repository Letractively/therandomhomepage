package therandomhomepage.randomflickrclient;

import com.google.gwt.user.client.ui.Image;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 5, 2006
 * Time: 11:29:33 AM
 */
public class LightboxImage extends Image {

    private String anchorURL = null;
    private String groupName = null;

    public String getAnchorURL() {
        return anchorURL;
    }

    public void setAnchorURL(String anchorURL) {
        this.anchorURL = anchorURL;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
