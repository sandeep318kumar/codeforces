class BowlerStats {
    int runsConceded = 0;
    int wickets = 0;
    int balls = 0;

    void onBall(Ball ball) {
        if(ball.type == BallType.NORMAL) {
            balls++;
            runsConceded += ball.runs;
        }

        if(ball.isWicket) wickets++;
        if(ball.type == BallType.WIDE) runsConceded++; 
    }

    double overs() {
        System.out.println("current balls: " + balls);
        return balls / 6 + ((balls % 6.0)/10);
    }

    double economy() {
        return balls == 0 ? 0 : (runsConceded * 6.0)/balls;
    }
}