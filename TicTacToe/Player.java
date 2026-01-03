class Player {
    private final String name;
    private final PlayingPiece piece;

    Player(String name, PlayingPiece p) {
        this.name = name;
        this.piece = p;
    }

    public String getName() { 
        return this.name;
    }

    public PieceType getPieceType() {
        return this.piece.type;
    }

    public PlayingPiece getPlayingPiece() {
        return this.piece;
    }
}