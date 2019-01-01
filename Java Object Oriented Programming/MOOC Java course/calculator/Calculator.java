package calculator;

public class Calculator {
	
	private Reader reader;
	private int calculations;
	
	public Calculator() {
		this.reader = new Reader();
		this.calculations = 0;
	}
    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
            } else if (command.equals("difference")) {
                difference();
            } else if (command.equals("product")) {
                product();
            }
        }

        statistics();
    }
    
    private void sum() {
    	this.calculations ++;
    	int[] array = readIntegers();
        System.out.println("sum of the values " + Integer.toString(array[0]+array[1]));
    }
    
    private void difference() {
    	this.calculations ++; 
    	int[] array = readIntegers();
        System.out.println("sum of the values " + Integer.toString(array[0]-array[1]));
    	
    }
    
    private void product() {
    	this.calculations ++;
    	int[] array = readIntegers();
        System.out.println("sum of the values " + Integer.toString(array[0]*array[1]));
    	
    }
    
    private void statistics() {
    	System.out.println("Calculations done " + Integer.toString(this.calculations));
    }
    
    private int[] readIntegers() {
    	System.out.print("value1: ");
        int value1 =  reader.readInteger();
        System.out.print("value2: ");
        int value2 = reader.readInteger();
        int[] array = {value1, value2};
        return array;
    }
}
