package jlchallenge;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class InventoryManagementSystemTest {

	Reader reader = new Reader();

	@Test
	public void testAllDifferent() {
		List<String> checkReader = reader.getInputs("InventoryManagementSystem.txt", "Test");
		List<String> inputList = InventoryManagementSystem.cleanInput(checkReader.get(0));
		int finalCount = InventoryManagementSystem.calculateChecksum(inputList);
		assertEquals(0, finalCount);
	}
	
	@Test
	public void testAllSame() {
		List<String> checkReader = reader.getInputs("InventoryManagementSystem.txt", "Test");
		List<String> inputList = InventoryManagementSystem.cleanInput(checkReader.get(1));
		int finalCount = InventoryManagementSystem.calculateChecksum(inputList);
		assertEquals(0, finalCount);
	}
	
	@Test
	public void testMultipleCharacters() {
		List<String> checkReader = reader.getInputs("InventoryManagementSystem.txt", "Test");
		List<String> inputList = InventoryManagementSystem.cleanInput(checkReader.get(2));
		int finalCount = InventoryManagementSystem.calculateChecksum(inputList);
		assertEquals(4, finalCount);
	}
	
	@Test
	public void testMatchesCount() {
		int[] count = {0,0}, finalCount = {0,0};
		List<String> checkReader = reader.getInputs("InventoryManagementSystem.txt", "Test");
		List<String> inputList = InventoryManagementSystem.cleanInput(checkReader.get(2));
		char[] characters = inputList.get(0).toCharArray();			
		finalCount = InventoryManagementSystem.countMatches(characters, count);
		assertTrue(finalCount[0]==1 && finalCount[1]==1);
	}
	
}
