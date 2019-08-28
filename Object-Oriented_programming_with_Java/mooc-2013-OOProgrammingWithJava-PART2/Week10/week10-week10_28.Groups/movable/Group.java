package movable;

import movable.Movable;
import movable.Organism;
import java.util.ArrayList;
import java.util.List;

public class Group implements Movable {
    private ArrayList<Movable> list;

    public Group () {
        this.list = new ArrayList<Movable>();
    }

    public void addToGroup(Movable movable) {
        this.list.add(movable);
    }

    public void move(int dx, int dy) {
        for(Movable m : this.list) {
            m.move(dx, dy);
        }
    }

    public String toString() {
        String s = "";
        for(Movable m : this.list) {
            s += m.toString() + "\n";
        }

        return s;
    }
}