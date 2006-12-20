package therandomhomepage.widgets.lightboximagedemoclient;

import com.google.gwt.user.client.ui.Image;
import therandomhomepage.widgets.client.LightboxImage;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 19, 2006
 * Time: 12:10:58 PM
 */
public class SingleLightboxImagePanel extends LightboxImagePanel {

    private static LightboxImage lightboxImage = null;
    private static final String HEADER = "Single Image Demo";
    private static final String DESC = "<br/>Click on the image to see Lightbox in action.<br/><br/>";

    private static final String CODE_SNIPPET = "<table align=\"center\" width=\"100%\">" +
                                               "<tr><td class=\"codeSnippetHeader\">Code Snippet :</td><td>&nbsp;</td></tr>"+
                                               "<tr><td>&nbsp;</td><td class=\"codeSnippet\"><pre>" +
                                                "Image image = <span class=\"s0\">new </span><span class=\"s1\">Image(</span><span class=\"s3\">\"lightbox/image-1.jpg\"</span><span class=\"s1\">);\n" +
                                                "</span>image.setTitle(<span class=\"s3\">\"Image 1\"</span><span class=\"s1\">); \n" +
                                                "</span>lightboxImage = <span class=\"s0\">new </span><span class=\"s1\">LightboxImage(image); \n" +
                                                "</span>" +
                                               "</pre></td></tr></table>";


    static {
        Image image = new Image("image-1.jpg");
        image.setTitle("Image 1");
        lightboxImage = new LightboxImage(image);
    }

    public SingleLightboxImagePanel(){
        super(lightboxImage, HEADER, DESC, CODE_SNIPPET);
    }
}
