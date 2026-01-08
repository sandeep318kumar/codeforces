import java.util.List;
import java.util.ArrayList;

class Theatre {
    public String id;
    public String name;
    public String address;
    List<Screen> screens;

    Theatre(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.screens = new ArrayList<>();
        System.out.println("[Theatre] Created theatre: " + name);
    }

    public void AddScreen(Screen screen) {
        screens.add(screen);
        System.out.println("[Theatre] Screen added: " + screen.id + " to theatre: " + name);
    }
}