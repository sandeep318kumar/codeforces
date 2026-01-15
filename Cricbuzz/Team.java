import java.util.List;

class Team {
    String name;
    List<Player> players;
    Team(String name, List<Player> players) {
        this.players = players;
        this.name = name;
    }
}