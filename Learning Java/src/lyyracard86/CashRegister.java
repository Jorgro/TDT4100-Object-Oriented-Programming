package lyyracard86;

public class CashRegister {
    private double cashInRegister;   // the amount of cash in the register
    private int economicalSold;      // the amount of economical lunches sold
    private int gourmetSold;         // the amount of gourmet lunches sold

    public CashRegister() {
    	this.cashInRegister = 1000;
    	this.economicalSold = 0;
    	this.gourmetSold = 0; 
    }

    public double payEconomical(double cashGiven) {
    	if (cashGiven >= 2.5) {
    		this.cashInRegister += 2.50;
    		this.economicalSold += 1;
    		return cashGiven - 2.50;
    	}
    	return 0; 
        // the price of the economical lunch is 2.50 euros
        // if the given cash is at least the price of the lunch:
        //    the price of lunch is added to register
        //    the amount of the sold lunches is incremented by one
        //    the method returns cashGiven - lunch price
        // if not enough money is given, all is returned and nothing else happens
    }

    public double payGourmet(double cashGiven) {
    	if (cashGiven >= 4) {
    		this.cashInRegister += 4;
    		this.gourmetSold += 1;
    		return cashGiven - 4;
    	}
    	return 0;
        // the price of the gourmet lunch is 4.00 euros
        // if the given cash is at least the price of the lunch:
        //    the price of lunch is added to the register
        //    the amount of the sold lunches is incremented by one
        //    the method returns cashGiven - lunch price
        // if not enough money is given, all is returned and nothing else happens
    
    }
    
    public boolean payEconomical(LyyraCard card) {
    	if (card.pay(2.5)) {
    		this.economicalSold += 1;
    		return true;
    		
    	}
    	return false;
    }
        // the price of the economical lunch is 2.50 euros
        // if the balance of the card is at least the price of the lunch:
        //    the amount of sold lunches is incremented by one
        //    the method returns true
        // if not, the method returns false
    

    public boolean payGourmet(LyyraCard card) {
    	if (card.pay(4)) {
    		this.gourmetSold += 1;
    		return true;
    	}
    	return false;
    }
    	
        // the price of the gourmet lunch is 4.00 euros
        // if the balance of the card is at least the price of the lunch:
        //    the amount of sold lunches is incremented by one
        //    the method returns true
        // if not, the method returns false
    public void loadMoneyToCard(LyyraCard card, double sum) {
    	if (sum > 0) {
    		this.cashInRegister += sum;
    		card.loadMoney(sum);
    	}
    }

    public String toString() {
        return "money in register "+cashInRegister+" economical lunches sold: "+economicalSold+" gourmet lunches sold: "+gourmetSold;
    }
}