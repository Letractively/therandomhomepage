package therandomhomepage.common;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HTML;
import therandomhomepage.common.rss.RSSItem;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Aug 6, 2006
 * Time: 12:56:39 PM
 */
public class RSSItemLink extends HTML {
  public RSSItemLink(RSSItem rssItem) {
    super("<a href='" + rssItem.getLink() + "' target='_new'>" + rssItem.getTitle() + "</a>");
    DOM.setAttribute(this.getElement(), "title", rssItem.getTitle());
  }
}
