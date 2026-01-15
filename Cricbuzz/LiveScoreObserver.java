class LiveScoreObserver implements MatchObserver {
    @Override 
    public boolean supports (MatchEventType type ) {
        return type.equals(MatchEventType.WICKET) || type.equals(MatchEventType.BALL_BOWLED) || type.equals(MatchEventType.SCORE_UPDATE);
    }
    @Override
    public void update(MatchEvent event) {
        System.out.print("[Live score] ");
        event.scorecard.display();
    }

}