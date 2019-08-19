public class Counter {
    private int value;
    private boolean check;

    public Counter(int startingValue, boolean check) {
        this.value = startingValue;
        this.check = check;
    }

    public Counter(int startingValue) {
        this.value = startingValue;
        this.check = false;
    }

    public Counter(boolean check) {
        this.value = 0;
        this.check = check;
    }

    public Counter() {
        this.value = 0;
        this.check = false;
    }

    public int value() {
        return this.value;
    }

    public void increase() {
        this.value += 1;
    }

    public void increase(int increaseAmount) {
        if (increaseAmount > 0) {
            this.value += increaseAmount;
        }
    }

    public void decrease() {
        this.value -= 1;

        // Not below 0 if the check is on
        if(this.check && this.value < 0) {
            this.value = 0;
        }
    }

    public void decrease(int decreaseAmount) {
        // If the value of the parameter is negative, the value of the counter will not change
        if (decreaseAmount > 0) {
            this.value -= decreaseAmount;
        }

        if (this.check && this.value < 0) {
            // Not below 0 if the check is on
            this.value = 0;
        }
    }
}
