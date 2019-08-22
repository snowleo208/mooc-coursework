import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Dictionary {
    private HashMap<String, String> list;

    public Dictionary() {
        this.list = new HashMap<String, String>();
    }

    public String translate(String word) {
        if(this.list.containsKey(word)) {
            return this.list.get(word);
        }

        return null;
    }

    public void add(String word, String translation) {
        this.list.put(word, translation);
    }

    public int amountOfWords() {
        return this.list.size();
    }

    public ArrayList<String> translationList() {
        ArrayList<String> newList = new ArrayList<String>();
        for ( String key : this.list.keySet() ) {
            newList.add(key + " = " + this.list.get(key));
        }

        return newList;
    }
}