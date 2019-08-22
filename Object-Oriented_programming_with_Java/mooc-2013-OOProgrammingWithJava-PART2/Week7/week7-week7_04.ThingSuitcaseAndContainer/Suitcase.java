import java.util.ArrayList;

public class Suitcase {
    private int limit;
    private ArrayList<Thing> list;

    public Suitcase (int limit) {
        this.limit = limit;
        this.list = new ArrayList<Thing>();
    }

    public void addThing(Thing thing) {
        int weight = this.totalWeight();
        if((thing.getWeight() + weight) > this.limit) return;

        this.list.add(thing);
    }

    public String toString() {
        int weight = this.totalWeight();
        if(this.list.size() == 0) {
            return "empty (0 kg)";
        }

        if(this.list.size() == 1) {
            return "1 thing (" + weight + " kg)";
        }

        return this.list.size() + " things (" + weight + " kg)";
    }

    public void printThings() {
        for(Thing i : this.list) {
            System.out.println(i);
        }
    }

    public int totalWeight() {
        int weight = 0;
        for(Thing i : this.list) {
            weight += i.getWeight();
        }

        return weight;
    }

    public Thing heaviestThing () {
        if(this.list.size() == 0) return null;

        Thing heaviest = this.list.get(1);
        for(Thing i : this.list) {
            if(i.getWeight() > heaviest.getWeight()) {
                heaviest = i;
            }
        }

        return heaviest;
    }
}