package chessGame;

public class Knight extends Piece {

	public Knight(int color, Position position) {
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
		if (super.color == 0) {
			return "\u2658";
		} else {
			return "\u265E";
		}
	}
	
	@Override
	public char toChar() {
		return 'N';
	}

}
