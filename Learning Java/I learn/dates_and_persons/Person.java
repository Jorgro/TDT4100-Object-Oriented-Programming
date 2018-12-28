package dates_and_persons;

import java.util.Calendar;

public class Person {
    private String name;
    private MyDate birthday;

    public Person(String name, int pp, int kk, int vv) {
        this.name = name;
        this.birthday = new MyDate(pp, kk, vv);
    }
    
    public Person(String name, MyDate birthday) {
    	this.birthday = birthday;
    	this.name = name;
    }
    
    public Person(String name) {
    	this.name = name; 
    	int day = Calendar.getInstance().get(Calendar.DATE);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1; // January is 0 so we add one
        int year = Calendar.getInstance().get(Calendar.YEAR);
    	this.birthday = new MyDate(day, month, year);
    }

    public int age() {
        // calculate the age based on the birthday and the current day
        // you get the current day as follows:
        int day = Calendar.getInstance().get(Calendar.DATE);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1; // January is 0 so we add one
        int year = Calendar.getInstance().get(Calendar.YEAR);
        MyDate date = new MyDate(day, month, year);
        return this.birthday.differenceInYears(date);
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name +", born "+ this.birthday;
    }
    
    public boolean olderThan(Person compared) {
    	return this.birthday.earlier(compared.birthday);
    	}
    
    }
	
