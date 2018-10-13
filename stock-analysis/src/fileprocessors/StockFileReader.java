package fileprocessors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockFileReader {
	
	String filePath = null;
	
	public StockFileReader(String filePath){
		this.filePath = filePath;
	}
	/**
	 * Splits a String by (,) to mark 1st row as headers 
	 * @param filePath of the file that is being used
	 * @return values is an ArrayList<String> of headers
	 * @throws IOException
	 */
	public List<String> getHeaders() throws IOException{
		String line = readFirstLine(filePath);
		String [] header = line.split(",");
		List<String> values = new ArrayList<String>();
		values = Arrays.asList(header);
		return values;
	}
	/**
	 * Buffers a passed file and reads only a single line 
	 * @param path needs to be the filePath variable initialized by the constructor
	 * @return value of a single line
	 * @throws IOException
	 */
	static String readFirstLine(String path) throws IOException {
	    try (BufferedReader br =
	                   new BufferedReader(new FileReader(path) )
	        ) {
	        return br.readLine();
	    }
	}
	/**
	 * Reads a CSV file, skips the 1st row (since these are marked for headers) AND
	 * turn the rest of the file into a List<String> ...Strings are still un-split rows
	 * @return the file as an array w/ each row representing one line of data <String>
	 * @throws IOException because you are reading a file that may not be present or have errors
	 */
	public List<String> readFileData() throws IOException{ 
		List<String> lines = new ArrayList<String>();  //location to hold read lines of file
		
		BufferedReader br = new BufferedReader( new FileReader(filePath));
			br.readLine();  //reads 1st line, does not advance
			String line = null;  //holding place for lines read
			//Loop as long as there are lines to read			
			while((line = br.readLine()) != null){	//line advanced (2nd+), updated on ea loop
				lines.add(line);	//add to ArrayList as a row/line entry
			
			}
		br.close();
	    return lines;  	 //the ArrayList "lines" now has all of the read data from the CSV file
	    				//	(converted as rows)  returns the cumulative lines read
	} 					
	

}
