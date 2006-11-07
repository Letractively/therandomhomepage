package therandomhomepage.client.rss;

import therandomhomepage.core.Randomizable;

/**
 * Created by IntelliJ IDEA.
 * User: shameed
 * Date: Jul 6, 2006
 * Time: 11:09:40 AM
 */
public class RSSItem implements Randomizable {
  private String title;
  private String link;
  private String desc;
  private String guid;
  private String publishedDate;

  public RSSItem(String title, String link, String desc) {
    this.title = title;
    this.link = link;
    this.desc = desc;
  }

  public String getTitle() {
    return title;
  }

  public String getLink() {
    return link;
  }

  public String getDesc() {
    return desc;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

  public String getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(String publishedDate) {
    this.publishedDate = publishedDate;
  }

  public String toString() {
    return "RSSItem{" +
            "title='" + title + '\'' +
            ", link='" + link + '\'' +
            ", desc='" + desc + '\'' +
            ", guid='" + guid + '\'' +
            ", publishedDate=" + publishedDate +
            '}';
  }
}