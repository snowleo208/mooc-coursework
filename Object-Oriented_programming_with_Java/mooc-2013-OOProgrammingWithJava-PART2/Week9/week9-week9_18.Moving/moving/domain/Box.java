package moving.domain;
import moving.domain.Thing;
import java.util.ArrayList;

public class Box implements Thing {
    private int maximumCapacity;
    private ArrayList<Thing> list;

    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.list = new ArrayList<Thing>();
    }

    public boolean addThing(Thing thing) {
        if((this.getVolume() + thing.getVolume()) <= this.maximumCapacity) {
            this.list.add(thing);
            return true;
        }

        return false;
    }

    public int getVolume() {
        int totalVolume = 0;
        for(Thing t : this.list) {
            totalVolume += t.getVolume();
        }

        return totalVolume;
    }
}