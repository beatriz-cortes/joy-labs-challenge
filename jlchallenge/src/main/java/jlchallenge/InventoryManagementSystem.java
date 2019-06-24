package jlchallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class InventoryManagementSystem {

	public static void main(String[] args) {
	
		Reader reader = new Reader();
		List<String> checkReader = reader.getInputs("InventoryManagementSystem.txt", "Main");
		List<String> boxesIDs = new ArrayList<String>(); 	
		
		if(args[0] != "1") {
			boxesIDs = cleanInput(args[0]);
		}
		boxesIDs = cleanInput(checkReader.get(0));
		int[] count = {0,0}, finalCount = {0,0};

		for (String boxID : boxesIDs) {
			char[] characters = boxID.toCharArray();			
			finalCount = countMatches(characters, count);
		}
		
		int checksum = finalCount[0] * finalCount[1];

		System.out.println(checksum);
		

	}
 
	//Method for parsing the input
		static List<String> cleanInput(String args) {
			List<String> inputList = new ArrayList<String>();
			String input = args.replaceAll("\\s+","");
			String[] splitedInput = input.split(",");
			for (String i : splitedInput) {
				inputList.add(i);
			}
			return inputList;
		}
	
	//Method for counting doubles and triples 
    static int[] countMatches(char[] characters, int[] matchesCount) 
    {
    	Map<Character, Integer> idAndCount = new HashMap<>();  
    	for (Character letter : characters) { 
    		Integer count = idAndCount.get(letter); 
    		if (count == null) { 
    			idAndCount.put(letter, 1); 
    		} else {
    			idAndCount.put(letter, ++count); 
    		} 
    	}
    	
    	Set<Entry<Character, Integer>> entrySet = idAndCount.entrySet(); 
    	for (Entry<Character, Integer> entry : entrySet) { 
    		if (entry.getValue() == 2) {
    			matchesCount[0] ++;
    			break;
    		}
    	}
    	
    	for (Entry<Character, Integer> entry : entrySet) { 
    		if (entry.getValue() == 3) {  
    			matchesCount[1] ++;
    			break;
    		}
    	}
    	
        return matchesCount; 
    }

}
