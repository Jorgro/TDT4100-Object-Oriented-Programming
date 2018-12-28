package money;

public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros += cents / 100;
            cents %= 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros(){
        return euros;
    }

    public int cents(){
        return cents;
    }

    public String toString() {
        String zero = "";
        if (cents <= 10) {
            zero = "0";
        }

        return euros + "." + zero + cents + "e";
    }
    
    public Money plus(Money added) {
    	Money c = new Money(this.euros + added.euros, this.cents + added.cents);
    	return c;
    }
    
    public boolean less(Money compared) {
    	if (this.euros > compared.euros) {
    		return false;
    	} else if (this.euros < compared.euros) {
    		return true;
    	}
    	return this.cents < compared.cents;
    }
    
    public Money minus(Money decremented) {
    	
    	int euros = this.euros-decremented.euros;
    	int cents = this.cents - decremented.cents;
    	if (cents < 0 & euros >= 1) {
    		cents += 100;
    		euros -= 1;
    	}else if (cents < 0 & euros < 1 ) {
    		cents = 0;
    		euros = 0;
    	}
    	
    	if (euros < 0) {
    		euros = 0;
    		cents = 0;
    	}
    	Money c = new Money(euros, cents);
    	return c;
    }
}
  
