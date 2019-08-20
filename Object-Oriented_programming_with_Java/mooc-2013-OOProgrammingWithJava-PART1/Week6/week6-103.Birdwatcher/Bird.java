public class Bird {
    private String name;
    private String latinName;
    private int times;

    public Bird (String name, String latinName) {
        this.name = name;
        this.latinName = latinName;
        this.times = 0;
    }

    public String getName() {
        return name;
    }

    public String getLatinName() {
        return latinName;
    }

    public int getTimes() {
        return times;
    }

    public void observe() {
        this.times += 1;
    }

    public String toString() {
        return this.name + " ("+ this.latinName +"): "+ this.times +" observations";
    }
}