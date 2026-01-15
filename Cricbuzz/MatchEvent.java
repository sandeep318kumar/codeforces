class MatchEvent {
    MatchEventType type;
    String message;
    Score scorecard;
    MatchResult result;
    Innings innings;

    MatchEvent(Builder b) {
        this.type = b.type;
        this.message = b.message;
        this.scorecard = b.scorecard;
        this.result = b.result;
        this.innings = b.innings;
    }

    static class Builder {
        MatchEventType type;
        String message = "";
        Score scorecard = null;
        MatchResult result = null;
        Innings innings = null;

        Builder result(MatchResult result) {
            this.result = result;
            return this;
        }
        Builder innings(Innings innings) {
            this.innings = innings;
            return this;
        }
        Builder type(MatchEventType type) {
            this.type = type;
            return this;
        }
        Builder message(String message) {
            this.message = message;
            return this;
        }
        Builder score(Score scorecard) {
            this.scorecard = scorecard;
            return this;
        }
        MatchEvent build() {
            if(type == null) {
                throw new IllegalStateException("MatchEventType is mandatory");
            }

            switch(type) {
                case MATCH_ENDED:
                    if(result == null) {
                        throw new IllegalStateException("MATCH_ENDED requires result");
                    }
                    break;
                case INNINGS_ENDED:
                    if(innings == null) {
                        throw new IllegalStateException("INNINGS_ENDED requires innings");
                    }
                    break;
                case BALL_BOWLED:
                case SCORE_UPDATE:
                case WICKET:
                    if(scorecard == null) {
                        throw new IllegalStateException("Scorecard required for score events");
                    }
                    break;
            }
            return new MatchEvent(this);
        }
    }
}