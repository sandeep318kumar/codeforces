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
        if(result.winner != null) {
            System.out.println(result.winner.name + " " + result.description);
        } else {
            System.out.println(result.description);
        }
        System.out.println("=================================");
    }
}