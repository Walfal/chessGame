package chessGame;

public abstract class Piece {
	
	protected Position position;
	protected int color;
	
	public Piece(int color, Position position) {
		this.color = color;
		this.position = position;
	}
	
	public abstract boolean isValidMove(Position position, Cell[][] board);
	public abstract String toString();
	public abstract char toChar();
}
