public class Queen extends Piece {

	public Queen(int color, Position position) {
		super(color, position);
	}

	@Override
  public boolean isValidMove(Position position, Cell[][] board) {
    //Rook move + Bishop move
		if (position.getRow() > super.position.getRow() && position.getColumn() == super.position.getColumn()) {
      for (int i = super.position.getRow() + 1; i < position.getRow(); i++) {
        if (board[i][position.getColumn()].getCurrentPiece() != null) {
          return false;
        }
      }
      return true;
		} else if (position.getColumn() > super.position.getColumn() && position.getRow() == super.position.getRow()) {
			for(int i = super.position.getColumn() + 1; i < position.getColumn(); i++) {
				if(board[position.getRow()][i].getCurrentPiece() != null) {
					return false;
				}
			}
      return true;
		} else if (position.getRow() < super.position.getRow() && position.getColumn() == super.position.getColumn()) {
			for(int i = position.getRow() + 1; i < super.position.getRow(); i++) {
				if(board[i][position.getColumn()].getCurrentPiece() != null) {
					return false;
				}
			}
      return true;
		} else if (position.getColumn() < super.position.getColumn() && position.getRow() == super.position.getRow()) {
			for(int i = position.getColumn() + 1; i < super.position.getColumn(); i++) {
				if(board[position.getRow()][i].getCurrentPiece() != null) {
					return false;
				}
			}
      return true;
		}
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
			return "\u265B";
		else
			return "\u2655";
	}

	@Override
	public char toChar() {
		return 'Q';
	}
}
