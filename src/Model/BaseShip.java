package Model;

import java.util.ArrayList;
import Constants.HitStatus;
import Utils.CollisionDetector;

public abstract class BaseShip {

	private boolean alreadySanked = false;
	
	private Point startPoint;
	private Point endPoint;

	protected ArrayList<Point> hits = new ArrayList<Point>();

	/**
	 * @param startRow
	 * @param startColumn
	 * @param endRow
	 * @param endColumn
	 */
	public BaseShip(Point startPoint, Point endPoint) {
		super();
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	public abstract boolean isSanked();

	public int tryHit(Point hit, CollisionDetector detector)
	{
		if (hit == null || !detector.isPointInsideShip(hit, this))
		{
			return HitStatus.MISS;
		}

		if (this.alreadySanked == false)
		{
			if (this.checkIfAlreadyHit(hit))
			{
				return HitStatus.ALREADYHIT;
			}
			
			this.hits.add(hit);
			if (this.isSanked())
			{
				this.alreadySanked = true;
				return HitStatus.SHIPSANKED;
			}
		}
		else
		{
			return HitStatus.ALREADYSANKED;
		}

		return HitStatus.SHIPHIT;
	}

	private boolean checkIfAlreadyHit(Point testHit)
	{
		if (testHit == null)
		{
			return false;
		}
		
		for (Point hit: this.hits)
		{
			if (testHit.getRow() == hit.getRow() && testHit.getColumn() == hit.getColumn())
			{
				return true;
			}
		}

		return false;
	}

	public Point getStartPoint() {
		return this.startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public Point getEndPoint() {
		return this.endPoint;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
}
