package therandomhomepage.common;

import com.google.gwt.user.client.Random;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Jul 9, 2006
 * Time: 3:38:47 AM
 */
public class Randomizer {

    public static Randomizable getRandomItem(List items) {
        if (items != null) {
            int randomIdx = getRandomIdx(items);
            return (Randomizable) items.get(randomIdx);
        }
        return null;
    }

    public static int getRandomIdx(List items) {
        if (items != null) {
            return Random.nextInt(items.size());
        }
        return -1;
    }

    public static int getRandomNo(int upperBound){
        return Random.nextInt(upperBound);        
    }
}
