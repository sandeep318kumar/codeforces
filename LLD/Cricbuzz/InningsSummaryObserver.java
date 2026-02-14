class InningsSummaryObserver implements MatchObserver {
    @Override 
    public boolean supports(MatchEventType type) {
        return type.equals(MatchEventType.INNINGS_ENDED);
    }

    @Override
    public void update(MatchEvent event) {
        Innings innings = event.innings;
        System.out.println("\n==============================");
        System.out.println("🏏 INNINGS SUMMARY");
        System.out.println("Team: " + innings.battingTeam.name);
        System.out.println("Score: " + innings.scorecard.totalRuns + "/" + innings.scorecard.wickets.size());
        System.out.println("Overs: " + innings.scorecard.overs + "." + innings.scorecard.balls);
        System.out.println("Run Rate: " + String.format("%.2f", innings.scorecard.runrate()));

        System.out.println("\nBatting:");
        for(Player p : innings.battingTeam.players) {
            if(p.batting.totalBalls > 0) {
                System.out.println(
                    p.name + " " +
                    p.batting.totalRuns + " (" + p.batting.totalBalls + ") " +
                    "SR: " + String.format("%.2f", p.batting.strikeRate())
                );
            }
        }


        System.out.println("\nBowling:");
        for(Player p : innings.bowlingTeam.players) {
            if(p.bowling.balls > 0) {
                System.out.println(
                    p.name + " " +
                    p.bowling.overs() + " overs, " +
                    p.bowling.runsConceded + " runs, " +
                    p.bowling.wickets + " wickets, " +
                    "Econ: " + String.format("%.2f", p.bowling.economy())
                );
            }
        }
        System.out.println("==============================\n");
    }
}