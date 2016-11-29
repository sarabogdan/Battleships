package Model;

import Constants.Constants;

public class Battleship extends BaseShip {

	public Battleship(Point startPoint, Point endPoint) {
		super(startPoint, endPoint);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isSanked() {
		return super.hits.size() == Constants.BATTLESHIP_LENGTH;
	}
}
