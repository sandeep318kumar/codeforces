import java.util.concurrent.ThreadLocalRandom;

class Board {
    Cell[][] grid;

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
            int head = ThreadLocalRandom.current().nextInt(1, size -1);
            int tail = ThreadLocalRandom.current().nextInt(1, size -1);
            if(tail >= head) {
                continue;
            }

            Jump jump = new Jump(head, tail);
            Cell currentCell = getCell(head);
            currentCell.addJump(jump);

            System.out.println("Snake added start: " + head + " end: " + tail);

            snakes--;
        }

        while(ladders > 0) {
            int size = grid.length * grid.length;
            int start = ThreadLocalRandom.current().nextInt(1, size -1);
            int end = ThreadLocalRandom.current().nextInt(1, size -1);
            if(end <= start) {
                continue;
            }

            Jump jump = new Jump(start, end);
            Cell currentCell = getCell(start);
            currentCell.addJump(jump);
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