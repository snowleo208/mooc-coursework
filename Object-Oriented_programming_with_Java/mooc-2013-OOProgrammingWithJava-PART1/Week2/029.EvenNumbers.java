
public class EvenNumbers {

    public static void main(String[] args) {
        // Write your code here
        int i = 1;
        while (i <= 100) {
            i++;  // number++ means the same as number = number + 1
            if(i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
