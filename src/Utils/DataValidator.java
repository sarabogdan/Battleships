package Utils;

import Model.BaseShip;
import Model.Point;

public class DataValidator {

	public Point tryGetValidInput(String move)
	{
		if ((move == null) || (move.length() != 2 && move.length() != 3))
		{
			return null;
		}

		char column = move.charAt(0);

		try
		{
			if (!Character.toString(column).matches("[A-J]")) {
				return null;
			}

			int row = Integer.parseInt(move.substring(1, move.length()));
			if ( row < 1 || row > 10) {
				return null;
			}
			
			return new Point(row, column);
		}
		catch(Exception ex)
		{
			return null;
		}
	}

	public boolean hasValidCoordinates(BaseShip ship)
	{
		if (ship.getStartColumn() <= ship.getEndColumn() && ship.getStartRow() <= ship.getEndRow())
		{
			if (ship.getStartColumn() >= 'A' && ship.getEndColumn() >= 'A' && ship.getStartColumn() <= 'J' && ship.getEndColumn() <= 'J')
				if (ship.getStartRow() >= 1 && ship.getEndRow() >= 1 && ship.getStartRow() <= 10 && ship.getEndRow() <= 10)
				{
					return true;
				}
		}
		return false;
	}

}
