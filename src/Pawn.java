public class Pawn extends Piece {

	public Pawn(int color, Position position) {
		super(color, position);
	}

	@Override
	public boolean isValidMove(Position position, Cell[][] board) {
		return board[position.getRow()][position.getColumn()].getCurrentPiece() == null &&
				((position.getRow() == super.position.getRow() + 1 && super.color == 1 && position.getColumn() == super.position.getColumn()) ||
				(position.getRow() == super.position.getRow() - 1 && super.color == 0 && position.getColumn() == super.position.getColumn()));
		
	}

	@Override
	public String toString() {
		if(super.color == 0)
			return "\u265F";
		else
			return "\u2659";
	}

	@Override
	public char toChar() {
		return 'P';
	}
}
