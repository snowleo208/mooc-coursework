import java.util.ArrayList;

public class Variance {
    // Copy here sum from exercise 63 
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
    
    // Copy here average from exercise 64 
    public static double average(ArrayList<Integer> list) {
        // write code here
        return (float) sum(list) / list.size();
    }

    public static double variance(ArrayList<Integer> list) {
        // write code here
        int n = 0;
        double result = 0;
        double averageNum = average(list);
        while(n < list.size()) {
            if(list.get(n) != 0) {
                result += Math.pow((list.get(n) - averageNum), 2);
            }
            n++;
        }
        if(result != 0) {
            result = result / (list.size() - 1);
        }
        return result;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(2);
        list.add(7);
        list.add(2);
        
        System.out.println("The variance is: " + variance(list));
    }

}
