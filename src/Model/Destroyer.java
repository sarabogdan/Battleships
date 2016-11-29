package Model;

import Constants.Constants;

public class Destroyer extends BaseShip {

	public Destroyer(int startRow, char startColumn, int endRow, char endColumn) {
		super(startRow, startColumn, endRow, endColumn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isSanked() {
		return super.hits.size() == Constants.DESTROYER_LENGTH;
	}
}
