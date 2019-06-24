package jlchallenge;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class ReposeRecordATest {

	Reader reader = new Reader();

	@Test
	public void testAllDifferent() {
		List<String> checkReader = reader.getInputs("InventoryManagementSystem.txt", "Test");
		List<String> inputList = InventoryManagementSystem.cleanInput(checkReader.get(0));
		int finalCount = InventoryManagementSystem.calculateChecksum(inputList);
		assertEquals(0, finalCount);
	}

}
