public class King extends Piece {


	public King(int color, Position position) {
		super(color, position);
	}

	@Override
	public boolean isValidMove(Position position, Cell[][] board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		if (super.color == 0)
			return "\u265A";
		else
			return "\u2654";
	}

	@Override
	public char toChar() {
		return 'K';
	}
}
