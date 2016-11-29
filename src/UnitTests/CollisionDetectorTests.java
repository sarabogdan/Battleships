package UnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

import Model.BaseShip;
import Model.Destroyer;
import Model.Point;
import Utils.CollisionDetector;

public class CollisionDetectorTests {

	@Test
	public void hasCollisionWithListOfShipsTest() {

		CollisionDetector detector = new CollisionDetector();
		BaseShip newShip = new Destroyer(1, 'A', 1, 'B');
		
		BaseShip innerShip1 = new Destroyer(1, 'A', 1, 'A');
		BaseShip innerShip2 = new Destroyer(1, 'C', 1, 'B');
		
		ArrayList<BaseShip> existingShips = new ArrayList<BaseShip>();
		existingShips.add(innerShip1);
		existingShips.add(innerShip2);

		boolean result = detector.hasCollisionWithListOfShips(newShip, existingShips);
		assertEquals(result, true);
		
		existingShips.clear();
		result = detector.hasCollisionWithListOfShips(newShip, existingShips);
		assertEquals(result, false);
		
		result = detector.hasCollisionWithListOfShips(null, existingShips);
		assertEquals(result, false);
		
		result = detector.hasCollisionWithListOfShips(newShip, null);
		assertEquals(result, false);
		
		result = detector.hasCollisionWithListOfShips(null, null);
		assertEquals(result, false);
		
		BaseShip innerShip3 = new Destroyer(1, 'C', 1, 'D');
		existingShips.add(innerShip3);
		
		result = detector.hasCollisionWithListOfShips(null, null);
		assertEquals(result, false);
	}
	
	@Test
	public void isPontInsideShipTest()
	{
		CollisionDetector detector = new CollisionDetector();
		BaseShip newShip = new Destroyer(1, 'A', 1, 'D');
		Point p = new Point(1, 'B');
		Point p1 = new Point(1, 'C');
		Point p2 = null;
		Point p3 = new Point(1, 'F');
		Point p4 = new Point(5, 'J');

		assertEquals(true, detector.isPointInsideShip(p, newShip));
		assertEquals(true, detector.isPointInsideShip(p1, newShip));
		assertEquals(false, detector.isPointInsideShip(p2, newShip));
		assertEquals(false, detector.isPointInsideShip(p3, newShip));
		assertEquals(false, detector.isPointInsideShip(p4, newShip));
	}
}