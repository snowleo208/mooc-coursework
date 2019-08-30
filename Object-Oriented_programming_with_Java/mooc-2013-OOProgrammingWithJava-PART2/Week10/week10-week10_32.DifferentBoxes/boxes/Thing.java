package boxes;

public class Thing {

    private String name;
    private int weight;

    public Thing(String name, int weight) {

        this.name = name;
        if(weight < 0) {
            throw new IllegalArgumentException("Weight is negative!");
        }
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Thing compared = (Thing) obj;
        if ((this.name == null && compared.name != null) ||
                !this.name.equals(compared.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        int code = 0;
        if(this.name == null) {
            code = 0;
        } else {
            code = this.name.hashCode();
        }
        hash = 83 * hash + code;

        return hash;
    }

    public Thing(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return this.name + '/' + this.weight;
    }

}
