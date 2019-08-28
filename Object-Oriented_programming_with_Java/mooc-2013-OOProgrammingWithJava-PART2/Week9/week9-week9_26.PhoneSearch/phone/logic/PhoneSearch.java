package phone.logic;
import phone.domain.Person;
import phone.logic.PhoneSearchInterface;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

public class PhoneSearch implements PhoneSearchInterface {
    private Map<String, Person> list;

    public PhoneSearch() {
        this.list = new HashMap<String, Person>();
    }

    public Map<String, Person> getList() {
        return list;
    }

    public Person getPerson(String name) {
        return this.list.get(name);
    }

    public Person removePerson(String name) {
        return this.list.remove(name);
    }

    public void add(Person person) {
        // only add new person to list
        String name = person.getName();
        Set<String> phoneNumber = person.getPhoneNumber();
        Set<String> address = person.getAddress();
        if(!this.list.containsKey(name)) {
            this.list.put(name, person);
        } else {
            // add phone and address only if exists
            if(address.size() > 0) {
                this.getPerson(name).addAddress(address);
            }
            if(phoneNumber.size() > 0) {
                this.getPerson(name).addPhoneNumber(phoneNumber);
            }
        }
    }

    public String searchByNumber(String number) {
        for (String p : this.list.keySet()) {
            if(this.getPerson(p).getPhoneNumber().contains(number)) {
                return p;
            }
        }

        return "";
    }

    public boolean searchByName(String name) {
        if(this.list.containsKey(name)) {
            return true;
        }

        return false;
    }

    public Set<String> searchByKeyWord(String keyword) {
        Set<String> result = new HashSet<String>();

        for (String name : this.list.keySet()) {
            Person target = this.getPerson(name);
            // find keyword in name
            if(target.getName().contains(keyword) && !result.contains(name)) {
                result.add(name);
            }

            // find keyword in all phone numbers
            for(String phone : target.getPhoneNumber()) {
                if(phone.contains(keyword) && !result.contains(name)) {
                    result.add(name);
                }
            }

            // find keyword in all address
            for(String address : target.getAddress()) {
                if(address.contains(keyword) && !result.contains(name)) {
                    result.add(name);
                }
            }
        }

        // if not found, return empty set
        return result;
    }
}