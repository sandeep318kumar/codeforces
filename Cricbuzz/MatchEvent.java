class MatchEvent {
    MatchEventType type;
    String message;
    Score scorecard;
    MatchResult result;
    Innings innings;

    MatchEvent(MatchEventType type, String message, Score scorecard) {
        this.type = type;
        this.message = message;
        this.scorecard = scorecard;
    }

    MatchEvent(MatchResult result) {
        this.result = result;
        this.type = MatchEventType.MATCH_ENDED;
    }

    MatchEvent(Innings innings) {
        this.type = MatchEventType.INNINGS_ENDED;
        this.innings = innings;
    }
}