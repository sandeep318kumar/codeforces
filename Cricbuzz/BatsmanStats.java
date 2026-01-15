class BatsmanStats {
    int totalRuns = 0;
    int totalBalls = 0;

    void onBall(Ball ball) {
        if(ball.type.equals(BallType.NORMAL)) {
            totalBalls++;
            totalRuns += ball.runs;
        }
    }

    double strikeRate() {
        return totalBalls == 0 ? 0 : (totalRuns * 100.0) / totalBalls;
    }
}