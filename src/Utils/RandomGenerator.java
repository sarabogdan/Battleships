package Utils;

import java.util.Random;

import Constants.Constants;
import Interfaces.IRandomGenerator;

// Generate top left corner
public class RandomGenerator implements IRandomGenerator{
	Random r = new Random(System.currentTimeMillis());

	public char GetRandomColumn()
	{
		return Constants.TABLE_COLUMNS.charAt(r.nextInt(Constants.TABLE_SIZE));
	}

	public int GetRandomRow()
	{
		return 1 + r.nextInt(Constants.TABLE_SIZE - 1);
	}

	public int GetRandomDirection()
	{
		return r.nextInt(1);
	}
}
