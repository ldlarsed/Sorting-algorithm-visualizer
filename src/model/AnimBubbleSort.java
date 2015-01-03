package model;

import java.util.Arrays;

public class AnimBubbleSort {

	private boolean rerun = true;
	private int[] data;

	public AnimBubbleSort(int[] data) {
		if (data == null)
			throw new IllegalArgumentException();
		this.data = data;
	}

	/**
	 * The idea behid this one is to use it outside the class in the same manner
	 * as using hasNext() in a iterator. since usage of an iterator is kind
	 * overkill here this one should fit it's purpose.
	 * 
	 * @return
	 */
	public boolean hasNext() {
		return rerun;
	}
	
	public int[] getCurrentData(){
		return data;
	}
	
	/**
	 * For testing purposes
	 */
	public String toString(){
		return Arrays.toString(data);
	}

	public void sortNextStep() {
		rerun = false;
		for (int i = 1; i < data.length; i++) {
			int q = 0;
			if (data[i] < data[i - 1]) {
				q = data[i];
				data[i] = data[i - 1];
				data[i - 1] = q;
				rerun = true;
			}
		}
	}
}
