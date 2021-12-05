package chessGame;

public class Position {
	
	int column;
	int row;
	
	public Position(int row, int column) {
		super();
		this.column = column;
		this.row = row;
	}

	public char getCharColumn() {
		return (char)(97 + column);
	}
	
	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "Position [column=" + column + ", row=" + row + "]";
	}

	
	
}
