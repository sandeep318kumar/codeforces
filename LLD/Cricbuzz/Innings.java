import java.util.List;
import java.util.ArrayList;
class Innings {
    public Team battingTeam;
    public Team bowlingTeam;
    public Score scorecard;
    List<Over> overs;
    InningsState state;
    InningsStatus status = InningsStatus.NOT_STARTED;
    int target = -1;

    Innings(Team batting, Team bowling) {
        this.battingTeam = batting;
        this.bowlingTeam = bowling;
        this.scorecard = new Score();
        this.overs = new ArrayList<>();
        overs.add(new Over());

        state = new InningsState(battingTeam.players.get(0), battingTeam.players.get(1), bowlingTeam.players.get(0), battingTeam);
        this.status = InningsStatus.IN_PROGRESS;
    }

    boolean isInProgress() {
        if(target != -1 && scorecard.totalRuns > target) {
            status = InningsStatus.COMPLETED;
        }
        return status != InningsStatus.COMPLETED;
    }

    public InningsStatus bowlBall(Delivery delivery) {
        if(status != InningsStatus.IN_PROGRESS) {
            return status;
        }
        Over currentOver = overs.get(overs.size() - 1);
        Ball ball = delivery.ball;
        currentOver.addBall(ball);
        scorecard.updateScore(ball);

        state.striker.batting.onBall(ball);
        state.bowler.bowling.onBall(ball);

        if(ball.runs % 2 == 1 && ball.type.equals(BallType.NORMAL)) {
            state.rotateStrike();
        }

        if(ball.isWicket) {
            state.onWicket();
            if(state.isAllOut()) {
                status = InningsStatus.COMPLETED;
                return InningsStatus.ALL_OUT;
            }
        }

        if(currentOver.isComplete()) {
            overs.add(new Over());
            scorecard.addOver();

            state.rotateStrike();
            int idx = bowlingTeam.players.indexOf(state.bowler);
            idx = (idx + 1) % bowlingTeam.players.size();
            state.bowler = bowlingTeam.players.get(idx);
            return InningsStatus.OVER_COMPLETED;
        }
        return InningsStatus.IN_PROGRESS;
    }
}