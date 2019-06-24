package jlchallenge;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.junit.Test;

public class ReposeRecordATest {

	Reader reader = new Reader();
	
	@Test
	public void testInputIsOrdered() {
		List<String> input = reader.getInputs("ReposeRecordA.txt", "Test");
		TreeMap<String, String> orderedIn = ReposeRecordA.parseInput(input.get(0));
		List<String> keys = new ArrayList<String>(orderedIn.keySet());
		assertTrue(keys.get(0).contains("1518-11-01 00:00") && keys.get(1).contains("1518-11-01 00:05") && keys.get(2).contains("1518-11-01 00:25"));
	}
	
	@Test
	public void testShiftId() {
		List<String> input = reader.getInputs("ReposeRecordA.txt", "Test");
		TreeMap<String, String> orderedIn = ReposeRecordA.parseInput(input.get(0));
		List<Shift> listOfShifts = ReposeRecordA.listOfShifts(orderedIn);
		Shift shift = listOfShifts.get(0);
		int id = shift.getGuardId();
		assertEquals(10, id);
	}
	
	@Test
	public void testShiftSleepStartingTime() {
		List<String> input = reader.getInputs("ReposeRecordA.txt", "Test");
		TreeMap<String, String> orderedIn = ReposeRecordA.parseInput(input.get(0));
		List<Shift> listOfShifts = ReposeRecordA.listOfShifts(orderedIn);
		Shift shift = listOfShifts.get(0);
		int startTime = shift.getSleepStarts();
		assertEquals(5,startTime);
	}
	
	@Test
	public void testShiftSleepEndingTime() {
		List<String> input = reader.getInputs("ReposeRecordA.txt", "Test");
		TreeMap<String, String> orderedIn = ReposeRecordA.parseInput(input.get(0));
		List<Shift> listOfShifts = ReposeRecordA.listOfShifts(orderedIn);
		Shift shift = listOfShifts.get(0);
		int endTime = shift.getSleepEnds();
		assertEquals(25, endTime);
	}
	
	@Test
	public void testShiftSleepTime() {
		List<String> input = reader.getInputs("ReposeRecordA.txt", "Test");
		TreeMap<String, String> orderedIn = ReposeRecordA.parseInput(input.get(0));
		List<Shift> listOfShifts = ReposeRecordA.listOfShifts(orderedIn);
		Shift shift = listOfShifts.get(0);
		int totalTime = shift.getSleepTime();
		assertEquals(20, totalTime);		
	}
	
	@Test
	public void testSleepiestGuardId() {
		List<String> input = reader.getInputs("ReposeRecordA.txt", "Test");
		TreeMap<String, String> orderedIn = ReposeRecordA.parseInput(input.get(1));
		List<Shift> listOfShifts = ReposeRecordA.listOfShifts(orderedIn);
		int guardId = ReposeRecordA.getSleepiestGuardId(listOfShifts);
		assertEquals(10, guardId);
		
	}
	
	@Test
	public void testMostAsleepMinute() {
		List<String> input = reader.getInputs("ReposeRecordA.txt", "Test");
		TreeMap<String, String> orderedIn = ReposeRecordA.parseInput(input.get(1));
		List<Shift> listOfShifts = ReposeRecordA.listOfShifts(orderedIn);
		int guardId = ReposeRecordA.getSleepiestGuardId(listOfShifts);
		int mostAsleepMinute = ReposeRecordA.getMostAsleepMinute(listOfShifts, guardId);
		assertEquals(24, mostAsleepMinute);
	}

}
