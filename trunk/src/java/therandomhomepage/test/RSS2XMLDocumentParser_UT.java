package therandomhomepage.test;

import com.google.gwt.user.client.HTTPRequest;
import com.google.gwt.user.client.ResponseTextHandler;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.core.client.GWT;
import therandomhomepage.common.rss.RSS2XMLDocumentParser;
import therandomhomepage.common.rss.RSSItem;

import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Nov 29, 2006
 * Time: 3:55:10 PM
 */
public class RSS2XMLDocumentParser_UT extends TheRandomHomepageAbstract_UT {

    private String testXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<rss version=\"2.0\"\n" +
            "        xmlns:media=\"http://search.yahoo.com/mrss\"\n" +
            "\txmlns:dc=\"http://purl.org/dc/elements/1.1/\"\n" +
            "        >\n" +
            "\t<channel>\n" +
            "\t\t<title>colorful - Everyone's Tagged Photos</title>\n" +
            "\t\t<link>http://www.flickr.com/photos/tags/colorful/</link>\n" +
            " \t\t<description>A feed of colorful - Everyone's Tagged Photos</description>\n" +
            "\t\t<pubDate>Wed, 29 Nov 2006 05:34:14 -0800</pubDate>\n" +
            "\t\t<lastBuildDate>Wed, 29 Nov 2006 05:34:14 -0800</lastBuildDate>\n" +
            "\n" +
            "\t\t<generator>http://www.flickr.com/</generator>\n" +
            "\t\t<image>\n" +
            "\t\t\t<url>http://www.flickr.com/images/buddyicon.jpg</url>\n" +
            "\t\t\t<title>colorful - Everyone's Tagged Photos</title>\n" +
            "\t\t\t<link>http://www.flickr.com/photos/tags/colorful/</link>\n" +
            "\t\t</image>\n" +
            "\n" +
            "\t\t<item>\n" +
            "\t\t\t<title>bali - balinese girl</title>\n" +
            "\t\t\t<link>http://www.flickr.com/photos/adlaw/309470872/</link>\n" +
            "\t\t\t<description>&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/adlaw/&quot;&gt;adlaw&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/adlaw/309470872/&quot; title=&quot;bali - balinese girl&quot;&gt;&lt;img src=&quot;http://static.flickr.com/117/309470872_370a5d93b6_m.jpg&quot; width=&quot;180&quot; height=&quot;240&quot; alt=&quot;bali - balinese girl&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;Pura Pengastulan, Sawangan, Nusa Dua, Bali, Indonesia&lt;/p&gt;</description>\n" +
            "\t\t\t<pubDate>Wed, 29 Nov 2006 05:34:14 -0800</pubDate>\n" +
            "                        <dc:date.Taken>2006-10-21T17:53:41-08:00</dc:date.Taken>\n" +
            "\t\t\t<author>nobody@flickr.com (adlaw)</author>\n" +
            "\t\t\t<guid isPermaLink=\"false\">tag:flickr.com,2004:/photo/309470872</guid>\n" +
            "\n" +
            "\n" +
            "\t\t\t<media:content url=\"http://static.flickr.com/117/309470872_370a5d93b6_o.jpg\"\n" +
            "\t\t\t\t       type=\"image/jpeg\"\n" +
            "\t\t\t\t       height=\"3264\"\n" +
            "\t\t\t\t       width=\"2448\"/>\n" +
            "\t\t\t<media:title>bali - balinese girl</media:title>\n" +
            "\t\t\t<media:text type=\"html\">&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/adlaw/&quot;&gt;adlaw&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/adlaw/309470872/&quot; title=&quot;bali - balinese girl&quot;&gt;&lt;img src=&quot;http://static.flickr.com/117/309470872_370a5d93b6_m.jpg&quot; width=&quot;180&quot; height=&quot;240&quot; alt=&quot;bali - balinese girl&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;Pura Pengastulan, Sawangan, Nusa Dua, Bali, Indonesia&lt;/p&gt;</media:text>\n" +
            "\t\t\t<media:thumbnail url=\"http://static.flickr.com/117/309470872_370a5d93b6_s.jpg\" height=\"75\" width=\"75\" />\n" +
            "\t\t\t<media:credit role=\"photographer\">adlaw</media:credit>\n" +
            "\t\t\t<media:category scheme=\"urn:flickr:tags\">travel bali cute girl beautiful indonesia colorful asia southeastasia balinese sarung</media:category>\n" +
            "\n" +
            "\t\t</item>\n" +
            "\t\t<item>\n" +
            "\n" +
            "\t\t\t<title>colorful Chirstmas tree, angels, and fireworks</title>\n" +
            "\t\t\t<link>http://www.flickr.com/photos/55046882@N00/309469067/</link>\n" +
            "\t\t\t<description>&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/55046882@N00/&quot;&gt;veyan1977&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/55046882@N00/309469067/&quot; title=&quot;colorful Chirstmas tree, angels, and fireworks&quot;&gt;&lt;img src=&quot;http://static.flickr.com/103/309469067_0193da9be5_m.jpg&quot; width=&quot;160&quot; height=&quot;240&quot; alt=&quot;colorful Chirstmas tree, angels, and fireworks&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</description>\n" +
            "\t\t\t<pubDate>Wed, 29 Nov 2006 05:31:02 -0800</pubDate>\n" +
            "                        <dc:date.Taken>2006-11-25T17:50:09-08:00</dc:date.Taken>\n" +
            "\t\t\t<author>nobody@flickr.com (veyan1977)</author>\n" +
            "\t\t\t<guid isPermaLink=\"false\">tag:flickr.com,2004:/photo/309469067</guid>\n" +
            "\n" +
            "\t\t\t<media:content url=\"http://static.flickr.com/103/309469067_0193da9be5_o.jpg\" \n" +
            "\t\t\t\t       type=\"image/jpeg\"\n" +
            "\t\t\t\t       height=\"800\"\n" +
            "\t\t\t\t       width=\"533\"/>\n" +
            "\t\t\t<media:title>colorful Chirstmas tree, angels, and fireworks</media:title>\n" +
            "\n" +
            "\t\t\t<media:text type=\"html\">&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/55046882@N00/&quot;&gt;veyan1977&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/55046882@N00/309469067/&quot; title=&quot;colorful Chirstmas tree, angels, and fireworks&quot;&gt;&lt;img src=&quot;http://static.flickr.com/103/309469067_0193da9be5_m.jpg&quot; width=&quot;160&quot; height=&quot;240&quot; alt=&quot;colorful Chirstmas tree, angels, and fireworks&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</media:text>\n" +
            "\t\t\t<media:thumbnail url=\"http://static.flickr.com/103/309469067_0193da9be5_s.jpg\" height=\"75\" width=\"75\" />\n" +
            "\t\t\t<media:credit role=\"photographer\">veyan1977</media:credit>\n" +
            "\t\t\t<media:category scheme=\"urn:flickr:tags\">christmas light tree japan angel colorful usj themepark universalstudio ??????</media:category>\n" +
            "\n" +
            "\t\t</item>\n" +
            "\t\t<item>\n" +
            "\t\t\t<title>A Little Color for the Girls</title>\n" +
            "\n" +
            "\t\t\t<link>http://www.flickr.com/photos/pinksherbet/309462667/</link>\n" +
            "\t\t\t<description>&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/pinksherbet/&quot;&gt;Pink Sherbet Photography&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/pinksherbet/309462667/&quot; title=&quot;A Little Color for the Girls&quot;&gt;&lt;img src=&quot;http://static.flickr.com/110/309462667_c936ac97e4_m.jpg&quot; width=&quot;232&quot; height=&quot;240&quot; alt=&quot;A Little Color for the Girls&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;A Little Color for the Girls&lt;/p&gt;</description>\n" +
            "\t\t\t<pubDate>Wed, 29 Nov 2006 05:18:36 -0800</pubDate>\n" +
            "                        <dc:date.Taken>2006-11-25T15:21:38-08:00</dc:date.Taken>\n" +
            "\t\t\t<author>nobody@flickr.com (Pink Sherbet Photography)</author>\n" +
            "\t\t\t<guid isPermaLink=\"false\">tag:flickr.com,2004:/photo/309462667</guid>\n" +
            "\n" +
            "\n" +
            "\t\t\t<media:content url=\"http://static.flickr.com/110/309462667_c936ac97e4_o.jpg\"\n" +
            "\t\t\t\t       type=\"image/jpeg\"\n" +
            "\t\t\t\t       height=\"1500\"\n" +
            "\t\t\t\t       width=\"1448\"/>\n" +
            "\t\t\t<media:title>A Little Color for the Girls</media:title>\n" +
            "\t\t\t<media:text type=\"html\">&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/pinksherbet/&quot;&gt;Pink Sherbet Photography&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/pinksherbet/309462667/&quot; title=&quot;A Little Color for the Girls&quot;&gt;&lt;img src=&quot;http://static.flickr.com/110/309462667_c936ac97e4_m.jpg&quot; width=&quot;232&quot; height=&quot;240&quot; alt=&quot;A Little Color for the Girls&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;A Little Color for the Girls&lt;/p&gt;</media:text>\n" +
            "\t\t\t<media:thumbnail url=\"http://static.flickr.com/110/309462667_c936ac97e4_s.jpg\" height=\"75\" width=\"75\" />\n" +
            "\t\t\t<media:credit role=\"photographer\">Pink Sherbet Photography</media:credit>\n" +
            "\t\t\t<media:category scheme=\"urn:flickr:tags\">family pink blue girls friends red orange color colour cute green love colors yellow kids sisters children fun photography rainbow eyes colorful colours purple little desaturated sherbet pinksherbetphotography</media:category>\n" +
            "\n" +
            "\t\t</item>\n" +
            "\t\t<item>\n" +
            "\n" +
            "\t\t\t<title>Pink in Beachy Blue 78/365</title>\n" +
            "\t\t\t<link>http://www.flickr.com/photos/pinksherbet/309446070/</link>\n" +
            "\t\t\t<description>&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/pinksherbet/&quot;&gt;Pink Sherbet Photography&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/pinksherbet/309446070/&quot; title=&quot;Pink in Beachy Blue 78/365&quot;&gt;&lt;img src=&quot;http://static.flickr.com/111/309446070_47ae36ca6d_m.jpg&quot; width=&quot;240&quot; height=&quot;239&quot; alt=&quot;Pink in Beachy Blue 78/365&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;Pink in Beachy Blue. Day 78 of the 365 days project.&lt;/p&gt;</description>\n" +
            "\t\t\t<pubDate>Wed, 29 Nov 2006 04:45:05 -0800</pubDate>\n" +
            "                        <dc:date.Taken>2006-11-28T21:08:33-08:00</dc:date.Taken>\n" +
            "\t\t\t<author>nobody@flickr.com (Pink Sherbet Photography)</author>\n" +
            "\t\t\t<guid isPermaLink=\"false\">tag:flickr.com,2004:/photo/309446070</guid>\n" +
            "\n" +
            "\n" +
            "\t\t\t<media:content url=\"http://static.flickr.com/111/309446070_47ae36ca6d_o.jpg\"\n" +
            "\t\t\t\t       type=\"image/jpeg\"\n" +
            "\t\t\t\t       height=\"2005\"\n" +
            "\t\t\t\t       width=\"2015\"/>\n" +
            "\t\t\t<media:title>Pink in Beachy Blue 78/365</media:title>\n" +
            "\t\t\t<media:text type=\"html\">&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/pinksherbet/&quot;&gt;Pink Sherbet Photography&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/pinksherbet/309446070/&quot; title=&quot;Pink in Beachy Blue 78/365&quot;&gt;&lt;img src=&quot;http://static.flickr.com/111/309446070_47ae36ca6d_m.jpg&quot; width=&quot;240&quot; height=&quot;239&quot; alt=&quot;Pink in Beachy Blue 78/365&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;Pink in Beachy Blue. Day 78 of the 365 days project.&lt;/p&gt;</media:text>\n" +
            "\t\t\t<media:thumbnail url=\"http://static.flickr.com/111/309446070_47ae36ca6d_s.jpg\" height=\"75\" width=\"75\" />\n" +
            "\t\t\t<media:credit role=\"photographer\">Pink Sherbet Photography</media:credit>\n" +
            "\t\t\t<media:category scheme=\"urn:flickr:tags\">family pink blue friends people green colors hat fun photography eyes colorful colours turquoise cap sherbet 365days pinksherbetphotography</media:category>\n" +
            "\n" +
            "\t\t</item>\n" +
            "\t\t<item>\n" +
            "\n" +
            "\t\t\t<title>Colorful Cackoleh</title>\n" +
            "\t\t\t<link>http://www.flickr.com/photos/27378327@N00/309433551/</link>\n" +
            "\t\t\t<description>&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/27378327@N00/&quot;&gt;_AndreA!_&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/27378327@N00/309433551/&quot; title=&quot;Colorful Cackoleh&quot;&gt;&lt;img src=&quot;http://static.flickr.com/103/309433551_7833946f4c_m.jpg&quot; width=&quot;240&quot; height=&quot;200&quot; alt=&quot;Colorful Cackoleh&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;Uno dei primi pasticci fatti con Photoshop :)&lt;/p&gt;</description>\n" +
            "\t\t\t<pubDate>Wed, 29 Nov 2006 04:15:12 -0800</pubDate>\n" +
            "                        <dc:date.Taken>2006-03-22T22:13:49-08:00</dc:date.Taken>\n" +
            "\t\t\t<author>nobody@flickr.com (_AndreA!_)</author>\n" +
            "\t\t\t<guid isPermaLink=\"false\">tag:flickr.com,2004:/photo/309433551</guid>\n" +
            "\n" +
            "\n" +
            "\t\t\t<media:content url=\"http://static.flickr.com/103/309433551_7833946f4c_o.jpg\"\n" +
            "\t\t\t\t       type=\"image/jpeg\"\n" +
            "\t\t\t\t       height=\"1000\"\n" +
            "\t\t\t\t       width=\"1200\"/>\n" +
            "\t\t\t<media:title>Colorful Cackoleh</media:title>\n" +
            "\t\t\t<media:text type=\"html\">&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/27378327@N00/&quot;&gt;_AndreA!_&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/27378327@N00/309433551/&quot; title=&quot;Colorful Cackoleh&quot;&gt;&lt;img src=&quot;http://static.flickr.com/103/309433551_7833946f4c_m.jpg&quot; width=&quot;240&quot; height=&quot;200&quot; alt=&quot;Colorful Cackoleh&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;Uno dei primi pasticci fatti con Photoshop :)&lt;/p&gt;</media:text>\n" +
            "\t\t\t<media:thumbnail url=\"http://static.flickr.com/103/309433551_7833946f4c_s.jpg\" height=\"75\" width=\"75\" />\n" +
            "\t\t\t<media:credit role=\"photographer\">_AndreA!_</media:credit>\n" +
            "\t\t\t<media:category scheme=\"urn:flickr:tags\">light photoshop colorful andrea space orbs pasticci</media:category>\n" +
            "\n" +
            "\t\t</item>\n" +
            "\t\t<item>\n" +
            "\n" +
            "\t\t\t<title>Shapes, functions</title>\n" +
            "\t\t\t<link>http://www.flickr.com/photos/lofi/309429572/</link>\n" +
            "\t\t\t<description>&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/lofi/&quot;&gt;da fool, aka databhi&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/lofi/309429572/&quot; title=&quot;Shapes, functions&quot;&gt;&lt;img src=&quot;http://static.flickr.com/108/309429572_96f5b0a7bb_m.jpg&quot; width=&quot;240&quot; height=&quot;180&quot; alt=&quot;Shapes, functions&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</description>\n" +
            "\t\t\t<pubDate>Wed, 29 Nov 2006 04:06:18 -0800</pubDate>\n" +
            "                        <dc:date.Taken>2006-11-29T13:06:18-08:00</dc:date.Taken>\n" +
            "\t\t\t<author>nobody@flickr.com (da fool, aka databhi)</author>\n" +
            "\t\t\t<guid isPermaLink=\"false\">tag:flickr.com,2004:/photo/309429572</guid>\n" +
            "\n" +
            "\t\t\t<media:content url=\"http://static.flickr.com/108/309429572_96f5b0a7bb_o.jpg\"\n" +
            "\t\t\t\t       type=\"image/jpeg\"\n" +
            "\t\t\t\t       height=\"1536\"\n" +
            "\t\t\t\t       width=\"2048\"/>\n" +
            "\t\t\t<media:title>Shapes, functions</media:title>\n" +
            "\n" +
            "\t\t\t<media:text type=\"html\">&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/lofi/&quot;&gt;da fool, aka databhi&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/lofi/309429572/&quot; title=&quot;Shapes, functions&quot;&gt;&lt;img src=&quot;http://static.flickr.com/108/309429572_96f5b0a7bb_m.jpg&quot; width=&quot;240&quot; height=&quot;180&quot; alt=&quot;Shapes, functions&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</media:text>\n" +
            "\t\t\t<media:thumbnail url=\"http://static.flickr.com/108/309429572_96f5b0a7bb_s.jpg\" height=\"75\" width=\"75\" />\n" +
            "\t\t\t<media:credit role=\"photographer\">da fool, aka databhi</media:credit>\n" +
            "\t\t\t<media:category scheme=\"urn:flickr:tags\">colors contrast colorful fragment</media:category>\n" +
            "\n" +
            "\t\t</item>\n" +
            "\t\t<item>\n" +
            "\t\t\t<title>Loch Ness Monster Abstract</title>\n" +
            "\n" +
            "\t\t\t<link>http://www.flickr.com/photos/31648907@N00/309427604/</link>\n" +
            "\t\t\t<description>&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/31648907@N00/&quot;&gt;pt harriet&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/31648907@N00/309427604/&quot; title=&quot;Loch Ness Monster Abstract&quot;&gt;&lt;img src=&quot;http://static.flickr.com/99/309427604_f8623309a2_m.jpg&quot; width=&quot;240&quot; height=&quot;180&quot; alt=&quot;Loch Ness Monster Abstract&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;Imagine my surprise when I found myself looking eye to eye with a legend.  No wonder peeling paint is so &amp;quot;a-peeling&amp;quot;.&lt;/p&gt;</description>\n" +
            "\t\t\t<pubDate>Wed, 29 Nov 2006 04:01:31 -0800</pubDate>\n" +
            "                        <dc:date.Taken>2006-11-21T21:25:16-08:00</dc:date.Taken>\n" +
            "\t\t\t<author>nobody@flickr.com (pt harriet)</author>\n" +
            "\t\t\t<guid isPermaLink=\"false\">tag:flickr.com,2004:/photo/309427604</guid>\n" +
            "\n" +
            "\n" +
            "\t\t\t<media:content url=\"http://static.flickr.com/99/309427604_f8623309a2_o.jpg\"\n" +
            "\t\t\t\t       type=\"image/jpeg\"\n" +
            "\t\t\t\t       height=\"1944\"\n" +
            "\t\t\t\t       width=\"2592\"/>\n" +
            "\t\t\t<media:title>Loch Ness Monster Abstract</media:title>\n" +
            "\t\t\t<media:text type=\"html\">&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/31648907@N00/&quot;&gt;pt harriet&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/31648907@N00/309427604/&quot; title=&quot;Loch Ness Monster Abstract&quot;&gt;&lt;img src=&quot;http://static.flickr.com/99/309427604_f8623309a2_m.jpg&quot; width=&quot;240&quot; height=&quot;180&quot; alt=&quot;Loch Ness Monster Abstract&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;Imagine my surprise when I found myself looking eye to eye with a legend.  No wonder peeling paint is so &amp;quot;a-peeling&amp;quot;.&lt;/p&gt;</media:text>\n" +
            "\t\t\t<media:thumbnail url=\"http://static.flickr.com/99/309427604_f8623309a2_s.jpg\" height=\"75\" width=\"75\" />\n" +
            "\t\t\t<media:credit role=\"photographer\">pt harriet</media:credit>\n" +
            "\t\t\t<media:category scheme=\"urn:flickr:tags\">blue texture colorful foundart peelingpaint lochnessmonsterabstract</media:category>\n" +
            "\n" +
            "\t\t</item>\n" +
            "\n" +
            "\t\t<item>\n" +
            "\t\t\t<title>tiger country</title>\n" +
            "\t\t\t<link>http://www.flickr.com/photos/dailyville/309417903/</link>\n" +
            "\t\t\t<description>&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/dailyville/&quot;&gt;Dailyville&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/dailyville/309417903/&quot; title=&quot;tiger country&quot;&gt;&lt;img src=&quot;http://static.flickr.com/100/309417903_d62a2ee1d2_m.jpg&quot; width=&quot;240&quot; height=&quot;192&quot; alt=&quot;tiger country&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</description>\n" +
            "\t\t\t<pubDate>Wed, 29 Nov 2006 03:37:30 -0800</pubDate>\n" +
            "                        <dc:date.Taken>2006-11-27T13:49:43-08:00</dc:date.Taken>\n" +
            "\t\t\t<author>nobody@flickr.com (Dailyville)</author>\n" +
            "\t\t\t<guid isPermaLink=\"false\">tag:flickr.com,2004:/photo/309417903</guid>\n" +
            "\n" +
            "\t\t\t<media:content url=\"http://static.flickr.com/100/309417903_d62a2ee1d2_o.jpg\"\n" +
            "\t\t\t\t       type=\"image/jpeg\"\n" +
            "\t\t\t\t       height=\"2030\"\n" +
            "\t\t\t\t       width=\"2538\"/>\n" +
            "\t\t\t<media:title>tiger country</media:title>\n" +
            "\n" +
            "\t\t\t<media:text type=\"html\">&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/dailyville/&quot;&gt;Dailyville&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/dailyville/309417903/&quot; title=&quot;tiger country&quot;&gt;&lt;img src=&quot;http://static.flickr.com/100/309417903_d62a2ee1d2_m.jpg&quot; width=&quot;240&quot; height=&quot;192&quot; alt=&quot;tiger country&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</media:text>\n" +
            "\t\t\t<media:thumbnail url=\"http://static.flickr.com/100/309417903_d62a2ee1d2_s.jpg\" height=\"75\" width=\"75\" />\n" +
            "\t\t\t<media:credit role=\"photographer\">Dailyville</media:credit>\n" +
            "\t\t\t<media:category scheme=\"urn:flickr:tags\">animal cat zoo colorful cincinnati tiger dailyville specanimal</media:category>\n" +
            "\n" +
            "\t\t</item>\n" +
            "\t\t<item>\n" +
            "\t\t\t<title>Persian Carpets</title>\n" +
            "\n" +
            "\t\t\t<link>http://www.flickr.com/photos/horizon/309407698/</link>\n" +
            "\t\t\t<description>&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/horizon/&quot;&gt;HORIZON&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/horizon/309407698/&quot; title=&quot;Persian Carpets&quot;&gt;&lt;img src=&quot;http://static.flickr.com/107/309407698_2e00f562e7_m.jpg&quot; width=&quot;240&quot; height=&quot;180&quot; alt=&quot;Persian Carpets&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;This is a rug from Turkoma Sahara,Ginbad City,  made of rough wool, taken at night, with available light and hand held cam.&lt;br /&gt;\n" +
            "This series is dedicated to Garry Wilmore.&lt;/p&gt;</description>\n" +
            "\t\t\t<pubDate>Wed, 29 Nov 2006 03:16:02 -0800</pubDate>\n" +
            "                        <dc:date.Taken>2006-11-24T00:34:07-08:00</dc:date.Taken>\n" +
            "\t\t\t<author>nobody@flickr.com (HORIZON)</author>\n" +
            "\n" +
            "\t\t\t<guid isPermaLink=\"false\">tag:flickr.com,2004:/photo/309407698</guid>\n" +
            "\n" +
            "\t\t\t<media:content url=\"http://static.flickr.com/107/309407698_2e00f562e7_m.jpg\"\n" +
            "\t\t\t\t       type=\"image/jpeg\"\n" +
            "\t\t\t\t       height=\"180\"\n" +
            "\t\t\t\t       width=\"240\"/>\n" +
            "\t\t\t<media:title>Persian Carpets</media:title>\n" +
            "\t\t\t<media:text type=\"html\">&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/horizon/&quot;&gt;HORIZON&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/horizon/309407698/&quot; title=&quot;Persian Carpets&quot;&gt;&lt;img src=&quot;http://static.flickr.com/107/309407698_2e00f562e7_m.jpg&quot; width=&quot;240&quot; height=&quot;180&quot; alt=&quot;Persian Carpets&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;This is a rug from Turkoma Sahara,Ginbad City,  made of rough wool, taken at night, with available light and hand held cam.&lt;br /&gt;\n" +
            "This series is dedicated to Garry Wilmore.&lt;/p&gt;</media:text>\n" +
            "\t\t\t<media:thumbnail url=\"http://static.flickr.com/107/309407698_2e00f562e7_s.jpg\" height=\"75\" width=\"75\" />\n" +
            "\t\t\t<media:credit role=\"photographer\">HORIZON</media:credit>\n" +
            "\t\t\t<media:category scheme=\"urn:flickr:tags\">catchycolors carpet colorful iran horizon persia rug rugs carpets gonbad persiancarpets turkomansahara</media:category>\n" +
            "\n" +
            "\t\t</item>\n" +
            "\t\t<item>\n" +
            "\t\t\t<title>Persian Carpets</title>\n" +
            "\t\t\t<link>http://www.flickr.com/photos/horizon/309407700/</link>\n" +
            "\t\t\t<description>&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/horizon/&quot;&gt;HORIZON&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/horizon/309407700/&quot; title=&quot;Persian Carpets&quot;&gt;&lt;img src=&quot;http://static.flickr.com/116/309407700_f0108ed288_m.jpg&quot; width=&quot;240&quot; height=&quot;180&quot; alt=&quot;Persian Carpets&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;This is a very fine carpet from Tabriz, made of fine wool and silk, taken at night, with available light and hand held cam.&lt;br /&gt;\n" +
            "This series is dedicated to Garry Wilmore.&lt;/p&gt;</description>\n" +
            "\t\t\t<pubDate>Wed, 29 Nov 2006 03:16:02 -0800</pubDate>\n" +
            "                        <dc:date.Taken>2006-11-23T20:41:02-08:00</dc:date.Taken>\n" +
            "\t\t\t<author>nobody@flickr.com (HORIZON)</author>\n" +
            "\n" +
            "\t\t\t<guid isPermaLink=\"false\">tag:flickr.com,2004:/photo/309407700</guid>\n" +
            "\n" +
            "\t\t\t<media:content url=\"http://static.flickr.com/116/309407700_f0108ed288_m.jpg\"\n" +
            "\t\t\t\t       type=\"image/jpeg\"\n" +
            "\t\t\t\t       height=\"180\"\n" +
            "\t\t\t\t       width=\"240\"/>\n" +
            "\t\t\t<media:title>Persian Carpets</media:title>\n" +
            "\t\t\t<media:text type=\"html\">&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/horizon/&quot;&gt;HORIZON&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/horizon/309407700/&quot; title=&quot;Persian Carpets&quot;&gt;&lt;img src=&quot;http://static.flickr.com/116/309407700_f0108ed288_m.jpg&quot; width=&quot;240&quot; height=&quot;180&quot; alt=&quot;Persian Carpets&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;This is a very fine carpet from Tabriz, made of fine wool and silk, taken at night, with available light and hand held cam.&lt;br /&gt;\n" +
            "This series is dedicated to Garry Wilmore.&lt;/p&gt;</media:text>\n" +
            "\t\t\t<media:thumbnail url=\"http://static.flickr.com/116/309407700_f0108ed288_s.jpg\" height=\"75\" width=\"75\" />\n" +
            "\t\t\t<media:credit role=\"photographer\">HORIZON</media:credit>\n" +
            "\t\t\t<media:category scheme=\"urn:flickr:tags\">catchycolors carpet colorful iran horizon persia rug rugs carpets tabriz persiancarpets</media:category>\n" +
            "\n" +
            "\t\t</item>\n" +
            "\t\t<item>\n" +
            "\t\t\t<title>Colorful Jeepney</title>\n" +
            "\t\t\t<link>http://www.flickr.com/photos/vueltaa/309398531/</link>\n" +
            "\t\t\t<description>&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/vueltaa/&quot;&gt;Vueltaa&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/vueltaa/309398531/&quot; title=&quot;Colorful Jeepney&quot;&gt;&lt;img src=&quot;http://static.flickr.com/104/309398531_20e098da2a_m.jpg&quot; width=&quot;240&quot; height=&quot;180&quot; alt=&quot;Colorful Jeepney&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</description>\n" +
            "\t\t\t<pubDate>Wed, 29 Nov 2006 02:52:41 -0800</pubDate>\n" +
            "                        <dc:date.Taken>2006-11-29T15:55:06-08:00</dc:date.Taken>\n" +
            "\t\t\t<author>nobody@flickr.com (Vueltaa)</author>\n" +
            "\t\t\t<guid isPermaLink=\"false\">tag:flickr.com,2004:/photo/309398531</guid>\n" +
            "\n" +
            "\t\t\t<media:content url=\"http://static.flickr.com/104/309398531_20e098da2a_o.jpg\"\n" +
            "\t\t\t\t       type=\"image/jpeg\"\n" +
            "\t\t\t\t       height=\"600\"\n" +
            "\t\t\t\t       width=\"800\"/>\n" +
            "\t\t\t<media:title>Colorful Jeepney</media:title>\n" +
            "\n" +
            "\t\t\t<media:text type=\"html\">&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/vueltaa/&quot;&gt;Vueltaa&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/vueltaa/309398531/&quot; title=&quot;Colorful Jeepney&quot;&gt;&lt;img src=&quot;http://static.flickr.com/104/309398531_20e098da2a_m.jpg&quot; width=&quot;240&quot; height=&quot;180&quot; alt=&quot;Colorful Jeepney&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</media:text>\n" +
            "\t\t\t<media:thumbnail url=\"http://static.flickr.com/104/309398531_20e098da2a_s.jpg\" height=\"75\" width=\"75\" />\n" +
            "\t\t\t<media:credit role=\"photographer\">Vueltaa</media:credit>\n" +
            "\t\t\t<media:category scheme=\"urn:flickr:tags\">santa colorful philippines manila mesa jeepney luzon</media:category>\n" +
            "\n" +
            "\t\t</item>\n" +
            "\t\t<item>\n" +
            "\t\t\t<title>Colorful house in Intramuros</title>\n" +
            "\n" +
            "\t\t\t<link>http://www.flickr.com/photos/vueltaa/309398487/</link>\n" +
            "\t\t\t<description>&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/vueltaa/&quot;&gt;Vueltaa&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/vueltaa/309398487/&quot; title=&quot;Colorful house in Intramuros&quot;&gt;&lt;img src=&quot;http://static.flickr.com/121/309398487_f230519100_m.jpg&quot; width=&quot;180&quot; height=&quot;240&quot; alt=&quot;Colorful house in Intramuros&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</description>\n" +
            "\t\t\t<pubDate>Wed, 29 Nov 2006 02:52:35 -0800</pubDate>\n" +
            "                        <dc:date.Taken>2006-11-29T14:09:58-08:00</dc:date.Taken>\n" +
            "\t\t\t<author>nobody@flickr.com (Vueltaa)</author>\n" +
            "\t\t\t<guid isPermaLink=\"false\">tag:flickr.com,2004:/photo/309398487</guid>\n" +
            "\n" +
            "\t\t\t<media:content url=\"http://static.flickr.com/121/309398487_f230519100_o.jpg\"\n" +
            "\t\t\t\t       type=\"image/jpeg\"\n" +
            "\t\t\t\t       height=\"600\"\n" +
            "\t\t\t\t       width=\"800\"/>\n" +
            "\t\t\t<media:title>Colorful house in Intramuros</media:title>\n" +
            "\n" +
            "\t\t\t<media:text type=\"html\">&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/vueltaa/&quot;&gt;Vueltaa&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/vueltaa/309398487/&quot; title=&quot;Colorful house in Intramuros&quot;&gt;&lt;img src=&quot;http://static.flickr.com/121/309398487_f230519100_m.jpg&quot; width=&quot;180&quot; height=&quot;240&quot; alt=&quot;Colorful house in Intramuros&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</media:text>\n" +
            "\t\t\t<media:thumbnail url=\"http://static.flickr.com/121/309398487_f230519100_s.jpg\" height=\"75\" width=\"75\" />\n" +
            "\t\t\t<media:credit role=\"photographer\">Vueltaa</media:credit>\n" +
            "\t\t\t<media:category scheme=\"urn:flickr:tags\">house colorful philippines manila intramuros luzon</media:category>\n" +
            "\n" +
            "\t\t</item>\n" +
            "\t\t<item>\n" +
            "\t\t\t<title>Colorful Jeepney</title>\n" +
            "\n" +
            "\t\t\t<link>http://www.flickr.com/photos/vueltaa/309398248/</link>\n" +
            "\t\t\t<description>&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/vueltaa/&quot;&gt;Vueltaa&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/vueltaa/309398248/&quot; title=&quot;Colorful Jeepney&quot;&gt;&lt;img src=&quot;http://static.flickr.com/121/309398248_0f2e1f32c0_m.jpg&quot; width=&quot;240&quot; height=&quot;180&quot; alt=&quot;Colorful Jeepney&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</description>\n" +
            "\t\t\t<pubDate>Wed, 29 Nov 2006 02:52:04 -0800</pubDate>\n" +
            "                        <dc:date.Taken>2006-11-29T16:27:57-08:00</dc:date.Taken>\n" +
            "\t\t\t<author>nobody@flickr.com (Vueltaa)</author>\n" +
            "\t\t\t<guid isPermaLink=\"false\">tag:flickr.com,2004:/photo/309398248</guid>\n" +
            "\n" +
            "\t\t\t<media:content url=\"http://static.flickr.com/121/309398248_0f2e1f32c0_o.jpg\"\n" +
            "\t\t\t\t       type=\"image/jpeg\"\n" +
            "\t\t\t\t       height=\"600\"\n" +
            "\t\t\t\t       width=\"800\"/>\n" +
            "\t\t\t<media:title>Colorful Jeepney</media:title>\n" +
            "\n" +
            "\t\t\t<media:text type=\"html\">&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/vueltaa/&quot;&gt;Vueltaa&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/vueltaa/309398248/&quot; title=&quot;Colorful Jeepney&quot;&gt;&lt;img src=&quot;http://static.flickr.com/121/309398248_0f2e1f32c0_m.jpg&quot; width=&quot;240&quot; height=&quot;180&quot; alt=&quot;Colorful Jeepney&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</media:text>\n" +
            "\t\t\t<media:thumbnail url=\"http://static.flickr.com/121/309398248_0f2e1f32c0_s.jpg\" height=\"75\" width=\"75\" />\n" +
            "\t\t\t<media:credit role=\"photographer\">Vueltaa</media:credit>\n" +
            "\t\t\t<media:category scheme=\"urn:flickr:tags\">santa colorful philippines manila mesa jeepney luzon</media:category>\n" +
            "\n" +
            "\t\t</item>\n" +
            "\t\t<item>\n" +
            "\t\t\t<title>ice blue</title>\n" +
            "\n" +
            "\t\t\t<link>http://www.flickr.com/photos/inazuman/309392008/</link>\n" +
            "\t\t\t<description>&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/inazuman/&quot;&gt;Watari Goro ???&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/inazuman/309392008/&quot; title=&quot;ice blue&quot;&gt;&lt;img src=&quot;http://static.flickr.com/116/309392008_8d4debf96c_m.jpg&quot; width=&quot;240&quot; height=&quot;180&quot; alt=&quot;ice blue&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</description>\n" +
            "\t\t\t<pubDate>Wed, 29 Nov 2006 02:36:52 -0800</pubDate>\n" +
            "                        <dc:date.Taken>2006-11-28T18:43:47-08:00</dc:date.Taken>\n" +
            "\t\t\t<author>nobody@flickr.com (Watari Goro ???)</author>\n" +
            "\t\t\t<guid isPermaLink=\"false\">tag:flickr.com,2004:/photo/309392008</guid>\n" +
            "\n" +
            "\t\t\t<media:content url=\"http://static.flickr.com/116/309392008_8d4debf96c_m.jpg\"\n" +
            "\t\t\t\t       type=\"image/jpeg\"\n" +
            "\t\t\t\t       height=\"180\"\n" +
            "\t\t\t\t       width=\"240\"/>\n" +
            "\t\t\t<media:title>ice blue</media:title>\n" +
            "\n" +
            "\t\t\t<media:text type=\"html\">&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/inazuman/&quot;&gt;Watari Goro ???&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/inazuman/309392008/&quot; title=&quot;ice blue&quot;&gt;&lt;img src=&quot;http://static.flickr.com/116/309392008_8d4debf96c_m.jpg&quot; width=&quot;240&quot; height=&quot;180&quot; alt=&quot;ice blue&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</media:text>\n" +
            "\t\t\t<media:thumbnail url=\"http://static.flickr.com/116/309392008_8d4debf96c_s.jpg\" height=\"75\" width=\"75\" />\n" +
            "\t\t\t<media:credit role=\"photographer\">Watari Goro ???</media:credit>\n" +
            "\t\t\t<media:category scheme=\"urn:flickr:tags\">blue black ice colors night dark lights hawaii colorful bright sony cybershot honolulu v1</media:category>\n" +
            "\n" +
            "\t\t</item>\n" +
            "\t\t<item>\n" +
            "\t\t\t<title>colours of the orient</title>\n" +
            "\n" +
            "\t\t\t<link>http://www.flickr.com/photos/ashclements/309391600/</link>\n" +
            "\t\t\t<description>&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/ashclements/&quot;&gt;.ash&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/ashclements/309391600/&quot; title=&quot;colours of the orient&quot;&gt;&lt;img src=&quot;http://static.flickr.com/107/309391600_b065556aee_m.jpg&quot; width=&quot;185&quot; height=&quot;240&quot; alt=&quot;colours of the orient&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;b&gt;&lt;i&gt;IMG_3361&lt;/b&gt;&lt;/i&gt;&lt;br /&gt;\n" +
            "&lt;br /&gt;\n" +
            "Melbourne's China town and its many colours&lt;/p&gt;</description>\n" +
            "\t\t\t<pubDate>Wed, 29 Nov 2006 02:35:46 -0800</pubDate>\n" +
            "\n" +
            "                        <dc:date.Taken>2006-11-18T12:48:44-08:00</dc:date.Taken>\n" +
            "\t\t\t<author>nobody@flickr.com (.ash)</author>\n" +
            "\t\t\t<guid isPermaLink=\"false\">tag:flickr.com,2004:/photo/309391600</guid>\n" +
            "\n" +
            "\t\t\t<media:content url=\"http://static.flickr.com/107/309391600_b065556aee_o.jpg\"\n" +
            "\t\t\t\t       type=\"image/jpeg\"\n" +
            "\t\t\t\t       height=\"2429\"\n" +
            "\t\t\t\t       width=\"1872\"/>\n" +
            "\t\t\t<media:title>colours of the orient</media:title>\n" +
            "\t\t\t<media:text type=\"html\">&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/ashclements/&quot;&gt;.ash&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/ashclements/309391600/&quot; title=&quot;colours of the orient&quot;&gt;&lt;img src=&quot;http://static.flickr.com/107/309391600_b065556aee_m.jpg&quot; width=&quot;185&quot; height=&quot;240&quot; alt=&quot;colours of the orient&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;b&gt;&lt;i&gt;IMG_3361&lt;/b&gt;&lt;/i&gt;&lt;br /&gt;\n" +
            "&lt;br /&gt;\n" +
            "Melbourne's China town and its many colours&lt;/p&gt;</media:text>\n" +
            "\t\t\t<media:thumbnail url=\"http://static.flickr.com/107/309391600_b065556aee_s.jpg\" height=\"75\" width=\"75\" />\n" +
            "\t\t\t<media:credit role=\"photographer\">.ash</media:credit>\n" +
            "\n" +
            "\t\t\t<media:category scheme=\"urn:flickr:tags\">china city color colour asian lenstagged colorful chinatown bright multicoloured australia melbourne victoria ash colourful multicolored canoneos350d canonef100mmf2</media:category>\n" +
            "\n" +
            "\t\t</item>\n" +
            "\t\t<item>\n" +
            "\t\t\t<title>Coq</title>\n" +
            "\t\t\t<link>http://www.flickr.com/photos/47757737@N00/309381018/</link>\n" +
            "\t\t\t<description>&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/47757737@N00/&quot;&gt;OliBac&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/47757737@N00/309381018/&quot; title=&quot;Coq&quot;&gt;&lt;img src=&quot;http://static.flickr.com/110/309381018_1be111513a_m.jpg&quot; width=&quot;180&quot; height=&quot;240&quot; alt=&quot;Coq&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;Chauss�e Brunehaut, Anzin-Saint-Aubin, vers Maroeuil&lt;/p&gt;</description>\n" +
            "\t\t\t<pubDate>Wed, 29 Nov 2006 02:10:08 -0800</pubDate>\n" +
            "                        <dc:date.Taken>2006-11-29T11:31:51-08:00</dc:date.Taken>\n" +
            "\t\t\t<author>nobody@flickr.com (OliBac)</author>\n" +
            "\t\t\t<guid isPermaLink=\"false\">tag:flickr.com,2004:/photo/309381018</guid>\n" +
            "\n" +
            "\n" +
            "\t\t\t<media:content url=\"http://static.flickr.com/110/309381018_1be111513a_o.jpg\"\n" +
            "\t\t\t\t       type=\"image/jpeg\"\n" +
            "\t\t\t\t       height=\"1600\"\n" +
            "\t\t\t\t       width=\"1200\"/>\n" +
            "\t\t\t<media:title>Coq</media:title>\n" +
            "\t\t\t<media:text type=\"html\">&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/47757737@N00/&quot;&gt;OliBac&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/47757737@N00/309381018/&quot; title=&quot;Coq&quot;&gt;&lt;img src=&quot;http://static.flickr.com/110/309381018_1be111513a_m.jpg&quot; width=&quot;180&quot; height=&quot;240&quot; alt=&quot;Coq&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;Chauss�e Brunehaut, Anzin-Saint-Aubin, vers Maroeuil&lt;/p&gt;</media:text>\n" +
            "\t\t\t<media:thumbnail url=\"http://static.flickr.com/110/309381018_1be111513a_s.jpg\" height=\"75\" width=\"75\" />\n" +
            "\t\t\t<media:credit role=\"photographer\">OliBac</media:credit>\n" +
            "\t\t\t<media:category scheme=\"urn:flickr:tags\">vent colorful wind vane girouette anzin olibac</media:category>\n" +
            "\n" +
            "\t\t</item>\n" +
            "\t\t<item>\n" +
            "\n" +
            "\t\t\t<title>???</title>\n" +
            "\t\t\t<link>http://www.flickr.com/photos/didibear/309359389/</link>\n" +
            "\t\t\t<description>&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/didibear/&quot;&gt;didibear&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/didibear/309359389/&quot; title=&quot;???&quot;&gt;&lt;img src=&quot;http://static.flickr.com/116/309359389_fd78982454_m.jpg&quot; width=&quot;240&quot; height=&quot;192&quot; alt=&quot;???&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</description>\n" +
            "\t\t\t<pubDate>Wed, 29 Nov 2006 01:13:51 -0800</pubDate>\n" +
            "                        <dc:date.Taken>2006-11-29T17:13:51-08:00</dc:date.Taken>\n" +
            "\t\t\t<author>nobody@flickr.com (didibear)</author>\n" +
            "\t\t\t<guid isPermaLink=\"false\">tag:flickr.com,2004:/photo/309359389</guid>\n" +
            "\n" +
            "\t\t\t<media:content url=\"http://static.flickr.com/116/309359389_fd78982454_o.jpg\"\n" +
            "\t\t\t\t       type=\"image/jpeg\"\n" +
            "\t\t\t\t       height=\"1024\"\n" +
            "\t\t\t\t       width=\"1280\"/>\n" +
            "\t\t\t<media:title>???</media:title>\n" +
            "\n" +
            "\t\t\t<media:text type=\"html\">&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/didibear/&quot;&gt;didibear&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/didibear/309359389/&quot; title=&quot;???&quot;&gt;&lt;img src=&quot;http://static.flickr.com/116/309359389_fd78982454_m.jpg&quot; width=&quot;240&quot; height=&quot;192&quot; alt=&quot;???&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</media:text>\n" +
            "\t\t\t<media:thumbnail url=\"http://static.flickr.com/116/309359389_fd78982454_s.jpg\" height=\"75\" width=\"75\" />\n" +
            "\t\t\t<media:credit role=\"photographer\">didibear</media:credit>\n" +
            "\t\t\t<media:category scheme=\"urn:flickr:tags\">boy love colorful child lovely</media:category>\n" +
            "\n" +
            "\t\t</item>\n" +
            "\t\t<item>\n" +
            "\t\t\t<title>Image008</title>\n" +
            "\n" +
            "\t\t\t<link>http://www.flickr.com/photos/didibear/309359178/</link>\n" +
            "\t\t\t<description>&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/didibear/&quot;&gt;didibear&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/didibear/309359178/&quot; title=&quot;Image008&quot;&gt;&lt;img src=&quot;http://static.flickr.com/120/309359178_81d34959da_m.jpg&quot; width=&quot;192&quot; height=&quot;240&quot; alt=&quot;Image008&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</description>\n" +
            "\t\t\t<pubDate>Wed, 29 Nov 2006 01:13:14 -0800</pubDate>\n" +
            "                        <dc:date.Taken>2006-11-29T17:13:14-08:00</dc:date.Taken>\n" +
            "\t\t\t<author>nobody@flickr.com (didibear)</author>\n" +
            "\t\t\t<guid isPermaLink=\"false\">tag:flickr.com,2004:/photo/309359178</guid>\n" +
            "\n" +
            "\t\t\t<media:content url=\"http://static.flickr.com/120/309359178_81d34959da_o.jpg\"\n" +
            "\t\t\t\t       type=\"image/jpeg\"\n" +
            "\t\t\t\t       height=\"1280\"\n" +
            "\t\t\t\t       width=\"1024\"/>\n" +
            "\t\t\t<media:title>Image008</media:title>\n" +
            "\n" +
            "\t\t\t<media:text type=\"html\">&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/didibear/&quot;&gt;didibear&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/didibear/309359178/&quot; title=&quot;Image008&quot;&gt;&lt;img src=&quot;http://static.flickr.com/120/309359178_81d34959da_m.jpg&quot; width=&quot;192&quot; height=&quot;240&quot; alt=&quot;Image008&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</media:text>\n" +
            "\t\t\t<media:thumbnail url=\"http://static.flickr.com/120/309359178_81d34959da_s.jpg\" height=\"75\" width=\"75\" />\n" +
            "\t\t\t<media:credit role=\"photographer\">didibear</media:credit>\n" +
            "\t\t\t<media:category scheme=\"urn:flickr:tags\">boy love colorful child lovely</media:category>\n" +
            "\n" +
            "\t\t</item>\n" +
            "\t\t<item>\n" +
            "\t\t\t<title>Image015</title>\n" +
            "\n" +
            "\t\t\t<link>http://www.flickr.com/photos/didibear/309359033/</link>\n" +
            "\t\t\t<description>&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/didibear/&quot;&gt;didibear&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/didibear/309359033/&quot; title=&quot;Image015&quot;&gt;&lt;img src=&quot;http://static.flickr.com/103/309359033_255b3bb9cc_m.jpg&quot; width=&quot;192&quot; height=&quot;240&quot; alt=&quot;Image015&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</description>\n" +
            "\t\t\t<pubDate>Wed, 29 Nov 2006 01:12:45 -0800</pubDate>\n" +
            "                        <dc:date.Taken>2006-11-29T17:12:45-08:00</dc:date.Taken>\n" +
            "\t\t\t<author>nobody@flickr.com (didibear)</author>\n" +
            "\t\t\t<guid isPermaLink=\"false\">tag:flickr.com,2004:/photo/309359033</guid>\n" +
            "\n" +
            "\t\t\t<media:content url=\"http://static.flickr.com/103/309359033_255b3bb9cc_o.jpg\"\n" +
            "\t\t\t\t       type=\"image/jpeg\"\n" +
            "\t\t\t\t       height=\"1280\"\n" +
            "\t\t\t\t       width=\"1024\"/>\n" +
            "\t\t\t<media:title>Image015</media:title>\n" +
            "\n" +
            "\t\t\t<media:text type=\"html\">&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/didibear/&quot;&gt;didibear&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/didibear/309359033/&quot; title=&quot;Image015&quot;&gt;&lt;img src=&quot;http://static.flickr.com/103/309359033_255b3bb9cc_m.jpg&quot; width=&quot;192&quot; height=&quot;240&quot; alt=&quot;Image015&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</media:text>\n" +
            "\t\t\t<media:thumbnail url=\"http://static.flickr.com/103/309359033_255b3bb9cc_s.jpg\" height=\"75\" width=\"75\" />\n" +
            "\t\t\t<media:credit role=\"photographer\">didibear</media:credit>\n" +
            "\t\t\t<media:category scheme=\"urn:flickr:tags\">boy love colorful child lovely</media:category>\n" +
            "\n" +
            "\t\t</item>\n" +
            "\t\t<item>\n" +
            "\t\t\t<title>lovely child</title>\n" +
            "\n" +
            "\t\t\t<link>http://www.flickr.com/photos/didibear/309358521/</link>\n" +
            "\t\t\t<description>&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/didibear/&quot;&gt;didibear&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/didibear/309358521/&quot; title=&quot;lovely child&quot;&gt;&lt;img src=&quot;http://static.flickr.com/109/309358521_34fe491c51_m.jpg&quot; width=&quot;240&quot; height=&quot;192&quot; alt=&quot;lovely child&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</description>\n" +
            "\t\t\t<pubDate>Wed, 29 Nov 2006 01:11:16 -0800</pubDate>\n" +
            "                        <dc:date.Taken>2006-11-29T17:11:16-08:00</dc:date.Taken>\n" +
            "\t\t\t<author>nobody@flickr.com (didibear)</author>\n" +
            "\t\t\t<guid isPermaLink=\"false\">tag:flickr.com,2004:/photo/309358521</guid>\n" +
            "\n" +
            "\t\t\t<media:content url=\"http://static.flickr.com/109/309358521_34fe491c51_o.jpg\"\n" +
            "\t\t\t\t       type=\"image/jpeg\"\n" +
            "\t\t\t\t       height=\"1024\"\n" +
            "\t\t\t\t       width=\"1280\"/>\n" +
            "\t\t\t<media:title>lovely child</media:title>\n" +
            "\n" +
            "\t\t\t<media:text type=\"html\">&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/people/didibear/&quot;&gt;didibear&lt;/a&gt; posted a photo:&lt;/p&gt;\n" +
            "\n" +
            "&lt;p&gt;&lt;a href=&quot;http://www.flickr.com/photos/didibear/309358521/&quot; title=&quot;lovely child&quot;&gt;&lt;img src=&quot;http://static.flickr.com/109/309358521_34fe491c51_m.jpg&quot; width=&quot;240&quot; height=&quot;192&quot; alt=&quot;lovely child&quot; style=&quot;border: 1px solid #ddd;&quot; /&gt;&lt;/a&gt;&lt;/p&gt;\n" +
            "\n" +
            "</media:text>\n" +
            "\t\t\t<media:thumbnail url=\"http://static.flickr.com/109/309358521_34fe491c51_s.jpg\" height=\"75\" width=\"75\" />\n" +
            "\t\t\t<media:credit role=\"photographer\">didibear</media:credit>\n" +
            "\t\t\t<media:category scheme=\"urn:flickr:tags\">boy love colorful child lovely</media:category>\n" +
            "\n" +
            "\t\t</item>\n" +
            "\n" +
            "\t</channel>\n" +
            "</rss>";

    public void testSimpleParsing() throws Exception {
        RSS2XMLDocumentParser parser = new RSS2XMLDocumentParser();
        List rssItems = parser.parse(testXML);
        System.out.println("rssItems.size() = " + rssItems.size());
        for (Iterator iterator = rssItems.iterator(); iterator.hasNext();) {
            RSSItem rssItem = (RSSItem) iterator.next();
            System.out.println("rssItem = " + rssItem);
            assertEquals("bali - balinese girl", rssItem.getTitle());
        }
    }

    public void testReadXML() throws Exception {
      FileReaderServiceAsync fileReaderService = (FileReaderServiceAsync) GWT.create(FileReaderService.class);

      ServiceDefTarget target = (ServiceDefTarget) fileReaderService;

      // Use a module-relative URLs to ensure that this client code can find
      // its way home, even when the URL changes (as might happen when you
      // deploy this as a webapp under an external servlet container).
      String moduleRelativeURL = GWT.getModuleBaseURL() + "readfile";
      target.setServiceEntryPoint(moduleRelativeURL);


      fileReaderService.readFile("someFile",new AsyncCallback(){

          public void onFailure(Throwable caught) {
              System.out.println("RSS2XMLDocumentParser_UT.onFailure");
          }

          public void onSuccess(Object result) {
              System.out.println("RSS2XMLDocumentParser_UT.onSuccess");
              System.out.println("result = " + result);
          }
      });

    }

    private class MyResponseTextHandler implements ResponseTextHandler {

        public void onCompletion(String responseText) {
            System.out.println("responseText = " + responseText);
        }
    }
}

