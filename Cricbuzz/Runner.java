import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Runner {
    public static void main(String[] args) {
        Team india = new Team("India", List.of(new Player("Virat"), new Player("Rohit"), new Player("Sachin")));
        Team aus = new Team("Australia", List.of(new Player("Warner"), new Player("Smith"), new Player("Starc")));

        Match match = new Match(aus, india);
        match.addObserver(new CommentaryObserver());
        match.addObserver(new LiveScoreObserver());
        match.addObserver(new StatsObserver());
        match.addObserver(new ResultObserver());
        match.addObserver(new InningsSummaryObserver());

        // ================== INNINGS 1 ==================
                // playOver(match, match.teamA.players.get(0), match.teamB.players.get(0),
        //         new int[]{1, 4, 0, 2, 6, -1});

        // playOver(match, match.teamA.players.get(1), match.teamB.players.get(1),
        //         new int[]{0, 1, 1, 4, 0, 2});

        match.startMatch();
        play5OverMatch(match);

        match.startNextInnings();
        play5OverMatch(match);

        match.endMatch();
    }
    private static void play5OverMatch(Match match) {
        for(int i = 0;i<5;i++) {
                playRandomOver(match);
        }
    }
    private static void playOver(Match match, Player batsman, Player bowler, int[] outcomes) {
        for(int r: outcomes) {
                if(r == -1) {
                        match.bowl(new Delivery(new Ball.Builder().wicket(WicketType.BOWLED).build(), batsman, bowler));
                } else {
                        match.bowl(new Delivery(new Ball.Builder().runs(r).build(), batsman, bowler));
                }
        }
    }

    private static void playRandomOver(Match match) {
        int legalBalls = 0;

        while (legalBalls < 6 && match.isInningsLive()) {
                InningsState state = match.innings.get(match.innings.size() - 1).state;
                Player batsman = state.striker;
                Player bowler = state.bowler;
                int outcome = ThreadLocalRandom.current().nextInt(100);

                if (outcome < 25) {
                        // dot ball
                        match.bowl(new Delivery(new Ball.Builder().runs(0).build(), batsman, bowler));
                        legalBalls++;
                } else if (outcome < 55) {
                        // 1 run
                        match.bowl(new Delivery(new Ball.Builder().runs(1).build(), batsman, bowler));
                        legalBalls++;

                } else if (outcome < 70) {
                        // 2 runs
                        match.bowl(new Delivery(new Ball.Builder().runs(2).build(), batsman, bowler));
                        legalBalls++;

                } else if (outcome < 85) {
                        // 4 runs
                        match.bowl(new Delivery(new Ball.Builder().runs(4).build(), batsman, bowler));
                        legalBalls++;

                } else if (outcome < 90) {
                        // 6 runs
                        match.bowl(new Delivery(new Ball.Builder().runs(6).build(), batsman, bowler));
                        legalBalls++;

                } else if (outcome < 95) {
                        // wicket
                        match.bowl(new Delivery(
                                new Ball.Builder().wicket(WicketType.BOWLED).build(),
                                batsman,
                                bowler
                        ));
                        legalBalls++;

                } else {
                        // wide ball (extra run, ball NOT counted)
                        match.bowl(new Delivery(new Ball.Builder().wide().build(), batsman, bowler));
                }
        }
    }
}