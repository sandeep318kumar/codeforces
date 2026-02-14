class MatchResult {
    Team loser;
    Team winner;
    String description;

    MatchResult(Team winner, Team loser, String description) {
        this.loser = loser;
        this.winner = winner;
        this.description = description;
    }
}