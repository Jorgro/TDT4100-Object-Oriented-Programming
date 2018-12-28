package passwordRandomizer;

import java.util.Random;

public class PasswordRandomizer {
    // Define the variables here
	private Random random; 
	private int length;
	
    public PasswordRandomizer(int length) {
    	this.length = length;
        // Format the variable here
    }

    public String createPassword() {
    	random = new Random();
    	int i = 0; 
    	String password = "";
    	while (i < this.length) {
    		int number = random.nextInt(26);
        	char symbol = "abcdefghijklmnopqrstuvwxyz".charAt(number);
        	password += symbol;
        	i++;
    	}
    	return password;
    	
      // Write the code here which returns the new password
    }
}