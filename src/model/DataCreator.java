package model;

import java.util.LinkedHashSet;

public final class DataCreator {

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
}
