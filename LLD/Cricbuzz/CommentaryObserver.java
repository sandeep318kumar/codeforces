class CommentaryObserver implements MatchObserver {
    @Override 
    public boolean supports (MatchEventType type ) {
        return (type != MatchEventType.MATCH_ENDED && type != MatchEventType.INNINGS_ENDED);
    }
    @Override
    public void update(MatchEvent event) {
        System.out.println("[Commentary] " + event.message);
    }

}