package dictionary;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {
    private Map<String, Set<String>> dict;

    public PersonalMultipleEntryDictionary() {
        this.dict = new HashMap<String, Set<String>>();
    }

    public void add(String word, String entry) {

        if (!this.dict.containsKey(word)) {
            this.dict.put(word, new HashSet<String>());
        }

        this.dict.get(word).add(entry);
    }

    public Set<String> translate(String word) {
        if (!this.dict.containsKey(word)) {
            return null;
        }

        return this.dict.get(word);
    }

    public void remove(String word) {
        if (this.dict.containsKey(word)) {
            this.dict.remove(word);
        }
    }
}