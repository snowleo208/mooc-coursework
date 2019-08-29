package containers;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class ContainerHistory {
    private List<Double> history;

    public ContainerHistory() {
        this.history = new ArrayList<Double>();
    }

    public void add(double situation) {
        this.history.add(situation);
    }

    public void reset() {
        this.history.clear();
    }

    public String toString() {
        return this.history.toString();
    }

    public double maxValue() {
        if(this.history.size() > 0) {
            return Collections.max(this.history);
        }

        return 0;
    }

    public double minValue() {
        if(this.history.size() > 0) {
            return Collections.min(this.history);
        }

        return 0;
    }

    public double average() {
        if(this.history.size() > 0) {
            double total = 0;

            for (double d : this.history) {
                total += d;
            }

            return total / this.history.size();
        }

        return 0;
    }

    public double greatestFluctuation() {
        double max = 0;
        List<Double> maxFluctuate = new ArrayList<Double>();

        if (this.history.isEmpty() || this.history.size() == 1) {
            return 0;
        }

        // get max fluctuation
        for (int i = 0; i < this.history.size(); i++) {
            double firstNum = 0;
            double secondNum = 0;

            if (i != this.history.size() - 1) {
                firstNum = this.history.get(i);
                secondNum = this.history.get(i + 1);
            } else {
                firstNum = this.history.get(i - 1);
                secondNum = this.history.get(i);
            }
            max = Math.abs(secondNum - firstNum);
            maxFluctuate.add(max);
        }

        return Collections.max(maxFluctuate);
    }

    public double variance() {
        double avg = average();
        double variance = 0;

        for (double d : this.history) {
            variance += Math.pow((d - avg), 2);
        }
        return variance / (this.history.size() - 1);
    }
}