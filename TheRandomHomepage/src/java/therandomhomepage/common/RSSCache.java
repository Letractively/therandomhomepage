package therandomhomepage.common;

import java.util.HashMap;
import java.util.List;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: shameed
 * Date: Jul 14, 2006
 * Time: 4:46:45 PM
 */
public class RSSCache {
  private HashMap rssMap = new HashMap();
  private HashMap cachedTimeMap = new HashMap();
  private static int DEFAULT_CACHE_DURATION = 1000 * 60 * 10; // 10 minutes

  public void addToCache(String url, List rssItemList) {
    rssMap.put(url, rssItemList);
    cachedTimeMap.put(url, new Date());
  }

  public boolean existsInCache(String url) {
    return rssMap.containsKey(url);
  }

  public List getFromCache(String url) {

    if (existsInCache(url)) {
      if (!isCacheExpired(url)) {
        return (List) rssMap.get(url);
      } else {
        removeFromCache(url);
      }
    }

    return null;
  }

  private void removeFromCache(String url) {
    rssMap.remove(url);
    cachedTimeMap.remove(url);
  }

  public boolean isCacheExpired(String url) {
    if (cachedTimeMap.containsKey(url)) {
      Date now = new Date();
      Date cachedTime = (Date) cachedTimeMap.get(url);
      return (now.getTime() - cachedTime.getTime() >= RSSCache.DEFAULT_CACHE_DURATION) ;
    }
    return true;
  }
}
