package jlchallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

	public static  String fileReader(String fileName, String source) {
	BufferedReader br = null;
	String everything = "";
	try {
		if (source == "Test") {
			File f = new File("./src/test/resources/config/" + fileName);
			br = new BufferedReader(new FileReader(f));
		}else {
			File f = new File("./src/main/resources/config/" + fileName);
			br = new BufferedReader(new FileReader(f));
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		System.out.println(fileName + "was not found");
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
	
	public List<String> getInputs(String fileName, String source){
		List<String> inputList = new ArrayList<String>();	
		String fullFile = fileReader(fileName, source);
		String[] splitedInput = fullFile.split("/");
		for (String i : splitedInput) {
			if (i != splitedInput[0]) {
				i = i.replaceAll("\n+",",");
				i = i.replaceFirst(",", "");
				i = i.substring(0, (i.length() - 1));
				inputList.add(i);
			}
		}
		return inputList;
	}
}














