interface MatchObserver {
    boolean supports(MatchEventType type );
    void update(MatchEvent event);
}