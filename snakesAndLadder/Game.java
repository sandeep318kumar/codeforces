
import java.util.LinkedList;
import java.util.Deque;

class Game {
    Board board;
    Dice dice;
    Deque<Player> players = new LinkedList<>();

    public Game(int size, int snakes, int ladders, int dices) {
        this.board = new Board(size, snakes, ladders);
        this.dice = new Dice(dices);
        addPlayers();
    }

    public void addPlayers() {
        players.add(new Player("P1", "2929"));
        players.add(new Player("P2", "0772w"));
        players.add(new Player("P3", "879gaga"));
        players.add(new Player("P4", "99766gha"));
    }
    
    public void startTheGame() {
        int moves = 0;
        while(true) {
            moves++;
            Player currentPlayer = players.removeFirst();
            players.addLast(currentPlayer);

            System.out.println("current player turn is: " + currentPlayer.name + " current position is: " + currentPlayer.currentPosition);
            int diceCount = dice.rollDice();
            System.out.println("Dice number: " + diceCount);

            int newPosition = currentPlayer.currentPosition + diceCount;
            newPosition = jumpCheck(newPosition);

            if(newPosition >= board.grid.length * board.grid.length)
                continue;
            
            currentPlayer.currentPosition = newPosition;
            System.out.println("current player turn is: " + currentPlayer.name + " new position is: " + currentPlayer.currentPosition);

            if(currentPlayer.currentPosition == board.grid.length * board.grid.length - 1 ) {
                System.out.println(currentPlayer.name + " Winner!!");
                System.out.println("Game finished in moves: " + moves);
                break;
            }
        }
        
    }

    public int jumpCheck(int position) {
        if(position >= board.grid.length * board.grid.length - 1)
            return position;

        Cell currentCell = board.getCell(position);
        if(currentCell.jump != null && currentCell.jump.start == position) {
            String check = (currentCell.jump.start <= currentCell.jump.end) ? "Ladder " : "Snake";
            System.out.println("Jump done by: " + check);
            position = currentCell.jump.end;
        }
        return position;
    }
}