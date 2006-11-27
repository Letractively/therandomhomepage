package therandomhomepage.old;

import com.google.gwt.user.client.Random;
import java.util.List;

import therandomhomepage.old.Randomizable;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Jul 9, 2006
 * Time: 3:38:47 AM
 */
public class Randomizer {

    public static Randomizable getRandomItem(List items) {
      if (items != null) {
        int randomIdx = Random.nextInt(items.size());
        return (Randomizable) items.get(randomIdx);
      }
      return null;
    }
}
