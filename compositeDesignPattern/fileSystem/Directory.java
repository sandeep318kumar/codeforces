import java.util.List;
import java.util.ArrayList;

class Directory implements FileSystemItem {
    public String name;
    public List<FileSystemItem> items = new ArrayList<>();

    Directory(String name) {
        this.name = name;
    }

    public void addItem(FileSystemItem item) {
        items.add(item);
    }

    public void removeItem(FileSystemItem item) {
        items.remove(item);
    }

    @Override
    public void showDetails() {
        System.out.println("Directory: " + name);
        for(FileSystemItem item: items) {
            item.showDetails();
        }
    }
}