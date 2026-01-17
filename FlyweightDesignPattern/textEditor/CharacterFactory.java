import java.util.Map;
import java.util.HashMap;
class CharacterFactory {
    private static final Map<String, CharacterFlyweight> cache = new HashMap<>();

    static CharacterFlyweight getCharacter(char symbol, int size, String font) {
        String key = symbol + "-" + size + "-" + font;
        if(!cache.containsKey(key)) {
            cache.put(key, new Character(symbol, size, font));
        }

        return cache.get(key);
    } 
}