package therandomhomepage.core;

import com.google.gwt.user.client.Random;

import java.util.List;

import therandomhomepage.client.rss.RSSItem;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Jul 9, 2006
 * Time: 3:38:47 AM
 */
public class Randomizer {

  public static Randomizable getRandomItem(Randomizable[] items) {
    if (items != null) {
      int randomIdx = Random.nextInt(items.length);
      return items[randomIdx];
    }
    return null;
  }

  public static RSSItem getRandomItem(List items) {
    if (items != null) {
      int randomIdx = Random.nextInt(items.size());
      return (RSSItem) items.get(randomIdx);
    }
    return null;
  }

}
