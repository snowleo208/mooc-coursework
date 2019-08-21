import java.util.ArrayList;

public class Changer {
    ArrayList<Change> list;

    public Changer() {
        this.list = new ArrayList<Change>();
    }

    public void addChange(Change change) {
        this.list.add(change);
    }

    public String change(String characterString) {
        for(Change i : this.list) {
            characterString = i.change(characterString);
        }

        return characterString;
    }
}