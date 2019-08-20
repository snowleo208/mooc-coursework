public class Main {

    public static void main(String[] args) {
        // test method here
        int[] array = {5, 1, 3, 4, 2};
        printElegantly(array);
    }

    public static void printElegantly(int[] array) {
        // Write code here
        int n = 0;
        String result = "";
        while(n < array.length) {
            System.out.print(array[n]);
            if(n < array.length - 1) {
                System.out.print(", ");
            }
            n++;
        }
    }
}
