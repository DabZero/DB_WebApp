package fileprocessors;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class StockFileData {
	
	/**
	 * data is the structure we expect: List of HashMaps
	 */
	List<HashMap<String, Double>> data = new LinkedList<>();
	
	
	public void printData(){
		System.out.println("Stock Results");
		for(HashMap<String, Double> x : data) {
			System.out.println(x);
		}
	}
	
	/**
	 * @param dataIn - List of HashMaps that updates (data)
	 */
	public void addData(List<HashMap<String, Double>> dataIn){
		data = dataIn;
	}
}
