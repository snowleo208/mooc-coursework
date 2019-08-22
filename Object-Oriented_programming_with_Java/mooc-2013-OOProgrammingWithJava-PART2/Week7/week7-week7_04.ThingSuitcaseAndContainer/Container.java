import java.util.ArrayList;

public class Container {
    private int limit;
    private ArrayList<Suitcase> list;

    public Container (int limit) {
        this.limit = limit;
        this.list = new ArrayList<Suitcase>();
    }

    public void addSuitcase(Suitcase suitcase) {
        int weight = this.totalWeight();
        if((suitcase.totalWeight() + weight) > this.limit) return;

        this.list.add(suitcase);
    }

    public String toString() {
        int weight = this.totalWeight();
        if(this.list.size() == 0) {
            return "empty (0 kg)";
        }

        if(this.list.size() == 1) {
            return "1 suitcase (" + weight + " kg)";
        }

        return this.list.size() + " suitcases (" + weight + " kg)";
    }

    public void printThings() {
        for(Suitcase i : this.list) {
            i.printThings();
        }
    }

    public int totalWeight() {
        int weight = 0;
        for(Suitcase i : this.list) {
            weight += i.totalWeight();
        }

        return weight;
    }

}