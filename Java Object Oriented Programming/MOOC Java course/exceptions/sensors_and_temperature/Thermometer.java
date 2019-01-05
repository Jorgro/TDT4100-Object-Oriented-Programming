package exceptions.sensors_and_temperature;

import java.util.Random;

public class Thermometer implements Sensor {

    private boolean state = false;

    @Override
    public boolean isOn() {
        return this.state;
    }

    @Override
    public void on() {
        this.state = true;
    }

    @Override
    public void off() {
        this.state = false;
    }

    @Override
    public int measure() {
        if (!this.state) {
            throw new IllegalStateException("Thermometer must be on");
        }

        Random rand = new Random();

        return rand.nextInt(61) - 30;
    }

}