package Model;

import java.util.ArrayList;
import Constants.HitStatus;
import Utils.CollisionDetector;

public abstract class BaseShip {

	private boolean alreadySanked = false;
	private int startRow;
	private char startColumn;
	private int endRow;
	private char endColumn;

	protected ArrayList<Point> hits = new ArrayList<Point>();

	/**
	 * @param startRow
	 * @param startColumn
	 * @param endRow
	 * @param endColumn
	 */
	public BaseShip(int startRow, char startColumn, int endRow, char endColumn) {
		super();
		this.startRow = startRow;
		this.startColumn = startColumn;
		this.endRow = endRow;
		this.endColumn = endColumn;
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

	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public char getStartColumn() {
		return startColumn;
	}
	public void setStartColumn(char startColumn) {
		this.startColumn = startColumn;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public char getEndColumn() {
		return endColumn;
	}
	public void setEndColumn(char endColumn) {
		this.endColumn = endColumn;
	}
}
