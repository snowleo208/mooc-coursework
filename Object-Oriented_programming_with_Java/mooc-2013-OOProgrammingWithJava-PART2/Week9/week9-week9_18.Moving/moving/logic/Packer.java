package moving.logic;

import java.util.ArrayList;
import java.util.List;
import moving.domain.Box;
import moving.domain.Thing;

public class Packer {
    private int boxesVolume;
    private List<Box> boxes;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
        this.boxes = new ArrayList<Box>();
    }

    public List<Box> packThings(List<Thing> things) {
        Box box = new Box(this.boxesVolume);
        for (Thing t : things) {
            if(box.addThing(t)) {
                box.addThing(t);
                this.boxes.add(box);
                box = new Box(this.boxesVolume);
            }
        }
        return this.boxes;
    }
}