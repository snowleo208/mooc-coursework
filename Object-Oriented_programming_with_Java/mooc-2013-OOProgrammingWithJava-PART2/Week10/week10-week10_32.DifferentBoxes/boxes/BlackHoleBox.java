package boxes;

import java.util.ArrayList;
import java.util.List;

public class BlackHoleBox extends Box {

    private List<Thing> blackhole;

    public BlackHoleBox() {
        this.blackhole = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        this.blackhole.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return false;
    }

}