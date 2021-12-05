package chessGame;

import java.util.Scanner;

public class Chess {
    private Cell[][] board = new Cell[8][8];
    private Player[] players;
    private Player currentPlayer;
    
    final String STRPIECES = "KQBNPR";
    
    private Scanner sc = new Scanner(System.in);
    
    
    public void play() {
    	initialiseBoard();
    	printBoard();
    	
    	String move;
    	
    	while(true) {
	    	move = askMove();
	    	
	    	if(isValidMove(move)) {
	    		updateBoard(move);
	    	} else {
	    		System.out.println("Your move is invalid");
	    	}
	    
	    	printBoard();
    	}
    	
    }
    
    private void updateBoard(String move) {
    	String[] moves = move.split(" ");
		int startColumn = moves[0].charAt(1) - 97;
		int startRow = Character.getNumericValue(moves[0].charAt(2)) - 1;
		
		int endColumn = moves[1].charAt(1) - 97;
		int endRow = Character.getNumericValue(moves[1].charAt(2)) - 1;
		
		board[endRow][endColumn].setCurrentPiece(board[startRow][startColumn].getCurrentPiece());
		board[endRow][endColumn].getCurrentPiece().position.setRow(endRow);
		board[endRow][endColumn].getCurrentPiece().position.setColumn(endColumn);
		board[startRow][startColumn].setCurrentPiece(null);
		
    }
    
    private boolean isValidMove(String move) {
		String[] moves = move.split(" ");
		char piece;
		int startColumn = moves[0].charAt(1) - 97;
		int startRow = Character.getNumericValue(moves[0].charAt(2)) - 1;
		
		int endColumn = moves[1].charAt(1) - 97;
		int endRow = Character.getNumericValue(moves[1].charAt(2)) - 1;
		
		if(moves[0].charAt(0) == moves[1].charAt(0)) {
			piece = moves[0].charAt(0);
		} else {
			return false;
		}
		
		if (STRPIECES.contains(""+piece) && board[startRow][startColumn].getCurrentPiece().toChar() == piece) {
			return board[startRow][startColumn].getCurrentPiece().isValidMove(new Position(endRow, endColumn), board);
		}
		
		return false;
		
	}

	private void initialiseBoard() {    	
    	for(int i = 0; i<8; i++) {
    		for(int j = 0; j < 8; j++) {
    			Position position = new Position(i, j);

    			board[i][j] = new Cell(position);
    			
    			if((i==0 && j==0) || (i==0 && j==7)) {
    				board[i][j].setCurrentPiece(new Rook(1, position));
    			} else if((i==7 && j==0) || (i==7 && j==7)) {
    				board[i][j].setCurrentPiece(new Rook(0, position));
    			} else if ((i==0 && j==1) || (i==0 && j==6)) {
    				board[i][j].setCurrentPiece(new Knight(1, position));
    			} else if ((i==7 && j==1) || (i==7 && j==6)) {
    				board[i][j].setCurrentPiece(new Knight(0, position));
    			} else if ((i==0 && j==2) || (i==0 && j==5)) {
    				board[i][j].setCurrentPiece(new Bishop(1, position));
    			} else if ((i==7 && j==2) || (i==7 && j==5)) {
    				board[i][j].setCurrentPiece(new Bishop(0, position));
    			} else if ((i==0 && j==3)) {
    				board[i][j].setCurrentPiece(new Queen(1, position));
    			} else if ((i==7 && j==3)) {
    				board[i][j].setCurrentPiece(new Queen(0, position));
    			} else if (i==0 && j==4) {
    				board[i][j].setCurrentPiece(new King(1, position));
    			} else if (i==7 && j==4){
    				board[i][j].setCurrentPiece(new King(0, position));
    			} else if (i==1) {
    				// board[i][j].setCurrentPiece(new Pawn(1, position));
    			} else if (i==6) {
    				board[i][j].setCurrentPiece(new Pawn(0, position));
    			}
    		}
    	}
    }
    
    private void printBoard() {
    	System.out.print("\n");
    	for(int i = 7; i>=0; i--) {
    		for(int j = 0; j < 8; j++) {
    			if(board[i][j].getCurrentPiece() == null) {
    				System.out.print(" ");
    			} else {
    				System.out.print(board[i][j].getCurrentPiece().toString());
    			}
    			System.out.print(" ");
    		}
    		System.out.println();
    	}
    	System.out.print("\n");
    }
    
    private String askMove() {
    	System.out.print("Enter your move : ");
    	
    	String move = sc.nextLine();
    	
		return move;
    	
    }
}

