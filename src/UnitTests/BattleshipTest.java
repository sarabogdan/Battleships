package UnitTests;

import static org.junit.Assert.*;
import org.junit.Test;

import Model.BaseShip;
import Model.Battleship;
import Model.Point;
import Utils.CollisionDetector;

public class BattleshipTest {
	@Test
	public void tryHitBattleshipTest() {

		BaseShip ship = new Battleship(new Point(3, 'B'), new Point(3, 'F'));
		CollisionDetector detector = new CollisionDetector();

		assertEquals(ship.isSanked(), false);
		ship.tryHit(new Point(3, 'B'), detector);
		ship.tryHit(new Point(3, 'C'), detector);
		ship.tryHit(new Point(3, 'D'), detector);
		assertEquals(ship.isSanked(), false);
		ship.tryHit(new Point(3, 'E'), detector);
		ship.tryHit(new Point(3, 'F'), detector);
		assertEquals(ship.isSanked(), true);
	}
}
