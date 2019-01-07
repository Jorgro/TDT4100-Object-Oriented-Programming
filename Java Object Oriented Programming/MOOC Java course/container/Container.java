package container;

/* public Container(double capacity)
It creates an empty container, whose capacity is given as argument; an improper capacity (<=0) creates a useless container, whose capacity is 0.
public double getVolume()
It returns the volume of product in the container.
public double getOriginalCapacity()
It returns the original capacity of the container, that is to say what the constructor was originally given.
public double getCurrentCapacity()
It returns the actual capacity of the container.
public void addToTheContainer(double amount)
It adds the specified amount of things to the container. If the amount is negative, nothing changes; 
if a part of that amount fits but not the whole of it, the container is filled up and the left over is thrown away.
public double takeFromTheContainer(double amount)
We take the specified amount form the container, the method returns what we receive. If the specified amount is negative, nothing happens and zero is returned. If we ask for more than what there is in the container, the method returns all the contents.
public String toString()
It returns the state of an object in String form like volume = 64.5, free space 123.5 */

public class Container {
    private double capacity;
    private double volumeTakenUp;

    public Container(double capacity) {
        if(capacity<=0) {
            this.capacity = 0;
        } else {
            this.capacity = capacity;
        }
        this.volumeTakenUp = 0;
    }

    @Override
    public String toString() {
        return "volume = " + this.volumeTakenUp + ", free space " + this.getCurrentCapacity();
    }

    public void addToTheContainer(double amount) {
        if (amount > 0) {
            if (amount + this.volumeTakenUp > this.capacity) {
                this.volumeTakenUp = this.capacity;
            } else {
                this.volumeTakenUp += amount; 
            }
        }
    }

    public double takeFromTheContainer(double amount) {
        if (amount > 0) {
            if (this.volumeTakenUp-amount > 0) {
                this.volumeTakenUp -= amount;
                return amount;
            } else {
                double taken = this.volumeTakenUp;
                this.volumeTakenUp = 0;
                return taken;
            }
        }
        return 0;
    }

    public double getVolume() {
        return this.volumeTakenUp;
    }

    public double getOriginalCapacity() {
        return this.capacity;
    }

    public double getCurrentCapacity() {
        return this.capacity - this.volumeTakenUp;
    }


}