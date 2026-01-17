class Character implements CharacterFlyweight {
    private final char symbol;
    private final int size;
    private final String font;

    Character(char symbol, int size, String font) {
        this.symbol = symbol;
        this.size = size;
        this.font = font;
    }

    @Override
    public void display(int x, int y) {
        System.out.println(symbol + " " + size + " " + font + " is at: " + x+ ", " + y);
    }
}