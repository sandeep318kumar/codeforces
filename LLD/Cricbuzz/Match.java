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

        notifyObservers(new MatchEvent.Builder().type(MatchEventType.MATCH_STARTED).message("Match Started " + teamA.name + " vs " + teamB.name).score(innings.get(0).scorecard).build());
        notifyObservers(new MatchEvent.Builder().type(MatchEventType.INNINGS_STARTED).message("First Innings started").score(innings.get(0).scorecard).build());

    }

    public void endMatch() {
        notifyObservers(new MatchEvent.Builder().type(MatchEventType.INNINGS_ENDED).innings(innings.get(1)).build());
        status = MatchStatus.COMPLETED;
        MatchResult result = calculateResult();
        notifyObservers(new MatchEvent.Builder().type(MatchEventType.MATCH_ENDED).result(result).build());
    }

    void bowl(Delivery delivery) {
        Innings current = innings.get(innings.size() -1);
        Ball ball = delivery.ball;
        InningsStatus status = current.bowlBall(delivery);

        String prefix = delivery.bowling.name + " to " + delivery.batting.name + ": ";

        if(ball.isWicket) {
            notifyObservers(new MatchEvent.Builder().type(MatchEventType.WICKET).message(prefix + "Wicket: " + ball.wicket).score(current.scorecard).build());
        } else if (ball.type == BallType.WIDE) {
            notifyObservers(new MatchEvent.Builder().type(MatchEventType.SCORE_UPDATE).message(prefix + "WIDE ball").score(current.scorecard).build());
        } else {
            notifyObservers(new MatchEvent.Builder().type(MatchEventType.BALL_BOWLED).message(prefix + "Ball: " + ball.runs + " runs").score(current.scorecard).build());
        }
        
        if(status.equals(InningsStatus.ALL_OUT)) {
            startNextInnings();
            return;
        }

        if(status.equals(InningsStatus.OVER_COMPLETED)) {
            notifyObservers(new MatchEvent.Builder().type(MatchEventType.OVER_COMPLETED).message( "Over completed").score( current.scorecard).build());
        }
    }

    void startNextInnings() {
        if(innings.size() == 1) {
            notifyObservers(new MatchEvent.Builder().type(MatchEventType.INNINGS_ENDED).innings(innings.get(0)).build());
            innings.add(new Innings(teamB, teamA));
            innings.get(1).target = innings.get(0).scorecard.totalRuns;
            notifyObservers(new MatchEvent.Builder().type(MatchEventType.MATCH_STARTED).message( "Second Innings started").score( innings.get(1).scorecard).build());
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