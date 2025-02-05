public class DiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(char symbol, Board board) {
        boolean mainDiagonal = true, antiDiagonal = true;

        for (int i = 0; i < board.getSize(); i++) {
            if (board.getCell(i, i) != symbol) mainDiagonal = false;
            if (board.getCell(i, board.getSize() - i - 1) != symbol) antiDiagonal = false;
        }

        return mainDiagonal || antiDiagonal;
    }
}
