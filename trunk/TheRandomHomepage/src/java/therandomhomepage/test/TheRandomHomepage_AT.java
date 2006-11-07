package therandomhomepage.test;

import com.google.gwt.user.client.HTTPRequest;
import therandomhomepage.client.HttpRequestUtil;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Jul 13, 2006
 * Time: 12:25:25 AM
 */
public class TheRandomHomepage_AT extends TheRandomHomepageAbstract_UT {
  public void test() {
    //TODO: URLs to test
    /*
    http://local.randompage.com/scripts/RSSTest.php?url=http://news.google.com/?output=rss
    http://local.randompage.com/scripts/RSS2JSON.php?url=http://news.google.com/?output=rss
    http://local.randompage.com/scripts/GetRandomFeed.php


    TODO: Local params for testing feed
    Success
    ?up_url1=http://news.google.com/?output=atom&up_url2=http://rss.news.yahoo.com/rss/topstories&up_url3=http://rss.news.yahoo.com/rss/us

    One Failure
    ?up_url1=1231312&up_url2=http://rss.news.yahoo.com/rss/topstories&up_url3=http://rss.news.yahoo.com/rss/us

    Two Failure
    ?up_url1=1231312&up_url2=http://rss.news.yahoo.com/rss/topstories&up_url3=http://www.aopworld.com

    All Failure
    ?up_url1=1231312&up_url2=111111&up_url3=http://www.aopworld.com


    TODO: Production params Local for testing feed
    Success
    http://www.therandomhomepage.com/google/gadget/index.html?up_url1=http://news.google.com/?output=atom&up_url2=http://rss.news.yahoo.com/rss/topstories&up_url3=http://rss.news.yahoo.com/rss/us

    One Failure
    http://www.therandomhomepage.com/google/gadget/index.html?up_url1=1231312&up_url2=http://rss.news.yahoo.com/rss/topstories&up_url3=http://rss.news.yahoo.com/rss/us

    Two Failure
    http://www.therandomhomepage.com/google/gadget/index.html?up_url1=1231312&up_url2=http://rss.news.yahoo.com/rss/topstories&up_url3=http://www.aopworld.com

    All Failure
    http://www.therandomhomepage.com/google/gadget/index.html?up_url1=1231312&up_url2=111111&up_url3=http://www.aopworld.com

    TODO: Local params for testing timer
    ?up_autoplay=true&up_delay=5

    */
  }
}