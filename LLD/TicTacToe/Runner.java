class Runner {
    public static void main(String[] args) {
        Tictactoe tic = new Tictactoe();
        tic.initializeGame(3);
        System.out.println(tic.startGame());
    }
}