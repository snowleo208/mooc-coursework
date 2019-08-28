package tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class PersonalDuplicateRemover implements DuplicateRemover {
    private Set<String> uniqueStrings;
    private int duplicates;

    public PersonalDuplicateRemover() {
        this.uniqueStrings = new HashSet<String>();
        this.duplicates = 0;
    }

    public void add(String characterString) {
        if(!this.uniqueStrings.contains(characterString)) {
            this.uniqueStrings.add(characterString);
        } else {
            this.duplicates++;
        }
    }

    public int getNumberOfDetectedDuplicates() {
        return this.duplicates;
    }

    public Set<String> getUniqueCharacterStrings() {
        return this.uniqueStrings;
    }

    public void empty() {
        this.uniqueStrings.clear();
        this.duplicates = 0;
    }
}