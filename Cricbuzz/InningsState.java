class InningsState {
    Player striker;
    Player nonStriker;
    Player bowler;
    int nextBatsmanIndex = 2;
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
        if(nextBatsmanIndex < battingTeam.players.size()) {
            striker = battingTeam.players.get(nextBatsmanIndex++);
        }
    }
}