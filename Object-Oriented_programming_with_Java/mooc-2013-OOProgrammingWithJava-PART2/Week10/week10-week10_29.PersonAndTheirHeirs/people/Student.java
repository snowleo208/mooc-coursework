package people;

public class Student extends Person {
    private int credit;

    public Student (String name, String address) {
        super(name, address);
        this.credit = 0;
    }

    public int credits() {
        return credit;
    }

    public void study() {
        this.credit += 1;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "  credits "+ this.credit;
    }
}