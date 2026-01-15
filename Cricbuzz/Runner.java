import java.util.List;

class Runner {
    public static void main(String[] args) {
        Team india = new Team("India", List.of(new Player("Virat Kohli"), new Player("Rohit Sharma")));
        Team aus = new Team("Aus", List.of(new Player("Warner"), new Player("Smith")));

        Match match = new Match(india, aus);
        match.addObserver(new LiveScoreObserver());
        match.addObserver(new CommentaryObserver());
        match.addObserver(new StatsObserver());
        match.addObserver(new ResultObserver());
        match.addObserver(new InningsSummaryObserver());

        // ================== INNINGS 1 ==================
        match.startMatch();

        playOver(match, match.teamA.players.get(0), match.teamB.players.get(0),
                new int[]{1, 4, 0, 2, 6, -1}); // -1 = wicket

        playOver(match, match.teamA.players.get(1), match.teamB.players.get(1),
                new int[]{0, 1, 1, 4, 0, 2});

        match.startNextInnings();

        // ================== INNINGS 2 ==================
        playOver(match, match.teamB.players.get(0), match.teamA.players.get(0),
                new int[]{4, 4, 1, 1, 6, -1});

        playOver(match, match.teamB.players.get(1), match.teamA.players.get(1),
                new int[]{1, 1, 2, 1, 0, 4});

        match.endMatch();
    }
    private static void playOver(Match match, Player batsman, Player bowler, int[] outcomes) {
        for(int r: outcomes) {
                if(r == -1) {
                        match.bowl(new Delivery(Ball.wicket(WicketType.BOWLED), batsman, bowler));
                } else {
                        match.bowl(new Delivery(new Ball(r, BallType.NORMAL), batsman, bowler));
                }
        }
    }
}