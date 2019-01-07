package container;

public class ProductContainerRecorder extends ProductContainer {

    private ContainerHistory history;

    public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
        super(productName, capacity);
        this.history = new ContainerHistory();
        this.addToTheContainer(initialVolume);

    }

    public String history() {
        return this.history.toString();
    }

    @Override
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        double after = this.getVolume();

        this.history.add(after);
    }

    @Override
    public double takeFromTheContainer(double amount) {
        double before = this.getVolume();
        double taken = super.takeFromTheContainer(amount);
        this.history.add(before - taken);
        return taken;
    }

    public void printAnalysis() {
        String analysis = "Product: " + getName() + "\n"
                            + "History: " + this.history.toString() + "\n"
                            + "Greatest product amount: "+ this.history.maxValue() + "\n"
                            + "Smallest product amount: " + this.history.minValue() + "\n"
                            + "Average: " + this.history.average() + "\n"
                            + "Greatest change: " +this.history.greatestFluctuation() + "\n"
                            + "Variance: " +this.history.variance();
        System.out.println(analysis);
    }

    public static void main(String[] args) {
        ProductContainerRecorder juice = new ProductContainerRecorder("Juice", 1000.0, 1000.0);
        juice.takeFromTheContainer(11.3);
        juice.addToTheContainer(1.0);
        //System.out.println(juice.history()); // [1000.0, 988.7, 989.7]
        
        juice.printAnalysis();
    }
}