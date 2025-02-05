import java.util.List;
import java.util.Arrays;

public class CompositeWinningStrategy implements WinningStrategy {
    private List<WinningStrategy> strategies;

    public CompositeWinningStrategy(WinningStrategy... strategies) {
        this.strategies = Arrays.asList(strategies);
    }

    @Override
    public boolean checkWin(char symbol, Board board) {
        for (WinningStrategy strategy : strategies) {
            if (strategy.checkWin(symbol, board)) return true;
        }
        return false;
    }
}
