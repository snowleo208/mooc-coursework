public class StringUtils {

    public static boolean included(String word, String searched) {
        String book = word.trim().toUpperCase();
        String searchString = searched.trim().toUpperCase();
        return book.contains(searchString);
    }
}