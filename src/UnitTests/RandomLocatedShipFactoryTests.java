package UnitTests;

import static org.junit.Assert.*;
import org.junit.Test;

import Constants.Constants;
import Factories.RandomlyLocatedShipFactory;
import Model.BaseShip;
import Utils.RandomGenerator;

public class RandomLocatedShipFactoryTests {
	@Test
	public void testRandomShipGenerated() {
		
		RandomlyLocatedShipFactory fct = new RandomlyLocatedShipFactory(new RandomGenerator());
		try
		{
			fct.GenerateRandomShip(1);
			fail("Invalid random ship");
		}
		catch(Exception ex)
		{
			
		}
		
		try
		{
			BaseShip ship = fct.GenerateRandomShip(Constants.BATTLESHIP_LENGTH);
			assertEquals(true , ship != null);		
		}
		catch(Exception ex)
		{
			fail("We should not throw here");
		}
		
		try
		{
			BaseShip ship2 = fct.GenerateRandomShip(Constants.DESTROYER_LENGTH);
			assertEquals(true, ship2 != null);		
		}
		catch(Exception ex)
		{
			fail("We should not throw here");
		}
	}

}
