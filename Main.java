import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		
		String order = "";
		while (!order.equals("first") && !order.equals("second")) {
			System.out.println("Type \"first\" to go first or \"second\" to go second");
			order = kboard.nextLine();
		}
		System.out.println();
		
		Game main = new Game();
		if (order.equals("first")) {
			main.setOrder(true);
		}
		else {
			main.setOrder(false);
		}
		
		main.printBoard();
		
		int winState = 0;
		if (order.equals("second")) {
			main.computerMove();
			main.printBoard();
		}
		while (winState == 0) {
			int validMove = -1;
			while (validMove == -1) {
				System.out.println("Enter the number of the column to drop a checker");
				int column = kboard.nextInt();
				validMove = main.playerMove(column);
			}
			System.out.println();
			main.printBoard();
			
			winState = main.checkWin();
			if (winState != 0) {
				break;
			}
			
			main.computerMove();
			main.printBoard();
			winState = main.checkWin();
		}
		
		kboard.close();
		
		if (winState == 1) {
			System.out.println("The computer wins");
		}
		else {
			System.out.println("You win");
		}
	}
}
