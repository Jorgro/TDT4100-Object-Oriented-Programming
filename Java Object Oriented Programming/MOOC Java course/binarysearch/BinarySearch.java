package binarysearch;

public class BinarySearch {
	
	public static boolean search(int[] array, int searchedValue) {
		int L = 0;
		int R = array.length-1;
		int m = 0;
		while (L <= R) {
			m = Math.floorDiv(L+R, 2);
			
			if (array[m] < searchedValue) {
				L = m+1;
			} else if (array[m] > searchedValue) {
				R = m-1;
			} else {
				return true;
			}
			
		}
		return false;
		
		
		
	}

}
