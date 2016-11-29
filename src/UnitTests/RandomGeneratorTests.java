package UnitTests;

import static org.junit.Assert.*;
import org.junit.Test;

import Utils.RandomGenerator;

public class RandomGeneratorTests {

	@Test
	public void testValidRangesAreGenerated() {
		
		RandomGenerator gen = new RandomGenerator();
		for (int i = 0; i < 10; i++)
		{	
			char column = gen.GetRandomColumn();
			assertTrue(Constants.Constants.TABLE_COLUMNS.indexOf(column) >= 0);
		}
		
		for (int i = 0; i < 10; i++)
		{	
			int row = gen.GetRandomRow();
			assertTrue(row <= Constants.Constants.TABLE_SIZE && row >= 1);
		}
		
		for (int i = 0; i < 10; i++)
		{	
			int direction = gen.GetRandomDirection();
			assertTrue(direction == Constants.Constants.DIRECTION_LEFT_RIGHT || direction == Constants.Constants.DIRECTION_TOP_BOTTOM);
		}
	}
}
