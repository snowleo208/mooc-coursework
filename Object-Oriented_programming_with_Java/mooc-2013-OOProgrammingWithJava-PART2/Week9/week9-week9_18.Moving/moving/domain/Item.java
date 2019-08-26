package moving.domain;
import moving.domain.Thing;

public class Item implements Thing, Comparable<Item> {
    private String name;
    private int volume;

    public Item (String name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name + " ("+ this.volume +" dm^3)";
    }

    @Override
    public int compareTo(Item i) {
        return this.getVolume() - i.getVolume();
    }
}