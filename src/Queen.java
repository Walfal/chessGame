public class Queen extends Piece {

	public Queen(int color, Position position) {
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
			return "\u265B";
		else
			return "\u2655";
	}

	@Override
	public char toChar() {
		return 'Q';
	}
}
