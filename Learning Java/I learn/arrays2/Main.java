package arrays2;

public class Main {
	
	public static void main(String[] args) {
		int[] array = {5, 1, 3, 4, 2};
        printArrayAsStars(array);
		
	}
	
	public static int[] copy(int[] array) {
		int[] copied = new int[array.length];
		for (int i = 0; i<array.length; i++) {
			copied[i] = array[i];
			
		}
		
		return copied;
		
		
	}
	public static int[] reverseCopy(int[] array) {
		int[] copied = new int[array.length];
		for (int i = 0;  i < array.length; i++) {
			copied[i] = array[array.length-i-1];
		
		}
		return copied;
	}
	

	public static void printArrayAsStars(int[] array) {
	        for(int i=0; i < array.length; i++) {
	        	
	        	for(int j=0; j < array[i]; j++) {
	        		System.out.print('*');
	        		
	        	}
	        	System.out.println();
	        }
	}
	

}
