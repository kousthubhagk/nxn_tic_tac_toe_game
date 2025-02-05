import java.util.Random;

public class BotPlayer extends Player {

    public BotPlayer(char symbol, Board board) {
        super(symbol, board);
    }

    @Override
    public void makeMove() {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(board.getSize());
            col = random.nextInt(board.getSize());
        } while (!board.placeMove(row, col, symbol));
        System.out.println("Bot placed at (" + row + ", " + col + ")");
    }
}
