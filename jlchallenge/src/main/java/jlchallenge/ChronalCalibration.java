package jlchallenge;

import java.util.ArrayList;
import java.util.List;

public class ChronalCalibration {

	public static void main(String[] args) {
		
		Reader reader = new Reader();
		List<String> checkReader = reader.getInputs("ChronalCalibration.txt");
		List<Long> inputList = new ArrayList<Long>();
		
		if(args[0] != "1") {
			inputList = cleanInput(args[0]);
		}
		inputList = cleanInput(checkReader.get(0));
		System.out.println(calculateFrequency(inputList));

	}
	
	//method for parsing the input
	static List<Long> cleanInput(String args) {
		List<Long> inputList = new ArrayList<Long>();
		String input = args.replaceAll("\\s+","");
		String[] splitedInput = input.split(",");
		for (String i : splitedInput) {
			if (isNumeric(i)) {
				inputList.add(Long.parseLong(i));
			} else {
				System.out.println("Input is not valid");
				System.exit(0);
			}
		}
		return inputList;
	}
	
	//method for checking if input is long
	public static boolean isNumeric(String strNum) {
	    try {
	        @SuppressWarnings("unused")
			Long l = Long.parseLong(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
	
	// method for calculating the frequency   
    static long calculateFrequency(List<Long> inputList) 
    { 
        long currentFrequency = 0; 
        int i = 0;
        // Iterate through all elements and add them to currentFrecuancy 
        for (i = 0; i < inputList.size(); i++) 
        	currentFrequency +=  inputList.get(i);
       
        return currentFrequency; 
    }

}
