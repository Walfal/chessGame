import java.util.Scanner;

public class Chess {
  private Cell[][] board   = new Cell[8][8];
  private Player[] players = new Player[2];
  private Scanner sc       = new Scanner(System.in);
  //TODO Victory case
  //TODO Check & check mate

  public void play() {
    initialiseBoard();
    printBoard();
    String move;

    int colorCurrentPlayer = 1;
    while(true) {
      move = askMove(colorCurrentPlayer);
      if(isValidMove(move, colorCurrentPlayer)) {
        updateBoard(move);
        colorCurrentPlayer = (colorCurrentPlayer + 1) % 2;
      } else {
        System.out.println("Your move is invalid");
      }
      printBoard();
    }
  }

  private void updateBoard(String move) {
    String[] moves     = move.split(" ");
    int    startColumn = moves[0].charAt(0) - 97;
    int    startRow    = Character.getNumericValue(moves[0].charAt(1)) - 1;

    int endColumn = moves[1].charAt(0) - 97;
    int endRow    = Character.getNumericValue(moves[1].charAt(1)) - 1;

    board[endRow][endColumn].setCurrentPiece(board[startRow][startColumn].getCurrentPiece());
    board[endRow][endColumn].getCurrentPiece().position.setRow(endRow);
    board[endRow][endColumn].getCurrentPiece().position.setColumn(endColumn);
    board[startRow][startColumn].setCurrentPiece(null);
  }

  private boolean isValidMove(String move, int colorCurrentPlayer) {
    if (!move.matches("([a-h][1-8] [a-h][1-8])")) {
      return false;
    }
    String[] moves  = move.split(" ");
    int startColumn = moves[0].charAt(0) - 97;
    int startRow    = Character.getNumericValue(moves[0].charAt(1)) - 1;

    int endColumn = moves[1].charAt(0) - 97;
    int endRow = Character.getNumericValue(moves[1].charAt(1)) - 1;

    if (board[startRow][startColumn].getCurrentPiece() == null
        || moves[0] == moves[1]
        || board[startRow][startColumn].getCurrentPiece().color != colorCurrentPlayer
        || (board[endRow][endColumn].getCurrentPiece() != null && board[endRow][endColumn].getCurrentPiece().color == colorCurrentPlayer)) {
      return false;
    }
    return board[startRow][startColumn].getCurrentPiece().isValidMove(new Position(endRow, endColumn), board);
  }

  private void initialiseBoard() {
    System.out.print("Enter the name of the 1st player : ");
    String name1 = sc.nextLine();
    players[1] = new Player(name1, 1);
    System.out.print("Enter the name of the 2sd player : ");
    String name2 = sc.nextLine();
    players[0] = new Player(name2, 0);

    for(int i = 0; i < 8; i++) {
      for(int j = 0; j < 8; j++) {
        Position position = new Position(i, j);
        board[i][j] = new Cell(position);

        if((i == 0 && j == 0) || (i == 0 && j == 7)) {
          board[i][j].setCurrentPiece(new Rook(1, position));
        } else if((i == 7 && j == 0) || (i == 7 && j == 7)) {
          board[i][j].setCurrentPiece(new Rook(0, position));
        } else if ((i == 0 && j == 1) || (i == 0 && j == 6)) {
          board[i][j].setCurrentPiece(new Knight(1, position));
        } else if ((i == 7 && j == 1) || (i == 7 && j == 6)) {
          board[i][j].setCurrentPiece(new Knight(0, position));
        } else if ((i == 0 && j == 2) || (i == 0 && j == 5)) {
          board[i][j].setCurrentPiece(new Bishop(1, position));
        } else if ((i == 7 && j == 2) || (i == 7 && j == 5)) {
          board[i][j].setCurrentPiece(new Bishop(0, position));
        } else if ((i == 0 && j == 3)) {
          board[i][j].setCurrentPiece(new Queen(1, position));
        } else if ((i == 7 && j == 3)) {
          board[i][j].setCurrentPiece(new Queen(0, position));
        } else if (i == 0 && j == 4) {
          board[i][j].setCurrentPiece(new King(1, position));
        } else if (i == 7 && j == 4){
          board[i][j].setCurrentPiece(new King(0, position));
        } else if (i == 1) {
          board[i][j].setCurrentPiece(new Pawn(1, position));
        } else if (i == 6) {
          board[i][j].setCurrentPiece(new Pawn(0, position));
        }
      }
    }
  }

  private void printBoard() {
    System.out.println("\n   a b c d e f g h");
    for(int i = 7; i >= 0; i--) {
      System.out.print(i + 1 + "  ");
      for(int j = 0; j < 8; j++) {
        if(board[i][j].getCurrentPiece() == null) {
          System.out.print(".");
        } else {
          System.out.print(board[i][j].getCurrentPiece().toString());
        }
        System.out.print(" ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private String askMove(int i) {
    System.out.print(players[i].getName() + ", it's your turn : ");
    String move = sc.nextLine();
    return move;
  }
}