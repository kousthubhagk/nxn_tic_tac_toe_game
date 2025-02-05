import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(char symbol, Board board) {
        super(symbol, board);
    }

    @Override
    public void makeMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.print("Enter your move (row and column): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (!board.placeMove(row, col, symbol));
    }
}
