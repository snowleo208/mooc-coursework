
public class Main {

    public static void main(String[] args) {
        // test the method here
        int[] array = {5, 1, 3, 4, 2};
        printArrayAsStars(array);
    }

    public static void printArrayAsStars(int[] array) {
        // write code here
        for(int i = 0; i < array.length; i++) {
            int n = 0;
            while (n < array[i]) {
                System.out.print("*");
                n++;
            }
            System.out.println("");
        }
    }
}
