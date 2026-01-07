
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
    }
    
    public void startTheGame() {
        while(true) {
            Player currentPlayer = players.removeFirst();
            players.addLast(currentPlayer);

            System.out.println("current player turn is: " + currentPlayer.name + " current position is: " + currentPlayer.currentPosition);
            int diceCount = dice.rollDice();
            System.out.println("Dice number: " + diceCount);

            int newPosition = currentPlayer.currentPosition + diceCount;
            newPosition = jumpCheck(newPosition);

            currentPlayer.currentPosition = newPosition;
            if(currentPlayer.currentPosition >= board.grid.length * board.grid.length - 1 ) {
                System.out.println(currentPlayer.name + " Winner!!");
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