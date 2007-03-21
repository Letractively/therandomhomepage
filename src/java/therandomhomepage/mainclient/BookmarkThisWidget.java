package therandomhomepage.mainclient;

import com.google.gwt.user.client.ui.HTML;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Mar 19, 2007
 * Time: 1:12:05 PM
 */
public class BookmarkThisWidget extends HTML {

    public BookmarkThisWidget() {
        setHTML("<center><a href=\"http://www.addthis.com/bookmark.php\" onclick=\"window.open('http://www.addthis.com/bookmark.php?pub=therandomhomepage.com&url='+encodeURIComponent(location.href)+'&title='+encodeURIComponent(document.title), 'addthis', 'scrollbars=yes,menubar=no,width=620,height=520,resizable=yes,toolbar=no,location=no,status=no,screenX=200,screenY=100,left=200,top=100'); return false;\" title=\"Bookmark using any bookmark manager!\" target=\"_blank\"><img src=\"http://s3.addthis.com/button2-bm.png\" width=\"160\" height=\"24\" border=\"0\" alt=\"AddThis Social Bookmark Button\" /></a></center>");
    }
}
