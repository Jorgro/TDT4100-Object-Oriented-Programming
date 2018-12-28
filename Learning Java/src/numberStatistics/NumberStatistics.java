package numberStatistics;

public class NumberStatistics {
	private int sum;
	private int amountofNumbers;
	
	public NumberStatistics() {
		this.amountofNumbers = 0;
		this.sum = 0;
	}
	
	public void addNumber(int number) {
		this.amountofNumbers ++;
		this.sum += number;
	}
	
	public int amountofNumbers() {
		return this.amountofNumbers;
	}
	public int sum() {
		return this.sum;
	}
	public double average() {
		return 1.0*this.sum/this.amountofNumbers;
	}
}	
