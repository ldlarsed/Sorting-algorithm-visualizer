package test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringJoiner;

import model.DataCreator;

public class DataCreatorTest {
	
	private void testCreateData(){
		for (int i = 0; i < 1000; i++) {
			LinkedHashSet<Integer> hs = DataCreator.createData(1, 20, 20);
			Iterator<Integer> iter = hs.iterator();
			StringJoiner sj = new StringJoiner(",", "[", "]");
			while (iter.hasNext()) {
				sj.add(iter.next().toString());
			}
			System.out.println(sj.toString());
		}
	}
	
	private void testCreateDataArray(){
		for(int i = 0; i < 1000; i++){
			int[] data = DataCreator.createDataArray(1, 20, 20);
			System.out.println(Arrays.toString(data));
		}
	}

	public static void main(String[] args) {
		
		new DataCreatorTest().testCreateData();
		new DataCreatorTest().testCreateDataArray();
	}

}
