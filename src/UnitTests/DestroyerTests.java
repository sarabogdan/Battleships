package UnitTests;

import static org.junit.Assert.*;
import org.junit.Test;

import Model.BaseShip;
import Model.Destroyer;
import Model.Point;
import Utils.CollisionDetector;

public class DestroyerTests {

	@Test
	public void tryHitBattleshipTest() {

		BaseShip ship = new Destroyer(3, 'B', 3, 'C');
		CollisionDetector detector = new CollisionDetector();

		assertEquals(ship.isSanked(), false);
		ship.tryHit(new Point(3, 'B'), detector);
		ship.tryHit(new Point(3, 'C'), detector);
		assertEquals(ship.isSanked(), true);
	}
}
