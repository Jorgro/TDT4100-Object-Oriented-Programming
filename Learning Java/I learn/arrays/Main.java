package arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {5, 1, 3, 4, 2};
        System.out.println(sum(array));
        printElegantly(array);
    }

    public static int sum(int[] array) {
    	int sum = 0;
    	for (int i = 0; i < array.length; i++) {
    		sum += array[i];
    	}
        // write code here
        return sum;
    }
    
    public static void printElegantly(int[] array) {
    	for (int i = 0; i < array.length; i++) {
    		if (i == array.length -1) {
    			System.out.print(array[i]);
    		} else {
    			System.out.print(array[i] + ", ");
    		}
    	}
        
    }
}
  
