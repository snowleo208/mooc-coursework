
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        printWithSmileys("Mikael");
        printWithSmileys("Arto");
        printWithSmileys("Matti");
    }

    private static void printWithSmileys(String characterString) {
        String smiley = ":)";
        int stringLength = characterString.length();
        int width = (characterString.length() + (smiley.length() * 2) + 2) / 2;
//        System.out.println(width);

        // even text length
        if (stringLength % 2 == 0) {
            System.out.println(print(width));
            System.out.println(smiley + " " + characterString + " " + smiley);
            System.out.println(print(width));
        } else {
            System.out.println(print(width + 1));
            System.out.println(smiley + " " + characterString + "  " + smiley);
            System.out.println(print(width + 1));
        }
    }

    private static String print(int length) {
        String result = "";
        for (int i = 0; i < length; i++) {
            result += ":)";
        }

        return result;
    }

    private static void printWhiteSpace(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(" ");
        }
    }

}
