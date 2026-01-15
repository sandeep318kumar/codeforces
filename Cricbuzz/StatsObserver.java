class StatsObserver implements MatchObserver {
    @Override 
    public boolean supports (MatchEventType type ) {
        return type.equals(MatchEventType.OVER_COMPLETED);
    }

    @Override
    public void update(MatchEvent event) {
        System.out.println("[Stats] current run rate: " + event.scorecard.runrate());
    }
}