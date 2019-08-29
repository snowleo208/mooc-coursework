package containers;
import containers.ContainerHistory;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class ProductContainerRecorder extends ProductContainer {
    private ContainerHistory historyRecorder;

    public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
        super(productName, capacity);
        this.historyRecorder = new ContainerHistory();
        this.addToTheContainer(initialVolume);
    }

    public String history() {
        return this.historyRecorder.toString();
    }

    @Override
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        this.historyRecorder.add(this.getVolume());
    }

    @Override
    public double takeFromTheContainer(double amount) {
        double first = this.getVolume();
        super.takeFromTheContainer(amount);
        this.historyRecorder.add(this.getVolume());
        return first - this.getVolume();
    }

    public void printAnalysis() {
        System.out.println("Product: " + this.getName() + "\n"
                + "History: " + this.history() + "\n"
                + "Greatest product amount: " + this.historyRecorder.maxValue() + "\n"
                + "Smallest product amount: " + this.historyRecorder.minValue() + "\n"
                + "Average: " + this.historyRecorder.average() + "\n"
                + "Greatest change: " + this.historyRecorder.greatestFluctuation() + "\n"
                + "Variance: " + this.historyRecorder.variance());
    }

}