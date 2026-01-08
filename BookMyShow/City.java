import java.util.List;
import java.util.ArrayList;

class City {
    public String name;
    List<Theatre> theatres;

    public City(String name) {
        this.name = name;
        this.theatres = new ArrayList<>();
        System.out.println("[City] Created city: " + name);

    }

    public void addTheatre(Theatre th) {
        theatres.add(th);
        System.out.println("[City] Theatre added: " + th.name + " to city: " + name);
    }
}