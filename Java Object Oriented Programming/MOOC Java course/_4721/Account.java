package _4721;

public class Account {

	private double balance;
	private double interestRate;
	private String ownerName;

	public Account(double balance, double interestRate,  String ownerName) {
		checkNotNegative(balance, "Balance");
		this.balance = balance;
		this.ownerName = ownerName;
		setInterestRate(interestRate);
	}
	
	public Account(){
		
	}

	protected void checkNotNegative(double value, String valueName) {
		if (value < 0) {
			throw new IllegalArgumentException(valueName + " cannot be negative: " + value);
		}
	}

	public String toString() {
		return String.format("[Account balance=%f interestRate=%f", balance, interestRate);
	}
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		checkNotNegative(interestRate, "Interest rate");
		this.interestRate = interestRate;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		checkNotNegative(amount, "Amount");
		balance = balance + amount;
	}
	
	public void withdraw(double amount) {
		checkNotNegative(amount, "Amount");
		double newBalance = balance - amount;
		if (newBalance < 0) {
			throw new IllegalArgumentException("The balance cannot become negative: " + newBalance);
		}
		balance = newBalance;
	}
	
	public void addInterest() {
		deposit(balance * interestRate / 100);		
	}

	//Lagde en setter for balance, ellers kunne jeg også gjort feltet til protected
	public void setBalance(double amount) {
		this.balance = amount;
	}

	public String getOwner() {
		return this.ownerName;
	}
}
