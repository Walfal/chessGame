public class Knight extends Piece {

	public Knight(int color, Position position) {
		super(color, position);
	}

	@Override
    public boolean isValidMove(Position position, Cell[][] board) {
    if (3 == Math.abs(position.getRow() - this.position.getRow()) + Math.abs(position.getColumn() - this.position.getColumn())
        && (Math.abs(position.getRow() - this.position.getRow()) == 1 || Math.abs(position.getRow() - this.position.getRow()) == 2)
      ) {
        return true;
    }
    return false;
	}

	@Override
	public String toString() {
		if (super.color == 0)
			return "\u2658";
		else
			return "\u265E";
	}

	@Override
	public char toChar() {
		return 'N';
	}
}
