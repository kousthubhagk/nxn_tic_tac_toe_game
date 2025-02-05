public class ColumnWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(char symbol, Board board) {
        for (int j = 0; j < board.getSize(); j++) {
            boolean win = true;
            for (int i = 0; i < board.getSize(); i++) {
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
