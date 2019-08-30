package farmsimulator;

public class BulkTank {
    private double volume;
    private double capacity;

    public BulkTank() {
        this.volume = 0;
        this.capacity = 2000;
    }

    public BulkTank(double capacity) {
        this.volume = 0;
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getVolume() {
        return volume;
    }

    public double howMuchFreeSpace() {
        return this.capacity - this.volume;
    }

    public void addToTank(double amount) {
        this.volume += amount;

       if(this.volume > this.capacity) {
           this.volume = this.capacity;
       }
    }

    public double getFromTank(double amount) {
        this.volume -= amount;

        if(this.volume < 0) {
            this.volume = 0;
        }

        return this.volume;
    }

    public String toString() {
        return Math.ceil(this.volume) + "/" + Math.ceil(this.capacity);
    }
}