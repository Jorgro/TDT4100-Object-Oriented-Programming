package _4721;

public class CreditAccount extends Account {

    double limit; 

    public CreditAccount(double balance, double interestRate,  String ownerName, double limit) {
        super(balance, interestRate, ownerName);
        this.limit = limit;
    }
    @Override
    public void withdraw(double amount) {
        checkNotNegative(amount, "Amount");
        double newBalance = super.getBalance()-amount;
        if (newBalance < -limit) {
			throw new IllegalArgumentException("The balance cannot become negative: " + newBalance);
		}
		super.setBalance(newBalance);
    }

}