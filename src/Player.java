public abstract class Player {
    protected char symbol;
    protected Board board;

    public Player(char symbol, Board board) {
        this.symbol = symbol;
        this.board = board;
    }

    public char getSymbol() {
        return symbol;
    }

    public abstract void makeMove();
}
