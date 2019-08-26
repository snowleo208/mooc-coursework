package application;

import application.Sensor;
import java.util.Random;

public class Thermometer implements Sensor {
    private boolean isOn;
    private int measure;

    public Thermometer () {
        this.isOn = false;
        this.measure = 0;
    }

    public void on() {
        this.isOn = true;
    }

    public void off() {
        this.isOn = false;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public int measure() {
        if(this.isOn) {
            // set random temp
            Random random = new Random();
            this.measure = random.nextInt(51) - 30;
            while(this.measure < -30 || this.measure > 30) {
                this.measure = random.nextInt(31);
            }

            return this.measure;
        } else {
            throw new IllegalStateException("The thermometer is off.");
        }
    }
}