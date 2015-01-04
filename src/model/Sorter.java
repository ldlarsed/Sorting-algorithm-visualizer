package model;

/**
 * A class whith methods that sort and return a whole array directly. Not suited
 * for eventual animation or visualisation of sorting algoritms.
 * 
 * @author luke
 *
 */
public class Sorter {

	public static int[] bubbleSort(int[] data) {
		if (data == null)
			throw new IllegalArgumentException();
		if (data.length == 1)
			return data;
		else {
			boolean rerun = true;
			while (rerun) {
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
		return data;
	}

	public static int[] insertionSort(int[] data) {
		if (data == null)
			throw new IllegalArgumentException();
		if (data.length == 1)
			return data;
		else {
			for (int i = 1; i < data.length; i++) {
				int q = data[i];
				int j = i;
				while (j > 0 && data[j - 1] > q) {
					data[j] = data[j - 1];
					j--;
				}
				data[j] = q;
			}
		}
		return data;
	}
}
