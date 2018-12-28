package dates_and_persons;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean earlier(MyDate compared) {
        // first we'll compare years
        if ( this.year < compared.year ) {
            return true;
        }

        // if the years are the same, we'll compare the months
        if ( this.year == compared.year && this.month < compared.month ) {
            return true;
        }

        // years and months the same, we'll compare the days
        if ( this.year == compared.year && this.month == compared.month &&
                this.day < compared.day ) {
            return true;
        }

        return false;
    }
    
    public void advance() {
    	if (this.day == 30) {
    		this.day = 1;
    		if (this.month == 12) {
    			this.year += 1;
    			this.month = 1;
    			
    		} else {
    			this.month +=1;
    		}
    	} else {
    		this.day += 1;
    	}		
    }
    
    public void advance(int numberofDays) {
    	int i = 0;
    	while (i < numberofDays) {
    		this.advance();
    		i += 1;
    	}
    	
    }
    public MyDate afterNumberOfDays(int days) {
    	MyDate newMyDate = new MyDate(this.day, this.month, this.year);
    	
    	newMyDate.advance(days);
    	return newMyDate;
    			
    		
    	
    }
    public MyDate clone() {
    	MyDate clone = new MyDate(this.day, this.month, this.year);
    	return clone;
    }
    
    public int differenceInYears(MyDate comparedDate) {
//    	int i = 0;
//    	MyDate clone = comparedDate.clone();
//    	while (this.year > clone.year | this.month > clone.month | this.day > clone.day) {
//    		clone.advance();
//    		i+= 1;
//    	}
//    	System.out.println(i);
//    	int diffYears = i/364;
//    	return diffYears;
//    			
    	if (comparedDate.year > this.year) {
    		return comparedDate.differenceInYears(this);
    	}
    	
    	if (this.year > comparedDate.year) {
    		
    		if (this.month > comparedDate.month) {
    			
    			return this.year - comparedDate.year;
    			
    		}else if (this.month == comparedDate.month) {
    			
    			if (this.day >= comparedDate.day) {
    				
    				return this.year - comparedDate.year;
    			}
    		}else {
    			
    			return this.year - comparedDate.year-1;
    		}
    	
    	}
    	return 0;
    }
}
