public class ScoreUtils {
    public static String printStars(int score) {
        int n = 0;
        String result = "";

        while(n < score) {
            result += "*";
            n++;
        }

        return result;
    }
}