package container;

public class ProductContainer extends Container {

    private String name;

    public ProductContainer(String productName, double capacity) {
        super(capacity);
        this.name = productName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;    
    }

    @Override
    public String toString() {
        return this.name + ": " +super.toString();
    }

    public static void main(String[] args) {
        ProductContainer juice = new ProductContainer("Juice", 1000.0);
        juice.addToTheContainer(1000.0);
        juice.takeFromTheContainer(11.3);
        System.out.println(juice.getName()); // Juice
        juice.addToTheContainer(1.0);
        System.out.println(juice);           // volume = 988.7, free space 11.3
    }
}