import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class VehicleRegister {
    private HashMap<RegistrationPlate,String> list;


    public VehicleRegister() {
        this.list = new HashMap<RegistrationPlate,String>();
    }

    public boolean add(RegistrationPlate plate, String owner) {
        if(!this.list.containsKey(plate)) {
            this.list.put(plate, owner);
            return true;
        }

        return false;
    }

    public String get(RegistrationPlate plate) {
        if(this.list.containsKey(plate)) {
            return this.list.get(plate);
        }

        return null;
    }

    public boolean delete(RegistrationPlate plate) {
        if(this.list.containsKey(plate)) {
            this.list.remove(plate);
            return true;
        }

        return false;
    }

    public void printRegistrationPlates() {
        for (RegistrationPlate key : this.list.keySet()) {
            System.out.println(key);
        }
    }

    public void printOwners() {
        ArrayList<String> ownerList = new ArrayList<String>();

        for (RegistrationPlate key : this.list.keySet()) {
            String name = this.list.get(key);
            if (!ownerList.contains(name)) {
                ownerList.add(name);
            }
        }

        for (String name : ownerList) {
            System.out.println(name);
        }
    }
}