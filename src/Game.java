import java.util.*;

public class Game {
    private Board board;
    private List<Player> players;
    private WinningStrategy winningStrategy;

    public Game(int size, int humanPlayers, int botPlayers) {
        board = new Board(size);
        players = new ArrayList<>();
        initializePlayers(size, humanPlayers, botPlayers);
        winningStrategy = WinningStrategyFactory.createWinningStrategy(size);
    }

    private void initializePlayers(int size, int humanPlayers, int botPlayers) {
        Scanner scanner = new Scanner(System.in);
        Set<Character> symbols = new HashSet<>();
        System.out.println("Choose symbols for Human Players:");
        for (int i = 0; i < humanPlayers; i++) {
            System.out.print("Player " + (i + 1) + " Symbol: ");
            char symbol = scanner.next().charAt(0);
            while (symbols.contains(symbol)) {
                System.out.print("Symbol already taken, choose another: ");
                symbol = scanner.next().charAt(0);
            }
            symbols.add(symbol);
            players.add(new HumanPlayer(symbol, board));
        }

        Random random = new Random();
        System.out.println("Assigning symbols to Bots:");
        for (int i = 0; i < botPlayers; i++) {
            char symbol;
            do {
                symbol = (char) ('A' + random.nextInt(26));
            } while (symbols.contains(symbol));
            symbols.add(symbol);
            System.out.println("Bot " + (i + 1) + " Symbol: " + symbol);
            players.add(new BotPlayer(symbol, board));
        }
    }

    public void start() {
        int currentPlayer = 0;
        while (true) {
            Player player = players.get(currentPlayer);
            System.out.println("Player " + (currentPlayer + 1) + " (" + player.getSymbol() + ")'s turn:");
            player.makeMove();
            board.printBoard();

            if (winningStrategy.checkWin(player.getSymbol(), board)) {
                System.out.println("Player " + (currentPlayer + 1) + " (" + player.getSymbol() + ") wins!");
                break;
            }

            if (board.isFull()) {
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer + 1) % players.size();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the dimension of the board (n x n): ");
        int size = scanner.nextInt();

        System.out.print("Enter the number of human players: ");
        int humanPlayers = scanner.nextInt();

        System.out.print("Enter the number of bot players: ");
        int botPlayers = scanner.nextInt();

        if (humanPlayers + botPlayers < size - 1 || humanPlayers + botPlayers > size - 1) {
            System.out.println("Invalid number of players! There must be exactly " + (size - 1) + " players.");
            return;
        }

        Game game = new Game(size, humanPlayers, botPlayers);
        game.start();
    }
}
