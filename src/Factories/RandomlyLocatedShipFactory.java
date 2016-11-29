package Factories;

import Constants.Constants;
import Interfaces.IRandomGenerator;
import Interfaces.IRandomlyLocatedShipFactory;
import Model.BaseShip;
import Model.Battleship;
import Model.Destroyer;
import Model.Point;

public class RandomlyLocatedShipFactory implements IRandomlyLocatedShipFactory {
	private IRandomGenerator rnd;

	public RandomlyLocatedShipFactory(IRandomGenerator rnd)
	{
		this.rnd = rnd;
	}

	/* (non-Javadoc)
	 * @see Factories.IRandomlyLocatedShipFactory#GenerateRandomShip(int)
	 */
	@Override
	public BaseShip GenerateRandomShip(int length) throws Exception
	{
		char column = this.rnd.GetRandomColumn();
		int row = this.rnd.GetRandomRow();
		int direction = this.rnd.GetRandomDirection();
		char endColumn = column;
		int endRow = row;

		if (direction == Constants.DIRECTION_TOP_BOTTOM)
		{
			endColumn = column;

			for (int i = 0 ; i < length - 1; ++i)
			{
				endColumn++;
			}

			endRow = row;
		}
		else
			if (direction == Constants.DIRECTION_LEFT_RIGHT)
			{
				endRow = row + length - 1;
				endColumn = column;
			}

		if (length == Constants.DESTROYER_LENGTH)
		{
			return new Destroyer(new Point(row, column), new Point(endRow, endColumn));
		}

		if (length == Constants.BATTLESHIP_LENGTH)
		{
			return new Battleship(new Point(row, column), new Point(endRow, endColumn));
		}

		throw new Exception("This type of ship is not supported yet");
	}
}
