package phone.logic;
import phone.domain.Person;

import java.util.HashSet;
import java.util.Set;

public interface PhoneSearchInterface {
    void add(Person person);
    String searchByNumber(String number);
    boolean searchByName(String name);
    Set<String> searchByKeyWord(String keyword);
}