package model;

import java.util.Iterator;
import java.util.LinkedHashSet;

public final class DataCreator {

	/**
	 * Help method for creating a hash set with unique values
	 * @param min
	 * @param max
	 * @param n
	 * @return
	 */
	public static LinkedHashSet<Integer> createData(int min, int max, int n) {
		if (min < 1 || min > max || max < min || max == min || max < 1 || n < 1 || n > max)
			throw new IllegalArgumentException();

		int i = 0;
		LinkedHashSet<Integer> hs = new LinkedHashSet<Integer>();
		
		while(i<n) {
			int t = (int) (Math.random() * (max-min+1))+min;
			if (t < min || t > max)
				throw new IllegalArgumentException(
						"Error n the random function");
			if(hs.add(t)) i++;
		}
		return hs;
	}
	
	/**
	 * Utilizes the createData() method to generate data values.
	 * @param min
	 * @param max
	 * @param n
	 * @return
	 */
	public static int[] createDataArray(int min, int max, int n){
		LinkedHashSet<Integer> hs = createData(min, max, n);
		int[] data = new int[n];
		Iterator<Integer> iter = hs.iterator();
		int i = 0;
		
		while(iter.hasNext()){
			data[i++] = iter.next();
		}
		
		return data;
	}
}
