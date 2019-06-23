

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

	public static String fileReader() {
	BufferedReader br = null;
	String everything = "";
	try {
		br = new BufferedReader(new FileReader("./ChronalCalibration.txt"));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		System.out.println("ChronalCalibration.txt was not found");
	}
	try {
	    StringBuilder sb = new StringBuilder();
	    String line = br.readLine();

	    while (line != null) {
	        sb.append(line);
	        sb.append(System.lineSeparator());
	        line = br.readLine();
	    }
	    everything = sb.toString();
	    System.out.println(everything);
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
	    try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	return everything;
	
}
	
	public static int[] getChronalCalibrationInput() {
		return null;
		
	}
	
}