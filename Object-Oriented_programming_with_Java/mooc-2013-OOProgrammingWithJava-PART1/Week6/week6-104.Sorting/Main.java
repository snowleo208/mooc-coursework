import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // write testcode here
        int[] values = {8, 3, 7, 9, 1, 2, 4};
        sort(values);
    }

    public static int smallest(int[] array) {
        // write the code here
        int smallestNumber = array[0];
        for (int i = 0; i < array.length; i++) {
            if(smallestNumber > array[i]) {
                smallestNumber = array[i];
            }
        }

        return smallestNumber;
    }

    public static int indexOfTheSmallest(int[] array) {
        // code goes here
        int smallestIndex = 0;
        int smallestNumber = array[0];
        for (int i = 0; i < array.length; i++) {
            if(smallestNumber > array[i]) {
                smallestIndex = i;
                smallestNumber = array[i];
            }
        }

        return smallestIndex;
    }

    public static int indexOfTheSmallestStartingFrom(int[] array, int index) {
        // write the code here
        int smallestIndex = index;
        int smallestNumber = array[index];

        for (int i = index; i < array.length; i++) {
            if(smallestNumber > array[i]) {
                smallestIndex = i;
                smallestNumber = array[i];
            }
        }

        return smallestIndex;
    }

    public static void swap(int[] array, int index1, int index2) {
        // code goes here
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array));
            int smallestIndex = indexOfTheSmallestStartingFrom(array, i);
            swap(array, i, smallestIndex);
        }
    }

}
