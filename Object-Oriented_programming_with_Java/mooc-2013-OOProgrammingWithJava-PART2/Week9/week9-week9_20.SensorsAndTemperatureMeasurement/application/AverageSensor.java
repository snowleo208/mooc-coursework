package application;

import application.Sensor;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private ArrayList<Sensor> allSensors;
    private List<Integer> readings;

    public AverageSensor () {
        this.allSensors = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }

    public void addSensor(Sensor additional) {
        this.allSensors.add(additional);
    }

    public void on() {
        for (Sensor s : this.allSensors) {
            s.on();
        }

    }

    public void off() {
        for (Sensor s : this.allSensors) {
            s.off();
        }

    }

    public boolean isOn() {
        for (Sensor s : this.allSensors) {
            if(!s.isOn()) {
                return false;
            }
        }

        return true;
    }

    public int measure() {
        if(this.allSensors.size() <= 0) {
            throw new IllegalStateException("No sensor is added.");
        }

        int average = 0;
        for (int j = 0; j < this.allSensors.size(); j++) {
            int temp = this.allSensors.get(j).measure();
            average += temp;
        }

        average = average / this.allSensors.size();
        this.readings.add(average);

        return average;
    }

    public List<Integer> readings() {
        return this.readings;
    }
}