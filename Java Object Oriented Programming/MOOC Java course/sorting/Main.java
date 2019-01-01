package sorting;

import java.util.Arrays;

public class Main {
	
	
	public static void main(String[] args) {
		int[] values = {8, 3, 7, 9, 1, 2, 4};
		sort(values);
	}
	
	
	
	
	
	public static int smallest(int[] array) {
		int smallest = array[0];
		
		for (int i = 1; i < array.length; i++) {
			if (array[i] < smallest) {
				smallest = array[i];
			}
		}
		return smallest;
	}
	
	public static int indexOfTheSmallest(int[] array) {
		int index = 0;
		
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[index]) {
				index = i;
			}
		}
		return index;
	}
	
	public static int indexOfTheSmallestStartingFrom(int[] array, int index) {
		int start = index;
		
		for (int i = index+1; i < array.length; i++) {
			if (array[i] < array[start]) {
				start = i;
			}
		}
		return start;
	}
	
	public static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public static void sort(int[] array) {
		System.out.println(Arrays.toString(array));
		int smallest = 0;
		for (int i = 0; i < array.length; i++) {
			smallest = indexOfTheSmallestStartingFrom(array, i);
			swap(array, i, smallest);
			System.out.println(Arrays.toString(array));
			
		}
	}
	

}
