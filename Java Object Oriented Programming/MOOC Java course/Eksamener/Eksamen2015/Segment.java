package Eksamener.Eksamen2015;

public class Segment {

    private final double length, time, speed;

    public Segment(double length, double time) {
        this.length = length;
        this.time = time;
        this.speed = length / time;
    }

    public double getLength() {
        return this.length;
    }

    public double getDuration() {
        return this.time;
    }

    public double getSpeed() {
        return this.speed;
    }

}