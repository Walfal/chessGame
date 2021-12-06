public class Bishop extends Piece {

	public Bishop(int color, Position position) {
		super(color, position);
	}

	@Override
  public boolean isValidMove(Position position, Cell[][] board) {
    int[] dest = { position.getRow(), position.getColumn() };
    if (Math.abs(dest[0] - super.position.getRow()) != Math.abs(dest[1] - super.position.getColumn())) {
      return false;
    }

    int deep = Math.abs(position.getRow() - super.position.getRow()) - 1;
		if (dest[0] > super.position.getRow() && dest[1] > super.position.getColumn()) {
      for (int i = 1; i < deep; i++) {
        if (board[dest[0] - i][dest[1] - i].getCurrentPiece() != null) {
          return false;
        }
      }
      return true;
		} else if (dest[0] > super.position.getRow() && dest[1] < super.position.getColumn()) {
      for (int i = 1; i < deep; i++) {
        if (board[dest[0] - i][dest[1] + i].getCurrentPiece() != null) {
          return false;
        }
      }
      return true;
		} else if (dest[0] < super.position.getRow() && dest[1] > super.position.getColumn()) {
      for (int i = 1; i < deep; i++) {
        if (board[dest[0] + i][dest[1] - i].getCurrentPiece() != null) {
          return false;
        }
      }
      return true;
		} else if (dest[0] < super.position.getRow() && dest[1] < super.position.getColumn()) {
      for (int i = 1; i < deep; i++) {
        if (board[dest[0] + i][dest[1] + i].getCurrentPiece() != null) {
          return false;
        }
      }
      return true;
		}	
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
