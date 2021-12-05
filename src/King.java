package chessGame;

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
		if (super.color == 0) {
			return "\u2654";
		} else {
			return "\u265A";
		}
	}
	
	@Override
	public char toChar() {
		return 'K';
	}
	
	
	
}
