package Model;

public class Point
{
	private int row;
	private char column;
	/**
	 * @param row
	 * @param rolumn
	 */
	public Point(int row, char column) {
		super();
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public char getColumn() {
		return column;
	}
	public void setColumn(char column) {
		this.column = column;
	}
}