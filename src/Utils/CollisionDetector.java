package Utils;

import java.util.ArrayList;

import Constants.Constants;
import Model.BaseShip;
import Model.Point;

public class CollisionDetector {

	public boolean hasCollisionWithListOfShips(BaseShip newShip, ArrayList<BaseShip> existingShips)
	{
		if (newShip == null || existingShips == null)
		{
			return false;
		}
		
		for(BaseShip bs: existingShips)
		{
			if (this.collide(bs, newShip))
			{
				return true;
			}
		}

		return false;
	}

	public boolean isPointInsideShip(Point hit, BaseShip a)
	{
		if (hit == null || a == null)
		{
			return false;
		}
		
		if (a.getStartColumn() == hit.getColumn() && a.getEndColumn() == hit.getColumn())
		{
			if (a.getStartRow() <= hit.getRow() && a.getEndRow() >= hit.getRow())
			{
				return true;
			}
		}
		else
			if (a.getStartRow() == hit.getRow() && a.getEndRow() == hit.getRow())
			{
				if (a.getStartColumn() <= hit.getColumn() && a.getEndColumn() >= hit.getColumn())
				{
					return true;
				}
			}

		return false;
	}
	
	private boolean collide(BaseShip a, BaseShip b)
	{
		if (a == null || b == null)
		{
			return false;
		}
		
		for (int i = 1; i <= Constants.TABLE_SIZE; i++)
		{
			for (char j: Constants.TABLE_COLUMNS.toCharArray())
			{
				Point test = new Point(i, j);
				if (this.isPointInsideShip(test, a) && this.isPointInsideShip(test, b))
				{
					return true;
				}
			}
		}

		return false;
	}
}
