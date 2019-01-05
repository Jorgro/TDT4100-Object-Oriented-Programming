package exceptions.sensors_and_temperature;



public class ConstantSensor implements Sensor {

    private int measure;

    public ConstantSensor(int number) {
        this.measure = number;
    }
    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void on() {

    }

    @Override
    public void off() {

    }

    @Override
    public int measure() {
        return this.measure;
    }

    public static void main(String[] args) {
        ConstantSensor ten = new ConstantSensor(10);
        ConstantSensor minusFive = new ConstantSensor(-5);
      
        System.out.println( ten.measure() );
        System.out.println( minusFive.measure() );
      
        System.out.println( ten.isOn() );
        ten.off();
        System.out.println( ten.isOn() );
      }
}