package therandomhomepage.test;

import therandomhomepage.client.rss.RSSItem;
import therandomhomepage.core.Randomizer;
import com.google.gwt.user.client.Random;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Jul 9, 2006
 * Time: 4:57:24 AM
 */
public class Randomizer_UT extends TheRandomHomepageAbstract_UT {

  public void testGetRandomItem() {
    RSSItem expectedRSSItem1 = new RSSItem("Mexican tells crowd he'll seek recount \n" +
            "    (AP)", "http://us.rd.yahoo.com/dailynews/rss/topstories/*http://news.yahoo.com/s/ap/20060709/ap_on_re_la_am_ca/mexico_elections", "<p><a href=\"http://us.rd.yahoo.com/dailynews/rss/topstories/*http://news.yahoo.com/s/ap/20060709/ap_on_re_la_am_ca/mexico_elections\"><img src=\"http://us.news3.yimg.com/us.i2.yimg.com/p/ap/20060709/capt.5a2fa662f8bc413597f669a36b502eab.mexico_elections__momu107.jpg?x=130&amp;y=83&amp;sig=67xo1gNkImk80pvOmOFUGQ--\" align=\"left\" height=\"83\" width=\"130\" alt=\"A lone flag of the Democratic Revolution Party (PRD) flies over thousands of supporters of Mexican presidential candidate Andres Manuel Lopez Obrador during a rally at the main Zocalo plaza in Mexico City, Mexico on Saturday, July 8, 2006. Obrador called his supporters onto the streets Saturday to protest his rival's narrow victory in a vote he said was more fraudulent than those held during 71 years of one-party rule. (AP Photo/Marco Ugarte) border=\"0\" /></a>AP - Leftist presidential candidate Andres Manuel Lopez Obrador called on a huge crowd of supporters Saturday to keep peacefully protesting as he goes to court to challenge what he called his fraudulent electoral defeat.</p><br clear=all>");
    expectedRSSItem1.setGuid("ap/20060709/mexico_elections");
    expectedRSSItem1.setPublishedDate("Sun, 09 Jul 2006 03:22:54 GMT");

    RSSItem expectedRSSItem2 = new RSSItem("Scores feared dead in Siberia runway crash \n" +
            "    (AP)", "http://us.rd.yahoo.com/dailynews/rss/topstories/*http://news.yahoo.com/s/ap/20060709/ap_on_re_eu/russia_plane_crash", "AP - An airplane carrying about 200 people crashed Sunday in the Siberian city of Irkutsk and most on board were feared dead, officials said.");
    expectedRSSItem2.setGuid("ap/20060709/russia_plane_crash");
    expectedRSSItem2.setPublishedDate("Sun, 09 Jul 2006 03:58:19 GMT");

    RSSItem expectedRSSItem3 = new RSSItem("U.S. seeks to exhume Iraqi girl's remains \n" +
            "    (AP)", "http://us.rd.yahoo.com/dailynews/rss/topstories/*http://news.yahoo.com/s/ap/20060709/ap_on_re_mi_ea/iraq_rape_investigation", "<p><a href=\"http://us.rd.yahoo.com/dailynews/rss/topstories/*http://news.yahoo.com/s/ap/20060709/ap_on_re_mi_ea/iraq_rape_investigation\"><img src=\"http://us.news3.yimg.com/us.i2.yimg.com/p/ap/20060706/capt.505f0de59abc48fb931cf4e851be7378.iraq_bag126.jpg?x=130&amp;y=86&amp;sig=D5Qs9rc_s61I84Jz1d1wvg--\" align=\"left\" height=\"86\" width=\"130\" alt=\"Neighbor and eyewitness Hussein Mohammed, 33, points to the charred ground where clothing of the young Iraqi girl who was allegedly raped then killed along with family members was burned outside of their home, Thursday, July 6, 2006, in Mahmoudiya, south of Baghdad, Iraq. Former US Army Pfc. Steve D. Green was charged Monday in federal court in Charlotte, North Carolina, with rape and four counts of murder. At least four other U.S. soldiers still in Iraq are under investigation in the attack. (AP Photo/Ali al-Mahmouri) border=\"0\" /></a>AP - U.S. investigators have asked Iraqi authorities to help them navigate cultural sensitivities to exhume the body of a teenager allegedly raped and murdered with her family by American soldiers, a military official said Saturday.</p><br clear=all>");
    expectedRSSItem3.setGuid("ap/20060709/iraq_rape_investigation");
    expectedRSSItem3.setPublishedDate("Sun, 09 Jul 2006 02:22:45 GMT");

    RSSItem expectedRSSItem4 = new RSSItem("Astronauts: Daring spacewalk method works \n" +
            "    (AP)", "http://us.rd.yahoo.com/dailynews/rss/topstories/*http://news.yahoo.com/s/ap/20060709/ap_on_sc/space_shuttle", "<p><a href=\"http://us.rd.yahoo.com/dailynews/rss/topstories/*http://news.yahoo.com/s/ap/20060709/ap_on_sc/space_shuttle\"><img src=\"http://us.news3.yimg.com/us.i2.yimg.com/p/ap/20060708/capt.d38cfd8b40774ebe9bb3c06b25ac41be.space_shuttle_txdc116.jpg?x=130&amp;y=97&amp;sig=1lrj6s3UxNaH.vQDoHFKEQ--\" align=\"left\" height=\"97\" width=\"130\" alt=\"In this image made from NASA TV, astronaut Piers Sellers, works on the end of the robotic arm during a spacewalk  Saturday, July 8, 2006.  Sellers is testing how different movements affect the robotic arm.  (AP Photo/NASA TV) border=\"0\" /></a>AP - A key test of a daring yet wobbly spacewalking technique that could be used someday to repair space shuttle heat shields worked well Saturday and got good reviews from two astronauts from the shuttle Discovery, NASA officials said.</p><br clear=all>");
    expectedRSSItem4.setGuid("ap/20060709/space_shuttle");
    expectedRSSItem4.setPublishedDate("Sun, 09 Jul 2006 03:13:06 GMT");

    RSSItem rssItems[] = {expectedRSSItem1, expectedRSSItem2, expectedRSSItem3, expectedRSSItem4};


    boolean item1Randomized = false, item2Randomized = false, item3Randomized = false, item4Randomized = false;
    for (int i = 0; i < (rssItems.length * 5); i++) {
      RSSItem randomItem = (RSSItem) Randomizer.getRandomItem(rssItems);

      if (randomItem.getTitle().equals(expectedRSSItem1.getTitle())) {
        item1Randomized = true;
      } else if (randomItem.getTitle().equals(expectedRSSItem2.getTitle())) {
        item2Randomized = true;
      } else if (randomItem.getTitle().equals(expectedRSSItem3.getTitle())) {
        item3Randomized = true;
      } else if (randomItem.getTitle().equals(expectedRSSItem4.getTitle())) {
        item4Randomized = true;
      }
    }

    assertTrue(item1Randomized);
    assertTrue(item2Randomized);
    assertTrue(item3Randomized);
    assertTrue(item4Randomized);
  }

  public void testGetRandomForZeroIndex() throws Exception{
    int randIdx = Random.nextInt(0);
    System.out.println("randIdx = " + randIdx);
  }
}