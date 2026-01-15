import java.util.List;
import java.util.ArrayList;
class Match {
    public Team teamA;
    public Team teamB;
    public List<Innings> innings;
    public MatchStatus status;

    List<MatchObserver> observers = new ArrayList<>();


    Match(Team teamA, Team teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
        status = MatchStatus.NOT_STARTED;
        innings = new ArrayList<>();
    }

    void addObserver(MatchObserver observer) {
        observers.add(observer);
    }

    void removeObserver(MatchObserver observer) {
        observers.remove(observer);
    }

    void notifyObservers(MatchEvent event) {
        for(MatchObserver observer: observers) {
            if(observer.supports(event.type))
            observer.update(event);
        }
    }

    public void startMatch() {
        status = MatchStatus.LIVE;
        innings.add(new Innings(teamA, teamB));

        notifyObservers(new MatchEvent(MatchEventType.MATCH_STARTED, "Match Started " + teamA.name + " vs " + teamB.name, innings.get(0).scorecard));
        notifyObservers(new MatchEvent(MatchEventType.INNINGS_STARTED, "First Innings started", innings.get(0).scorecard));

    }

    public void endMatch() {
        notifyObservers(new MatchEvent(innings.get(1)));
        status = MatchStatus.COMPLETED;
        MatchResult result = calculateResult();
        notifyObservers(new MatchEvent(result));
    }

    void bowl(Delivery delivery) {
        Innings current = innings.get(innings.size() -1);
        Ball ball = delivery.ball;
        InningsStatus status = current.bowlBall(delivery);

        String prefix = delivery.bowling.name + " to " + delivery.batting.name + ": ";

        if(ball.isWicket) {
            notifyObservers(new MatchEvent(MatchEventType.WICKET, prefix + "Wicket: " + ball.wicket, current.scorecard));
        } else if (ball.type == BallType.WIDE) {
            notifyObservers(new MatchEvent(MatchEventType.SCORE_UPDATE, prefix + "WIDE ball", current.scorecard));
        } else {
            notifyObservers(new MatchEvent(MatchEventType.BALL_BOWLED, prefix + "Ball: " + ball.runs + " runs", current.scorecard));
        }
        
        if(status.equals(InningsStatus.ALL_OUT)) {
            startNextInnings();
            return;
        }

        if(status.equals(InningsStatus.OVER_COMPLETED)) {
            notifyObservers(new MatchEvent(MatchEventType.OVER_COMPLETED, "Over completed", current.scorecard));
        }
    }

    void startNextInnings() {
        if(innings.size() == 1) {
            notifyObservers(new MatchEvent(innings.get(0)));
            innings.add(new Innings(teamB, teamA));
            notifyObservers(new MatchEvent(MatchEventType.MATCH_STARTED, "Second Innings started", innings.get(1).scorecard));
        }
    }

    boolean isInningsLive() {
        return status == MatchStatus.LIVE &&
            innings.get(innings.size() - 1).isInProgress();
    }

    MatchResult calculateResult() {
        if(innings.size() < 2) {
            return null;
        }

        Innings first = innings.get(0);
        Innings second = innings.get(1);
        int score1 = first.scorecard.totalRuns;
        int score2 = second.scorecard.totalRuns;

        if(score1 > score2) {
            return new MatchResult(first.battingTeam, first.bowlingTeam, " won by " + (score1 - score2)  + " runs");
        } else if(score1 == score2) {
            return new MatchResult(null, null, "Match Tied");
        } else {
            int wicketsRemaining = second.battingTeam.players.size() - second.scorecard.wickets.size() - 1;
            String message = "won by " + wicketsRemaining +  " wickets";

            if(wicketsRemaining == 0) {
                message = "won by last wicket";
            }
            return new MatchResult(second.battingTeam, second.bowlingTeam, message);
        }
    }
}