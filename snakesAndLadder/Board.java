import java.util.concurrent.ThreadLocalRandom;
import java.util.HashSet;
import java.util.Set;

class Board {
    Cell[][] grid;
    Set<Integer> usedJumpStarts = new HashSet<>();

    Board(int size, int snakes, int ladders) {
        initializeGrid(size);
        addSnakesLadders(snakes, ladders);
    }

    public void initializeGrid(int size) {
        grid = new Cell[size][size];
        for(int i= 0;i<size;i++) {
            for(int j = 0;j<size;j++) {
                grid[i][j] = new Cell();
            }
        }
        System.out.println("Grid size is: " + size);
    }

    public void addSnakesLadders(int snakes, int ladders) {

        while(snakes > 0) {
            int size = grid.length * grid.length;
            int head = ThreadLocalRandom.current().nextInt(40, size -1);
            int tail = ThreadLocalRandom.current().nextInt(Math.max(1, head - 40), head -10);
            if(usedJumpStarts.contains(head) || usedJumpStarts.contains(tail)) {
                continue;
            }

            Jump jump = new Jump(head, tail);
            Cell currentCell = getCell(head);
            currentCell.addJump(jump);
            usedJumpStarts.add(head);

            System.out.println("Snake added, start: " + head + " end: " + tail);

            snakes--;
        }

        while(ladders > 0) {
            int size = grid.length * grid.length;
            int start = ThreadLocalRandom.current().nextInt(2, 60);
            int end = ThreadLocalRandom.current().nextInt(start + 10, Math.min(size - 1, start + 40));
            if(usedJumpStarts.contains(start) || usedJumpStarts.contains(end)) {
                continue;
            }

            Jump jump = new Jump(start, end);
            Cell currentCell = getCell(start);
            currentCell.addJump(jump);
            usedJumpStarts.add(start);

            System.out.println("Ladder added, start: " + start + " end: " + end);
            ladders--;
        }
    }

    public Cell getCell(int pos) {
        int row = pos / grid.length;
        int col = pos % grid.length;
        return grid[row][col];
    }

}