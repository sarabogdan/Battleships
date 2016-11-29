package UnitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import Model.Battleship;
import Utils.DataValidator;

public class DataValidatorsTests {

	@Test
	public void testHasValidCoordinates() {
		DataValidator dv = new  DataValidator();
		assertEquals(dv.hasValidCoordinates(new Battleship(1 , 'A' , 2, ' ')), false);
		assertEquals(dv.hasValidCoordinates(new Battleship(1 , '-' , 2, '#')), false);
		assertEquals(dv.hasValidCoordinates(new Battleship(1 , 'A' , 2, 'Z')), false);
		assertEquals(dv.hasValidCoordinates(new Battleship(1 , 'A' , 1, 'J')), true);
		assertEquals(dv.hasValidCoordinates(new Battleship(1 , 'J' , 1, 'A')), false);
		assertEquals(dv.hasValidCoordinates(new Battleship(1 , 'A' , 2, 'J')), true);
		assertEquals(dv.hasValidCoordinates(new Battleship(1 , 'A' , -1, 'B')), false);
		assertEquals(dv.hasValidCoordinates(new Battleship(1 , 'A' , 100, 'B')), false);
	}
	
	@Test
	public void testTryGetValidInput() {
		DataValidator dv = new  DataValidator();
		assertEquals(dv.tryGetValidInput(""), null);
		assertEquals(dv.tryGetValidInput(null), null);
		assertEquals(dv.tryGetValidInput("a2"), null);
		assertEquals(dv.tryGetValidInput("AA"), null);
		assertEquals(dv.tryGetValidInput("AA "), null);
		assertEquals(dv.tryGetValidInput("aA5"), null);
		assertEquals(dv.tryGetValidInput("-----"), null);
		assertEquals(dv.tryGetValidInput("11"), null);
		assertEquals(dv.tryGetValidInput("A1") != null, true);
	}
}
