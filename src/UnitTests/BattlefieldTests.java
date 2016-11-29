package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Constants.Constants;
import Constants.HitStatus;
import Factories.RandomlyLocatedShipFactory;
import Interfaces.IRandomlyLocatedShipFactory;
import Model.Battlefield;
import Model.Point;
import Utils.CollisionDetector;
import Utils.DataValidator;
import Utils.RandomGenerator;

public class BattlefieldTests {

	@Test
	public void testInitBattleField() {
		DataValidator validator = new DataValidator();
		IRandomlyLocatedShipFactory factory = new RandomlyLocatedShipFactory(new RandomGenerator());
		CollisionDetector detector = new CollisionDetector();
		Battlefield battleField= new Battlefield(factory, detector, validator);
		
		try {
			battleField.init();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Battlefield init should not throw");
		}	
	}
	
	@Test
	public void testBattleFieldHasThreeShips()
	{
		DataValidator validator = new DataValidator();
		IRandomlyLocatedShipFactory factory = new RandomlyLocatedShipFactory(new RandomGenerator());
		CollisionDetector detector = new CollisionDetector();
		Battlefield battleField= new Battlefield(factory, detector, validator);
		

		try {
			battleField.init();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Battlefield init should not throw");
		}	
		
		int countSinkedShips = 0;
		int countHitShips = 0;
		for (int i = 1; i <= Constants.TABLE_SIZE; i++)
		{
			for (char j: Constants.TABLE_COLUMNS.toCharArray())
			{
				Point test = new Point(i, j);
				int status = battleField.tryHit(test);
				if (status == HitStatus.SHIPSANKED)
				{
					countSinkedShips++;
				}
				
				if (status == HitStatus.SHIPHIT)
				{
					countHitShips++;
				}
			}
		}
		
		assertEquals(3, countSinkedShips);
		assertEquals(6, countHitShips);
	}
}
