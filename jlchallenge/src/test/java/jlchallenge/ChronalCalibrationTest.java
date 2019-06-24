package jlchallenge;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class ChronalCalibrationTest {
	
	Reader reader = new Reader();

	@Test
	public void testOnlyNegatives() {
		List<String> checkReader = reader.getInputs("ChronalCalibration.txt", "Test");
		List<Long> inputList = ChronalCalibration.cleanInput(checkReader.get(0));
		long result = ChronalCalibration.calculateFrequency(inputList);	
		assertEquals(-4, result);
	}
	
	@Test
	public void testUnsignedPossitives() {
		List<String> checkReader = reader.getInputs("ChronalCalibration.txt", "Test");
		List<Long> inputList = ChronalCalibration.cleanInput(checkReader.get(1));
		long result = ChronalCalibration.calculateFrequency(inputList);
		assertEquals(15, result);
	}
	
	@Test
	public void testInputIsNumeric() {
		List<String> checkReader = reader.getInputs("ChronalCalibration.txt", "Test");
		List<Long> result = ChronalCalibration.cleanInput(checkReader.get(2));	
		assertEquals("Input is not valid", result);
	}
	
	@Test
	public void testOnlyCero() {
		List<String> checkReader = reader.getInputs("ChronalCalibration.txt", "Test");
		List<Long> inputList = ChronalCalibration.cleanInput(checkReader.get(3));
		long result = ChronalCalibration.calculateFrequency(inputList);
		assertEquals(0, result);
	}

}
