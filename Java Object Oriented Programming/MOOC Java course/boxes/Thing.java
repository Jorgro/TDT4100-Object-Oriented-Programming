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

    public Thing(String name) {
        this.name = name;
        this.weight = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (getClass() != object.getClass()) {
            return false;
        }

        Thing compared = (Thing) object;

        if (this.name.equals(compared.getName())) {//&& this.weight == compared.getWeight()) {
            
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.weight + this.name.hashCode();
    }




}