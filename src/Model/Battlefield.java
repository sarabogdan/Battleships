package Model;

import java.util.ArrayList;

import Constants.HitStatus;
import Constants.Constants;
import Interfaces.IRandomlyLocatedShipFactory;
import Utils.CollisionDetector;
import Utils.DataValidator;

public class Battlefield {

	int battleShips = 0;
	int destroyers = 0;

	private ArrayList<BaseShip> ships = new ArrayList<BaseShip>();
	private IRandomlyLocatedShipFactory factory;
	private CollisionDetector detector;
	private DataValidator validator;

	/**
	 * @param factory
	 * @param detector
	 * @param validator
	 */
	public Battlefield(IRandomlyLocatedShipFactory factory, CollisionDetector detector, DataValidator validator) {
		super();
		this.factory = factory;
		this.detector = detector;
		this.validator = validator;
	}

	public void clear()
	{
		ships.clear();
		battleShips = 0;
		destroyers = 0;
	}

	public void init() {
		try
		{
			this.clear();
			for (int i = 0 ; i < Constants.BATTLESHIP_NO; ++i)
			{
				this.addRandomBattleship();
			}

			for (int i = 0 ; i < Constants.DESTROYER_NO; ++i)
			{
				this.addRandomDestroyer();
			}
		}
		catch (Exception e) 
		{
			System.out.println("Setting up the battlefield failed.");
		}
	}

	private void addRandomDestroyer() throws Exception
	{
		if (destroyers < Constants.DESTROYER_NO)
		{
			destroyers++;
			this.addShipAtRandomLocation(Constants.DESTROYER_LENGTH);		
		}
		else
		{
			throw new Exception("You tried to add too many Destroyers. Clear the battle field first.");
		}
	}

	private void addRandomBattleship() throws Exception
	{
		if (battleShips < Constants.BATTLESHIP_NO)
		{
			battleShips++;
			this.addShipAtRandomLocation(Constants.BATTLESHIP_LENGTH);		
		}
		else
		{
			throw new Exception("You tried to add too many Battleships. Clear the battle field first.");
		}
	}

	public int tryHit(Point hit)
	{
		for(BaseShip ship: this.ships)
		{
			int status = ship.tryHit(hit, detector);
			if (status != HitStatus.MISS)
			{
				return status;
			}
		}

		return HitStatus.MISS;
	}

	private void addShipAtRandomLocation(int shipLength) throws Exception {
		while (true)
		{
			BaseShip ship = factory.GenerateRandomShip(shipLength);
			
			if (ship != null && !this.detector.hasCollisionWithListOfShips(ship, this.ships) && this.validator.hasValidCoordinates(ship))
			{
				this.ships.add(ship);
				break;
			}
		}
	}
}
