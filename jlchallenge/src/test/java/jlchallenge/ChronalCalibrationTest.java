package jlchallenge;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ChronalCalibrationTest {
	
	Reader reader = new Reader();

	@Test
	public void testOnlyNegatives() throws Exception {
		List<String> checkReader = reader.getInputs("ChronalCalibration.txt", "Test");
		List<Long> inputList = ChronalCalibration.cleanInput(checkReader.get(0));
		long result = ChronalCalibration.calculateFrequency(inputList);	
		assertEquals(-4, result);
	}
	
	@Test
	public void testUnsignedPossitives() throws Exception {
		List<String> checkReader = reader.getInputs("ChronalCalibration.txt", "Test");
		List<Long> inputList = ChronalCalibration.cleanInput(checkReader.get(1));
		long result = ChronalCalibration.calculateFrequency(inputList);
		assertEquals(15, result);
	}
	
	@Test(expected = NumberFormatException.class)
	public void testInputIsNumeric() throws Exception {
		List<String> checkReader = reader.getInputs("ChronalCalibration.txt", "Test");
		List<Long> result = ChronalCalibration.cleanInput(checkReader.get(2));	
	}
	
	@Test
	public void testOnlyCero() throws Exception {
		List<String> checkReader = reader.getInputs("ChronalCalibration.txt", "Test");
		List<Long> inputList = ChronalCalibration.cleanInput(checkReader.get(3));
		long result = ChronalCalibration.calculateFrequency(inputList);
		assertEquals(0, result);
	}

}
