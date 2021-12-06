public class Pawn extends Piece {

	public Pawn(int color, Position position) {
		super(color, position);
	}

	@Override
  public boolean isValidMove(Position position, Cell[][] board) {
    switch (super.color) {
      case 0:
        // Si le pion veut aller tout droit
        if (board[position.getRow()][position.getColumn()].getCurrentPiece() == null
            && position.getColumn() == super.position.getColumn()) {
          if (position.getRow() == super.position.getRow() - 1) {
            return true;
          } else if (position.getRow() == super.position.getRow() - 2
              && super.position.getRow() == 6
              && board[position.getRow() - 1][position.getColumn() - 1].getCurrentPiece() == null) {
            return true;
          }
        } // Si le pion veut aller en diagonale
        else if (Math.abs(position.getColumn() - super.position.getColumn()) == 1
            && position.getRow() == super.position.getRow() - 1
            && board[position.getRow()][position.getColumn()].getCurrentPiece() != null
            && board[position.getRow()][position.getColumn()].getCurrentPiece().color != super.color) {
          return true;
        }
        break;
      case 1:
        // Si le pion veut aller tout droit
        if (board[position.getRow()][position.getColumn()].getCurrentPiece() == null
            && position.getColumn() == super.position.getColumn()) {
          if (position.getRow() == super.position.getRow() + 1) {
            return true;
          } else if (position.getRow() == super.position.getRow() + 2
              && super.position.getRow() == 1
              && board[position.getRow() + 1][position.getColumn() + 1].getCurrentPiece() == null) {
            return true;
          }
        } // Si le pion veut aller en diagonale
        else if (Math.abs(position.getColumn() - super.position.getColumn()) == 1
            && position.getRow() == super.position.getRow() + 1
            && board[position.getRow()][position.getColumn()].getCurrentPiece() != null
            && board[position.getRow()][position.getColumn()].getCurrentPiece().color != super.color) {
          return true;
        }
        break;
    }
    //TODO Prise en passant
    return false;
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
