package overloadedCounter;

public class Counter {
	private int number;
	private boolean check;
	
	public Counter(int startingValue, boolean check) {
		this.number = startingValue;
		this.check = check;
	}
	
	public Counter(int startingValue) {
		this.number = startingValue;
		this.check = false;
	}
	
	public Counter(boolean check) {
		this.number = 0;
		this.check = check;
	}
	
	public Counter() {
		this.number = 0; 
		this.check = false;
	}
	
	public int value() {
		return this.number;
	}
	
	public void increase() {
		this.number ++; 
	}
	
	public void decrease() {
		this.number --;
	}
}
