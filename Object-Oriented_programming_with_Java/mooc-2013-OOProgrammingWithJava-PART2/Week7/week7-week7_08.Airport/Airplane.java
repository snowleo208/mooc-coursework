public class Airplane {
    private String name;
    private int capacity;

    public Airplane (String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String toString() {
        return this.name + " (" + this.capacity +" ppl)";
    }
}