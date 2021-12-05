package chessGame;

public class Cell {
	
	final private Position position;
	private Piece currentPiece = null;
	
	public Cell(Position position) {
		this.position = position;
	}
	
	public Position getPosition() {
		return position;
	}

	public Piece getCurrentPiece() {
		return currentPiece;
	}

	public void setCurrentPiece(Piece currentPiece) {
		this.currentPiece = currentPiece;
	}
	
	
}
