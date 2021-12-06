public class King extends Piece {


	public King(int color, Position position) {
		super(color, position);
	}

	@Override
  public boolean isValidMove(Position position, Cell[][] board) {
    if (Math.abs(position.getRow() - this.position.getRow()) <= 1
        && Math.abs(position.getColumn() - this.position.getColumn()) <= 1
        && (position.getRow() != this.position.getRow() || position.getColumn() != this.position.getColumn())) {
      return true;
    }
    // TODO Rock case
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
