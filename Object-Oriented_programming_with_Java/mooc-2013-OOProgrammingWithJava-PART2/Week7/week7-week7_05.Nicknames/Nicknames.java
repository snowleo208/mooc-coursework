
import java.util.HashMap;
import java.util.Map;

public class Nicknames {

    public static void main(String[] args) {
        // Do the operations requested in the assignment here!
        HashMap<String,String> nickname = new HashMap<String,String>();
        nickname.put("matti", "mage");
        nickname.put("mikael", "mixu");
        nickname.put("arto", "arppa");

        System.out.println(nickname.get("mikael"));
    }

}
