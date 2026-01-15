class Player {
    String name;
    BatsmanStats batting = new BatsmanStats();
    BowlerStats bowling = new BowlerStats();
    
    Player(String name) {
        this.name = name;
    }
}