import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

        // playOver(match, match.teamA.players.get(0), match.teamB.players.get(0),
        //         new int[]{1, 4, 0, 2, 6, -1});

        // playOver(match, match.teamA.players.get(1), match.teamB.players.get(1),
        //         new int[]{0, 1, 1, 4, 0, 2});

        playRandomOver(match, match.teamA.players.get(0), match.teamB.players.get(0));
        playRandomOver(match, match.teamA.players.get(1), match.teamB.players.get(1));

        match.startNextInnings();
        playRandomOver(match, match.teamB.players.get(0), match.teamA.players.get(0));
        playRandomOver(match, match.teamB.players.get(0), match.teamA.players.get(0));

        // ================== INNINGS 2 ==================
        // playOver(match, match.teamB.players.get(0), match.teamA.players.get(0),
        //         new int[]{4, 4, 1, 1, 6, -1});

        // playOver(match, match.teamB.players.get(1), match.teamA.players.get(1),
        //         new int[]{1, 1, 2, 1, 0, 4});

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

    private static void playRandomOver(Match match, Player batsman, Player bowler) {
        int legalBalls = 0;

        while (legalBalls < 6 && match.isInningsLive()) {
                int outcome = ThreadLocalRandom.current().nextInt(100);

                if (outcome < 25) {
                        // dot ball
                        match.bowl(new Delivery(new Ball(0, BallType.NORMAL), batsman, bowler));
                        legalBalls++;
                } else if (outcome < 55) {
                        // 1 run
                        match.bowl(new Delivery(new Ball(1, BallType.NORMAL), batsman, bowler));
                        legalBalls++;

                } else if (outcome < 70) {
                        // 2 runs
                        match.bowl(new Delivery(new Ball(2, BallType.NORMAL), batsman, bowler));
                        legalBalls++;

                } else if (outcome < 85) {
                        // 4 runs
                        match.bowl(new Delivery(new Ball(4, BallType.NORMAL), batsman, bowler));
                        legalBalls++;

                } else if (outcome < 90) {
                        // 6 runs
                        match.bowl(new Delivery(new Ball(6, BallType.NORMAL), batsman, bowler));
                        legalBalls++;

                } else if (outcome < 95) {
                        // wicket
                        match.bowl(new Delivery(
                                Ball.wicket(WicketType.BOWLED),
                                batsman,
                                bowler
                        ));
                        legalBalls++;

                } else {
                        // wide ball (extra run, ball NOT counted)
                        match.bowl(new Delivery(new Ball(1, BallType.WIDE), batsman, bowler));
                }
        }
   }
}