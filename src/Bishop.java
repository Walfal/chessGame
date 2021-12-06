public class Bishop extends Piece {

	public Bishop(int color, Position position) {
		super(color, position);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Position position, Cell[][] board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		if (super.color == 0)
			return "\u265D";
		else
			return "\u2657";
	}

	@Override
	public char toChar() {
		return 'B';
	}
}
