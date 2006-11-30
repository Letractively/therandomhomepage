package therandomhomepage.common.rss;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Nov 29, 2006
 * Time: 4:10:41 PM
 */
public class Media {
    private Image content;
    private HTML text;
    private Image thumbnail;

    public Image getContent() {
        return content;
    }

    public void setContent(Image content) {
        this.content = content;
    }

    public HTML getText() {
        return text;
    }

    public void setText(HTML text) {
        this.text = text;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }
}
