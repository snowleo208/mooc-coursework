package farmsimulator;
import java.util.Random;

public class Cow implements Milkable, Alive {

    private final String name;
    private final double capacity;
    private double amount;
    private final Random random = new Random();

    private static final String[] NAMES = new String[]{
            "Anu", "Arpa", "Essi", "Heluna", "Hely",
            "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
            "Jaana", "Jami", "Jatta", "Laku", "Liekki",
            "Mainikki", "Mella", "Mimmi", "Naatti",
            "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
            "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Cow() {
        this.name = this.NAMES[random.nextInt(this.NAMES.length)];
        this.capacity = 15 + random.nextInt(40 - 15 + 1);
        this.amount = 0;
    }

    public Cow(String name) {
        this.name = name;
        this.capacity = 15 + random.nextInt(40 - 15 + 1);
        this.amount = 0;
    }

    public String getName() {
        return this.name;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public double getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return this.name + " " + Math.ceil(this.amount) + "/" + Math.ceil(this.capacity);
    }

    @Override
    public double milk() {
        double taken = this.amount;
        this.amount = 0;
        return taken;
    }

    @Override
    public void liveHour() {
        this.amount += (7 + this.random.nextInt(20 - 7 + 1)) / 10.0;
        if (this.amount > this.capacity) {
            this.amount = this.capacity;
        }
    }
}