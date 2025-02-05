public class RowWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(char symbol, Board board) {
        for (int i = 0; i < board.getSize(); i++) {
            boolean win = true;
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getCell(i, j) != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        return false;
    }
}
