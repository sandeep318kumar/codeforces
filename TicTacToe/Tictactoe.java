import java.util.LinkedList;
import java.util.Scanner;

class Tictactoe {
    public Board board;
    public LinkedList<Player> players;

    public void initializeGame(int size) {
        this.board = new Board(size);
        players = new LinkedList<>();
        players.add(new Player("P1", new PlayingPieceX()));
        players.add(new Player("P2", new PlayingPieceO()));
    }

    public String startGame() {
        while(board.getFreeCells()) {
            Player currentPlayer = players.removeFirst();

            board.printGrid();

            System.out.println(currentPlayer.getName() + ", piece: " + currentPlayer.getPieceType() +  " Please enter [row, column]");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int row = Integer.valueOf(values[0].trim());
            int col = Integer.valueOf(values[1].trim());
            boolean added = board.addPiece(row, col, currentPlayer.getPlayingPiece());
            if(!added) {
                System.out.println("Invalid move, try again");
                players.addFirst(currentPlayer);
                continue;
            }

            players.addLast(currentPlayer);
            if(winningCheck(row, col, currentPlayer.getPieceType())) {
                board.printGrid();
                return currentPlayer.getName() + ", piece: " +currentPlayer.getPieceType() + " Wins!!!";
            }
        }
        return "DRAW";
    }
    private boolean winningCheck(int row, int col, PieceType type) {
        boolean rowMatch = true, colMatch = true, diagMatch = true, revDiagMatch = true;

        for(int i = 0;i<board.size;i++) {
            if(board.grid[row][i] == null || board.grid[row][i].type != type) rowMatch = false;
            if(board.grid[i][col] == null || board.grid[i][col].type != type) colMatch = false;
            if(board.grid[i][i] == null || board.grid[i][i].type != type) diagMatch = false;
            if(board.grid[i][board.size - i - 1] == null || board.grid[i][board.size - i - 1].type != type ) revDiagMatch = false;

        }
        return rowMatch || colMatch || diagMatch || revDiagMatch;
    }
}