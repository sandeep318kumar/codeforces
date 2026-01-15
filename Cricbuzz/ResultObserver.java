class ResultObserver implements MatchObserver {
    @Override 
    public boolean supports (MatchEventType type ) {
        return type.equals(MatchEventType.MATCH_ENDED);
    }
    
    @Override
    public void update(MatchEvent event) {
        MatchResult result = event.result;

        System.out.println("=================================");
        System.out.println("🏏 MATCH RESULT");
        System.out.println(result.winner.name + " " + result.description);
        System.out.println("=================================");
    }
}