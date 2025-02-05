public class WinningStrategyFactory {
    public static WinningStrategy createWinningStrategy(int size) {
        // Combine all winning strategies using a composite approach
        return new CompositeWinningStrategy(
                new RowWinningStrategy(),
                new ColumnWinningStrategy(),
                new DiagonalWinningStrategy()
        );
    }
}
