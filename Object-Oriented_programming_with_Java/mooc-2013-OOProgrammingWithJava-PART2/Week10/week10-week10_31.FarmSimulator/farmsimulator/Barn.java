package farmsimulator;
import java.util.Collection;

public class Barn {
    private BulkTank tank;
    private MilkingRobot robot;

    public Barn(BulkTank tank) {
        this.tank = tank;
        this.robot = null;
    }

    public BulkTank getBulkTank() {
        return this.tank;
    }

    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.robot = milkingRobot;
        this.robot.setBulkTank(tank);
    }

    public void takeCareOf(Cow cow) {
        try {
            this.robot.milk(cow);
        } catch (Exception e) {
            throw new IllegalStateException("milking robot hasn't been installed");
        }
    }

    public void takeCareOf(Collection<Cow> cows) {
        for (Cow c : cows) {
            takeCareOf(c);
        }
    }

    @Override
    public String toString() {
        return Math.ceil(this.tank.getVolume()) + "/" + Math.ceil(this.tank.getCapacity());
    }
}