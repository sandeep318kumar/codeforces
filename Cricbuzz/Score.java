import java.util.List;
import java.util.ArrayList;

class Score {
    public int totalRuns;
    public List<WicketType> wickets;
    public int overs;
    public int balls;
    public int totalBalls = 0;

    Score() {
        totalRuns = 0;
        wickets = new ArrayList<>();
        overs = 0;
        balls = 0;
    }

    public void updateScore(Ball ball) {
        totalRuns += ball.runs;
        if(ball.isWicket)
            wickets.add(ball.wicket);

        if(ball.type != BallType.WIDE && ball.type != BallType.NO_BALL) {
            totalBalls++;
            balls++;
        }
    }

    public void addOver() {
        overs++;
        balls = 0;
    }

    public void display() {
        System.out.println("Total Runs: " + totalRuns + " wickets: " + wickets.size());
    }

    public double runrate() {
        if(totalBalls == 0) return 0;

        return (totalRuns * 6.0)/totalBalls;
    }
}