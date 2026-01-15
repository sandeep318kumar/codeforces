import java.util.List;
import java.util.ArrayList;
class Innings {
    public Team battingTeam;
    public Team bowlingTeam;
    public Score scorecard;
    List<Over> overs;
    InningsState state;

    Innings(Team batting, Team bowling) {
        this.battingTeam = batting;
        this.bowlingTeam = bowling;
        this.scorecard = new Score();
        this.overs = new ArrayList<>();
        overs.add(new Over());

        state = new InningsState(battingTeam.players.get(0), battingTeam.players.get(1), bowlingTeam.players.get(0), battingTeam);
    }

    public boolean bowlBall(Delivery delivery) {
        Over currentOver = overs.get(overs.size() - 1);
        Ball ball = delivery.ball;
        currentOver.addBall(ball);
        scorecard.updateScore(ball);

        state.striker.batting.onBall(ball);
        state.bowler.bowling.onBall(ball);

        if(ball.runs % 2 == 1) {
            state.rotateStrike();
        }

        if(ball.isWicket) {
            state.onWicket();
        }

        if(currentOver.isComplete()) {
            overs.add(new Over());
            scorecard.addOver();

            state.rotateStrike();
            int idx = bowlingTeam.players.indexOf(state.bowler);
            idx = (idx + 1) % bowlingTeam.players.size();
            state.bowler = bowlingTeam.players.get(idx);
            return true;
        }
        return false;
    }
}