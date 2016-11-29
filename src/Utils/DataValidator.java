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
		
		if (move.length() == 3)
		{
			if (move.charAt(2) != '0')
			{
				return null;
			}
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
		if (ship.getStartPoint().getColumn() <= ship.getEndPoint().getColumn() && ship.getStartPoint().getRow() <= ship.getEndPoint().getRow())
		{
			if (ship.getStartPoint().getColumn() >= 'A' && ship.getEndPoint().getColumn() >= 'A' && ship.getStartPoint().getColumn() <= 'J' && ship.getEndPoint().getColumn() <= 'J')
				if (ship.getStartPoint().getRow() >= 1 && ship.getEndPoint().getRow() >= 1 && ship.getStartPoint().getRow() <= 10 && ship.getEndPoint().getRow() <= 10)
				{
					return true;
				}
		}
		return false;
	}

}
