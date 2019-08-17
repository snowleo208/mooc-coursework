
public class NumberStatistics {
    private int amountOfNumbers;
    private int sum;

    public NumberStatistics() {
        // initialize here the object variable amountOfNumbers
        this.amountOfNumbers = 0;
    }

    public void addNumber(int number) {
        // code here
        this.amountOfNumbers += 1;
        this.sum += number;
    }

    public int amountOfNumbers() {
        // code here
        return this.amountOfNumbers;
    }
    
    public int sum() {
        // code here
        return this.sum;
    }

    public double average() {
        // code here
        if(this.sum == 0) {
            return 0;
        }
        return (float) this.sum / this.amountOfNumbers;
    }
}
    