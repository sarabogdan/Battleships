package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.BaseShip;
import Model.Battleship;
import Model.Destroyer;
import Model.Point;
import Utils.CollisionDetector;

public class BaseShipTests {

	@Test
	public void tryHitBattleshipTest() {
		
		BaseShip ship = new Battleship(new Point(1, 'A'), new Point(1, 'E'));
		CollisionDetector detector = new CollisionDetector();
		
		assertEquals(Constants.HitStatus.SHIPHIT, ship.tryHit(new Point(1, 'A'), detector));
		assertEquals(Constants.HitStatus.MISS, ship.tryHit(null, detector));
		assertEquals(Constants.HitStatus.SHIPHIT, ship.tryHit(new Point(1, 'B'), detector));
		assertEquals(Constants.HitStatus.SHIPHIT, ship.tryHit(new Point(1, 'C'), detector));
		assertEquals(Constants.HitStatus.SHIPHIT, ship.tryHit(new Point(1, 'D'), detector));
		assertEquals(Constants.HitStatus.ALREADYHIT, ship.tryHit(new Point(1, 'D'), detector));
		assertEquals(Constants.HitStatus.SHIPSANKED, ship.tryHit(new Point(1, 'E'), detector));
		assertEquals(Constants.HitStatus.ALREADYSANKED, ship.tryHit(new Point(1, 'E'), detector));
		assertEquals(Constants.HitStatus.MISS, ship.tryHit(new Point(1, 'F'), detector));
		assertEquals(Constants.HitStatus.MISS, ship.tryHit(new Point(2, 'A'), detector));
		assertEquals(Constants.HitStatus.MISS, ship.tryHit(new Point(2, 'C'), detector));
	}
	
	@Test
	public void tryHitDestroyerTest() {
		
		BaseShip ship = new Destroyer(new Point(1, 'A'), new Point(1, 'B'));
		CollisionDetector detector = new CollisionDetector();
		
		assertEquals(Constants.HitStatus.SHIPHIT, ship.tryHit(new Point(1, 'A'), detector));
		assertEquals(Constants.HitStatus.MISS, ship.tryHit(null, detector));
		assertEquals(Constants.HitStatus.ALREADYHIT, ship.tryHit(new Point(1, 'A'), detector));
		assertEquals(Constants.HitStatus.SHIPSANKED, ship.tryHit(new Point(1, 'B'), detector));
		assertEquals(Constants.HitStatus.MISS, ship.tryHit(new Point(1, 'C'), detector));
	}
}
