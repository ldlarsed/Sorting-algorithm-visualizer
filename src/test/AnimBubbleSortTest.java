package test;

import model.AnimBubbleSort;
import model.DataCreator;

public class AnimBubbleSortTest {

	private int[] data;
	private AnimBubbleSort bub;
	
	public AnimBubbleSortTest(){
		data = DataCreator.createDataArray(1, 20, 20);
		bub = new AnimBubbleSort(data);
	}
	
	private void sortAndPause(){
		System.out.println("Unsorted: "+bub.toString());
		System.out.println("Sorting");
		while(bub.hasNext()){
			bub.sortNextStep();
			System.out.println(bub.toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new AnimBubbleSortTest().sortAndPause();
	}
	
	
}
