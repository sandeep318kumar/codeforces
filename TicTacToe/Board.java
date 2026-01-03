class Board {
    public final int size;
    public PlayingPiece[][] grid;

    Board(int size) {
        this.size = size;
        this.grid = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayingPiece piece) {
        if(row >= size || col >= size || row < 0 || col < 0 || grid[row][col] != null )
            return false;
        grid[row][col] = piece;
        return true;
    }

    public boolean getFreeCells() {
        for(PlayingPiece[] i: grid) {
            for(PlayingPiece j: i) {
                if(j == null)
                    return true;
            }
        }
        return false;
    }

    public void printGrid() {
        for(PlayingPiece[] i: grid) {
            for(PlayingPiece j: i) {
                System.out.print("|" + (j != null ? j.type : " "));
            }
            System.out.println("|");
        }
    }
}