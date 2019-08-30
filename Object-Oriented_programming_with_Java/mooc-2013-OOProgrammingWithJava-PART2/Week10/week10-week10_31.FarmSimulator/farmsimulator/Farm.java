package farmsimulator;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Farm implements Alive {
    private String owner;
    private Barn barn;
    private List<Cow> cows;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.cows = new ArrayList<Cow>();
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public void liveHour() {
        for (Cow c : this.cows) {
            c.liveHour();
        }
    }

    public void manageCows() {
        this.barn.takeCareOf(this.cows);
    }

    public void addCow(Cow cow) {
        this.cows.add(cow);
    }

    public void installMilkingRobot(MilkingRobot robot) {
        this.barn.installMilkingRobot(robot);
    }

    @Override
    public String toString() {
        String s = "Farm owner: " + this.owner + "\n"
                + "Barn bulk tank: " + this.barn.toString() + "\n"
                + "Animals:" + "\n";
        for (Cow c : this.cows) {
            s += "        " + c.toString() + "\n";
        }
        return s;
    }
}