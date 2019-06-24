package jlchallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class ReposeRecordA {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Reader reader = new Reader();
		List<String> checkReader = reader.getInputs("ReposeRecordA.txt", "Main");
		String input;
		
		if(args.length != 0) {
			input = args[0];
		}else {
			input = checkReader.get(0);
		}
		
		TreeMap<String, String> orderedIn = parseInput(input);
		List<Shift> shiftsList = listOfShifts(orderedIn);
		int sleepiestGuardId = getSleepiestGuardId(shiftsList);
		System.out.println("The guard that sleeps the most is: " + sleepiestGuardId);
		int mostAsleepMinute = getMostAsleepMinute(shiftsList, sleepiestGuardId);
		System.out.println("Most Asleep Minute: " + mostAsleepMinute);
		int result = sleepiestGuardId * mostAsleepMinute;
		System.out.println("Result: " + result);
		
	}
	
	public static TreeMap<String, String> parseInput(String in) {
		
		String[] inputData = in.split(",");
	    TreeMap<String, String> tm = new TreeMap<String, String>();

	    for (int i = 0; i < inputData.length ; i++) {
	    String dateTime = inputData[i].substring(0, inputData[i].indexOf(']')).trim();
	    String shiftAction = inputData[i].substring(inputData[i].indexOf(']') + 1).trim();
	    tm.put(dateTime, shiftAction);
	    }		
		
		return tm;		
	}
	
	public static List<Shift> listOfShifts(TreeMap<String, String> shiftsSchedules){
		
		List<Shift> shiftsList = new ArrayList<Shift>();
		List<String> keys = new ArrayList<String>(shiftsSchedules.keySet());
		List<String> values= new ArrayList<String>(shiftsSchedules.values());
		
		for (int i =0; i < keys.size();) {
    		if (values.get(i).toString().contains("Guard")) {
    			
    			//cleaning id string to get only id
    			String getGuardId = values.get(i).toString();
    			String clean = getGuardId.replaceAll("\\D+","");
    			int guardId = Integer.parseInt(clean);
    			
    			//creating shift object and setting id			
    			Shift shift = new Shift();
    			shift.setGuardId(guardId);	
    			i++;
    			
    			//creating SleepRecord object    			
				shift.setSleepStarts(parseTimeToMinutes(keys.get(i).toString()));
				i++;
				shift.setSleepEnds(parseTimeToMinutes(keys.get(i).toString()));
				i++;  			
    			shiftsList.add(shift);
    			
    			while (i < keys.size() && !values.get(i).toString().contains("Guard")) {
    				
        			//creating shift object and setting id
        			Shift shiftNew = new Shift();
        			shiftNew.setGuardId(guardId);			
        			
        			//creating SleepRecord object    			
        			shiftNew.setSleepStarts(parseTimeToMinutes(keys.get(i).toString()));
    				i++;
    				shiftNew.setSleepEnds(parseTimeToMinutes(keys.get(i).toString()));
    				i++;  			
        			shiftsList.add(shiftNew);				
    			}
    		}  			
    	}
		
		return shiftsList;
	}

	public static int parseTimeToMinutes(String fullDate){
		
		//parsing sleeping periods
		String clean = fullDate.replaceAll(".+:","");
		int minutes = Integer.parseInt(clean);
		return minutes;
	}

	public static int getSleepiestGuardId(List<Shift> shiftsList) {
	
		Map<Integer, Integer> idAndCount = new HashMap<>(); 
		
    	for (Shift shift : shiftsList) {
    		
    		int guardId = shift.getGuardId();
    		int guardSleepTime = shift.getSleepTime();
    		Integer count = idAndCount.get(guardId);
    		if (count == null) { 
    			idAndCount.put(guardId, guardSleepTime); 
    		} else {
    			int totalTime = count +  guardSleepTime;
    			idAndCount.put(guardId, totalTime); 
    		} 
    	}
    	
    	Set<Entry<Integer, Integer>> entrySet = idAndCount.entrySet();  	
    	int maxTimeAsleep = 0, sleepiestGuard = 0;
    	
    	for (Entry<Integer, Integer> entry : entrySet) { 
    		if (entry.getValue() > maxTimeAsleep) {
    			
    			sleepiestGuard = entry.getKey();
    			maxTimeAsleep = entry.getValue();
    		}
    	}
    	
		return sleepiestGuard;
	}
	
	public static int getMostAsleepMinute(List<Shift> shiftsList, int sleepiestGuardId) {
		
		Map<Integer, Integer> minuteAndCount = new HashMap<>();
		
		for (Shift shift : shiftsList) {
    		
    		int guardId = shift.getGuardId();
    		if (guardId==sleepiestGuardId) {	
    			int sleepStarts = shift.getSleepStarts();
    			int sleepEnds = shift.getSleepEnds();
    			
    			for(int i = sleepStarts; i < sleepEnds; i++){
    				Integer count = minuteAndCount.get(i);
    				if (count == null) { 
    					minuteAndCount.put(i, 1); 
    				} else {
    					minuteAndCount.put(i, ++count); 
    				}  
    			}
    		}			
    	}
		
		Set<Entry<Integer, Integer>> entrySet = minuteAndCount.entrySet();  	
    	int maxCount = 0, mostAsleepMinute = 0;
    	
    	for (Entry<Integer, Integer> entry : entrySet) { 
    		if (entry.getValue() > maxCount) {
    			
    			mostAsleepMinute = entry.getKey();
    			maxCount = entry.getValue();
    		}
    	}	
		return mostAsleepMinute;
	}

}

