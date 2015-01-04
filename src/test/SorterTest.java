package test;

import java.util.Arrays;

import model.DataCreator;
import model.Sorter;

public class SorterTest {

	private static void bubbleSortTest(){
		int[] data = DataCreator.createDataArray(1, 20, 20);
		System.out.println("Unsorted");
		System.out.println(Arrays.toString(data));
		data = Sorter.bubbleSort(data);
		System.out.println("Sorted");
		System.out.println(Arrays.toString(data));
	}
	
	private static void insertionSortTest(){
		int[] data = DataCreator.createDataArray(1, 20, 20);
		System.out.println("Unsorted");
		System.out.println(Arrays.toString(data));
		data = Sorter.insertionSort(data);
		System.out.println("Sorted");
		System.out.println(Arrays.toString(data));
	}
	
	public static void main(String[] args) {
		bubbleSortTest();
		insertionSortTest();
	}
}
