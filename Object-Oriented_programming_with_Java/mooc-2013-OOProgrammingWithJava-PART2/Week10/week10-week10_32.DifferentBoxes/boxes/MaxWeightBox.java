package boxes;
import java.util.ArrayList;
import java.util.List;

public class MaxWeightBox extends Box {
    private int maxWeight;
    private List<Thing> boxes;

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.boxes = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        int weight = 0;
        for (Thing t : this.boxes) {
            weight += t.getWeight();
        }
        if (weight + thing.getWeight() <= this.maxWeight) {
            this.boxes.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return this.boxes.contains(thing);
    }
}