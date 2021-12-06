public class Rook extends Piece {

	public Rook(int color, Position position) {
		super(color, position);
	}

	@Override
	public boolean isValidMove(Position position, Cell[][] board) {
		if (position.getRow() > super.position.getRow() && position.getColumn() == super.position.getColumn()) {
			for(int i = super.position.getRow() + 1; i< position.getRow(); i++) {
				if(board[i][position.getColumn()].getCurrentPiece() != null) {
					return false;
				}
			}
		} else if (position.getColumn() > super.position.getColumn() && position.getRow() == super.position.getRow()) {
			for(int i = super.position.getColumn() + 1; i< position.getColumn(); i++) {
				if(board[position.getRow()][i].getCurrentPiece() != null) {
					return false;
				}
			}
		} else if (position.getRow() < super.position.getRow() && position.getColumn() == super.position.getColumn()) {
			for(int i = position.getRow() + 1; i < super.position.getRow(); i++) {
				if(board[i][position.getColumn()].getCurrentPiece() != null) {
					return false;
				}
			}
		} else if (position.getColumn() < super.position.getColumn() && position.getRow() == super.position.getRow()) {
			for(int i = position.getColumn() + 1; i < super.position.getColumn(); i++) {
				if(board[position.getRow()][i].getCurrentPiece() != null) {
					return false;
				}
			}
			
		}	
		if (board[position.getRow()][position.getColumn()].getCurrentPiece() != null) {
			if(board[position.getRow()][position.getColumn()].getCurrentPiece().color == super.color) return false;
		}
		
		
		return true;
	}

	@Override
	public String toString() {
		if (super.color == 0)
			return "\u265C";
		else
			return "\u2656";
	}

	@Override
	public char toChar() {
		return 'R';
	}
}
