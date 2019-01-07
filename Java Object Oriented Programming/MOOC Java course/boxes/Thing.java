package boxes;

public class Thing {
    private int weight;
    private String name;

    public Thing(String name, int weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Thing's weight can't be negative.");
        }

        this.name = name;
        this.weight = weight;
    }

    

}