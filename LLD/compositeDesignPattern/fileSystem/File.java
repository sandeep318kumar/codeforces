class File implements FileSystemItem {
    private String name;
    private int size; // in KB

    File(String name, int size) {
        this.name = name;
        this.size = size;
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean delete(String name) {
        return this.name.equals(name);
    }
    
    @Override
    public FileSystemItem search(String name) {
        return this.name.equals(name) ? this : null;
    }

    @Override
    public void showDetails(int level) {
        String indent = "   ".repeat(level);
        System.out.println(indent + "File: " + name + " size: " + size);
    }
}