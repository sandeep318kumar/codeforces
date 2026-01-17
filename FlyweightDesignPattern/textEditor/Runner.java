class Runner {
    public static void main(String[] args) {
        String text = "HELLO";

        for(char c: text.toCharArray()) {
            CharacterFlyweight ch = CharacterFactory.getCharacter(c, 12, "Arial");

            ch.display(12, 10);
        }
    }
}