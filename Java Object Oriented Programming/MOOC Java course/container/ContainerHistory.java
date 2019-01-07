package container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class ContainerHistory {

    private List<Double> tracker;

    public ContainerHistory() {
        this.tracker = new ArrayList<Double>();

    }

    public double maxValue() {
        if (this.tracker.size() == 0) {
            return 0;
        }
        return Collections.max(this.tracker);
    }

    public double minValue() {
        if (this.tracker.size() == 0) {
            return 0;
        }
        return Collections.min(this.tracker);
    }

    public double average() {

        if (this.tracker.size() == 0) {
            return 0;
        }
        double sum = 0;

        for (double number : this.tracker) {
            sum += number;
        }
        return sum/this.tracker.size();
    }

    public double greatestFluctuation() {
        if (this.tracker.size()<2) {
            return 0;
        }

        double greatestFluctuation = 0;

        for (double number : this.tracker) {
            for (double comparison : this.tracker) {
                double fluctuation = Math.abs(number - comparison);
                if(fluctuation > greatestFluctuation) {
                    greatestFluctuation = fluctuation;
                }
            }
        }
        return greatestFluctuation;
    }

    public double variance() {
        if (this.tracker.size()<2) {
            return 0;
        }

        double average = average();
        double sum = 0;
        for (double number : this.tracker) {
            sum += Math.pow(number - average, 2);
        }
        return sum / (this.tracker.size()-1);

    }

    public void add(double situation) {
        this.tracker.add(situation);
    }

    public void reset() {
        this.tracker = new ArrayList<Double>();
    }

    public String toString() {
        return this.tracker.toString();
    }

    public static void main(String[] args) {
        ContainerHistory hist = new ContainerHistory();

        hist.add(2.0);
        hist.add(3.0);
        hist.add(7.0);
        hist.add(2.0);

        System.out.println(hist.average());
        System.out.println(hist.greatestFluctuation());
        System.out.println(hist.variance());
    }


}