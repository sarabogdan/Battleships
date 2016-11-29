package Model;

import Constants.Constants;

public class Destroyer extends BaseShip {

	public Destroyer(Point startPoint, Point endPoint) {
		super(startPoint, endPoint);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isSanked() {
		return super.hits.size() == Constants.DESTROYER_LENGTH;
	}
}
