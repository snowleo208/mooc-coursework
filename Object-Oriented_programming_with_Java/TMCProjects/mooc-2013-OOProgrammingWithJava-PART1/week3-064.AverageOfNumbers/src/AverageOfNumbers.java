
import java.util.ArrayList;

public class AverageOfNumbers {

    // Copy here the method sum from previous assignment
    public static int sum(ArrayList<Integer> list) {
        // Write your code here
        int n = 0;
        int result = 0;
        while(n < list.size()) {
            result += list.get(n);
            n++;
        }
        return result;
    }

    public static double average(ArrayList<Integer> list) {
        // write code here
        return (float) sum(list) / list.size();
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(2);
        list.add(7);
        list.add(2);

        System.out.println("The average is: " + average(list));
    }
}
