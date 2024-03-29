package jlchallenge;

import java.util.ArrayList;
import java.util.List;

public class ChronalCalibration {

	public static void main(String[] args) throws Exception {
		
		Reader reader = new Reader();
		List<String> checkReader = reader.getInputs("ChronalCalibration.txt", "Main");
		List<Long> inputList = new ArrayList<Long>();
		
		if(args.length != 0) {
			inputList = cleanInput(args[0]);
		} else{
			inputList = cleanInput(checkReader.get(0));
		}
		
		long frequency = calculateFrequency(inputList);
		System.out.println(frequency);

	}
	
	//method for parsing the input
	static List<Long> cleanInput(String args) throws Exception {
		List<Long> inputList = new ArrayList<Long>();
		String input = args.replaceAll("\\s+","");
		String[] splitedInput = input.split(",");
		for (String i : splitedInput) {
			if (isNumeric(i)) {
				inputList.add(Long.parseLong(i));
			} else {
				throw new NumberFormatException("Input is not valid");
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
