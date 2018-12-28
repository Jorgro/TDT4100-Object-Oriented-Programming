package lottery;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class LotteryNumbers {
    private ArrayList<Integer> numbers;
    private Random random;
    public LotteryNumbers() {
        // We'll format a list for the numbers
        this.numbers = new ArrayList<Integer>();
        // Draw numbers as LotteryNumbers is created
        this.drawNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void drawNumbers() {
    	
    	random = new Random();
    	
    	while (this.numbers.size() < 7) {
    		int num = random.nextInt(39) +1;
    		if (!containsNumber(num)) {
    			this.numbers.add(num);
    		}
    	}
        // Write the number drawing here using the method containsNumber()
    }

    public boolean containsNumber(int number) {
    	for (int n : this.numbers) {
    		if (n == number) {
    			return true;
    		}
    	}
    	return false;
        // Test here if the number is already among the drawn numbers
    }
}