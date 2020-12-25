
public class Game {
	private int numColumns = 7;
	private int numRows = 6;
	private int [][] board = new int [numColumns][numRows];
	private boolean [] full = new boolean [numColumns];
	private int remainingColumns = numColumns;
	
	private int computerSpace;
	private int playerSpace;
	
	public Game() {

	}
	
	public void setOrder(boolean first) {
		if (first) {
			computerSpace = 2;
			playerSpace = 1;
		}
		else {
			computerSpace = 1;
			playerSpace = 2;
		}
	}
	
	public void computerMove() {	
		int choose = (int)(Math.random() * remainingColumns) + 1;
		int count = 0;
		int column = 0;
		
		for (int i = 0; count < choose; i++) {
			if (!full[i]) {
				count++;
			}
			
			if (count == choose) {
				column = i;
			}
		}
		
		for (int i = 0; i < numRows; i++) {
			if (board [column][i] == 0) {
				board [column][i] = computerSpace;
				if (i == numRows - 1) {
					full [column] = true;
					remainingColumns--;
				}
				break;
			}
		}
		
	}
	
	public int playerMove(int column) {
		if (column < 1 || column > numColumns) {
			return -1;
		}
		
		if (full [column - 1]) {
			return -1;
		}
		
		for (int i = 0; i < numRows; i++) {
			if (board [column - 1][i] == 0) {
				board [column - 1][i] = playerSpace;
				if (i == numRows - 1) {
					full [column - 1] = true;
					remainingColumns--;
				}
				break;
			}
		}
		
		return 0;
	}
	
	public int checkWin() {
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns - 3; j++) {
				if (board [j] [i] == computerSpace &&
					board [j] [i] == board [j+1][i] &&
					board [j] [i] == board [j+2][i] &&
					board [j] [i] == board [j+3][i]) {
					return 1;
				}
				
				if (board [j] [i] == playerSpace &&
						board [j] [i] == board [j+1][i] &&
						board [j] [i] == board [j+2][i] &&
						board [j] [i] == board [j+3][i]) {
						return 2;
					}
			}
				
		}
		
		for (int j = 0; j < numColumns; j++) {
			for (int i = 0; i < numRows - 3; i++) {
				if (board [j] [i] == computerSpace &&
						board [j] [i] == board [j][i+1] &&
						board [j] [i] == board [j][i+2] &&
						board [j] [i] == board [j][i+3]) {
						return 1;
					}
				
				if (board [j] [i] == playerSpace &&
						board [j] [i] == board [j][i+1] &&
						board [j] [i] == board [j][i+2] &&
						board [j] [i] == board [j][i+3]) {
						return 2;
					}
			}
		}
		
		for (int j = 0; j < numColumns - 3; j++) {
			for (int i = 0; i < numRows - 3; i++){
				if (board [j] [i] == computerSpace &&
						board [j] [i] == board [j+1][i+1] &&
						board [j] [i] == board [j+2][i+2] &&
						board [j] [i] == board [j+3][i+3]) {
						return 1;
					}
				
				if (board [j] [i] == playerSpace &&
						board [j] [i] == board [j+1][i+1] &&
						board [j] [i] == board [j+2][i+2] &&
						board [j] [i] == board [j+3][i+3]) {
						return 2;
					}
			}
		}
		
		for (int j = 0; j < numColumns - 3; j++) {
			for (int i = numRows - 1; i >= 3; i--) {
				if (board [j] [i] == computerSpace &&
						board [j] [i] == board [j+1][i-1] &&
						board [j] [i] == board [j+2][i-2] &&
						board [j] [i] == board [j+3][i-3]) {
						return 1;
					}
				
				if (board [j] [i] == playerSpace &&
						board [j] [i] == board [j+1][i-1] &&
						board [j] [i] == board [j+2][i-2] &&
						board [j] [i] == board [j+3][i-3]) {
						return 2;
					}
			}
		}
		
		return 0;
	}
	
  public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_BLUE = "\u001B[34m";
  
	public void printBoard() {
		for (int i = 1; i <= numColumns; i++) {
			System.out.print(i);
		}
		System.out.println();
		
		for (int i = numRows - 1; i >= 0; i--) {
			for (int j = 0; j < numColumns; j++) {
				if (board [j][i] == 0) {
					System.out.print("o");
				}
				
				if (board [j][i] == 1) {
					System.out.print(ANSI_BLUE + "o" + ANSI_RESET);
				}
				
				if (board [j][i] == 2) {
					System.out.print(ANSI_RED + "o" + ANSI_RESET);
				}
			}
			System.out.println();
		}
		
		System.out.println();
	}
}
