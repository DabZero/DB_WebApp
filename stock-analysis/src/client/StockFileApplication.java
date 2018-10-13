 package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class StockFileApplication {
	
	public static void main(String args[]) throws IOException{
		StockFileReader fr = new StockFileReader("table.csv");
		
		List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
		StockFileData fileData = new StockFileData();
		fileData.addData(dataResult);
		fileData.printData();
		System.out.println("Total rows of data: "+dataResult.size());
	}
	/**
	 * Makes a List of Maps (Key:Value) by combining the 
	 * headers and row data from StockFileReader class 
	 * @param headers passed from returned List<String>StockFileReader
	 * @param lines passed from returned List<String> lines from StockFileReader
	 * @return List<HashMap<String, Double>> that has (headers : matched lines values)
	 */
	public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, 
																	  List<String> lines){
		List<HashMap<String, Double>> dataResult = new ArrayList<>();
		
		for(String line : lines){	
			String[] values = line.split(",");  
							//Turns the String into array of String	
			int counter =0;
			HashMap<String, Double> headerValueMap = new HashMap<>();
			for(String value: values){				//["10","15.5","4","11.2"]
				double dval = Double.parseDouble(value);  // [10,15.5,4,11.2]
				headerValueMap.put(headers.get(counter), dval);  
				counter++;		
								//Make (K:V) entry to Map: (header:value) 
								//header.get(index) inner loop to match row data							
			}					//dval is the corresponding row data match  
				dataResult.add(headerValueMap);
		 }						
								//All (header:value) paired, return as List of HashMap's
		return dataResult;
	}
	
	
}
