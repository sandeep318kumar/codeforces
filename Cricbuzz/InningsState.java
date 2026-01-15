class InningsState {
    Player striker;
    Player nonStriker;
    Player bowler;
    int lastBatsmanIndex = 1;
    Team battingTeam;
    

    InningsState(Player striker, Player nonStriker, Player bowler, Team batting) {
        this.striker = striker;
        this.nonStriker = nonStriker;
        this.bowler = bowler;
        battingTeam = batting;
    }

    void rotateStrike() {
        Player temp = striker;
        striker = nonStriker;
        nonStriker = temp;
    }
    void onWicket() {
        lastBatsmanIndex++;
        if(lastBatsmanIndex < battingTeam.players.size()) {
            striker = battingTeam.players.get(lastBatsmanIndex);
        }
    }

    boolean isAllOut() {
        return lastBatsmanIndex >= battingTeam.players.size();
    }
}