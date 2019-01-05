package exceptions.sensors_and_temperature;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    List<Sensor> sensors;
    List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }

    public void addSensor(Sensor additional) {
        this.sensors.add(additional);
    }


    @Override
    public boolean isOn() {
        boolean state = true;
        for (Sensor sensor : this.sensors) {
            if (!sensor.isOn()) {
                state = false;
            }
        }
        return state;
    }

    @Override
    public void on() {
        for (Sensor sensor : this.sensors) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        if(this.isOn()) {
            for (Sensor sensor : this.sensors) {
                if (sensor instanceof Thermometer) {
                    sensor.off();
                    break;
                }
            }
        }
    }

    @Override
    public int measure() {

        if(this.sensors.size() == 0 || !this.isOn()) {
            throw new IllegalStateException("Something is wrong :tenk:");
        }

        int sum = 0;

        for (Sensor sensor : this.sensors) {
            sum += sensor.measure();
        }

        int avg = sum / this.sensors.size();
        this.readings.add(avg);

        return avg;
    }

    public List<Integer> readings() {
        return this.readings;
    }

    public static void main(String[] args) {
        Sensor kumpula = new Thermometer();
        Sensor kaisaniemi = new Thermometer();
        Sensor helsinkiVantaa = new Thermometer();
    
        AverageSensor helsinkiArea = new AverageSensor();
        helsinkiArea.addSensor(kumpula);
        helsinkiArea.addSensor(kaisaniemi);
        helsinkiArea.addSensor(helsinkiVantaa);
    
        helsinkiArea.on();
        System.out.println("the temperature in Helsinki area is "+helsinkiArea.measure() + " degrees");
        System.out.println("the temperature in Helsinki area is "+helsinkiArea.measure() + " degrees");
        System.out.println("the temperature in Helsinki area is "+helsinkiArea.measure() + " degrees");
    
        System.out.println("readings: "+helsinkiArea.readings());
    }

}