import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class Directory implements FileSystemItem {
    private String name;
    private List<FileSystemItem> items = new ArrayList<>();

    Directory(String name) {
        this.name = name;
    }

    public void addItem(FileSystemItem item) {
        items.add(item);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        int total = 0;
        for(FileSystemItem item: items) {
            total += item.getSize();
        }
        return total;
    }

    @Override
    public FileSystemItem search(String name) {
        if(this.name.equals(name)) {
            return this;
        }

        for(FileSystemItem item : items) {
            FileSystemItem found = item.search(name);
            if(found != null) {
                return found;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String name) {
        if(this.name.equals(name)) {
            return true;
        }

        Iterator<FileSystemItem> iterator = items.iterator();
        while(iterator.hasNext()) {
            FileSystemItem item = iterator.next();
            
            // if current directory has the child to be deleted.
            if(item.getName().equals(name)) {
                iterator.remove();
                return true;
            }

            if(item.delete(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void showDetails(int level) {
        String indent = "   ".repeat(level);
        System.out.println(indent + "Directory: " + name);
        for(FileSystemItem item: items) {
            item.showDetails(level + 1);
        }
    }
}