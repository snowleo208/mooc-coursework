package application;
import application.Sensor;

public class ConstantSensor implements Sensor {
    private int measure;

    public ConstantSensor (int measure) {
        this.measure = measure;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    public void on() {
    }

    public void off() {
    }

    public int measure() {
        return this.measure;
    }
}