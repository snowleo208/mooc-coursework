import java.util.ArrayList;

public class Box implements ToBeStored {
    private double maxWeight;
    private ArrayList<ToBeStored> list;

    public Box (double maxWeight) {
        this.maxWeight = maxWeight;
        this.list = new ArrayList<ToBeStored>();
    }

    public double weight() {
        double weight = 0;
        // it calculates the total weight of the things which had been stored
        for(ToBeStored t : this.list) {
            weight += t.weight();
        }
        return weight;
    }

    public void add(ToBeStored thing) {
        if(this.weight() + thing.weight() < this.maxWeight) {
            this.list.add(thing);
        }
    }

    public String toString() {
        return "Box: "+ this.list.size() +" things, total weight "+ this.weight() +" kg";
    }

}