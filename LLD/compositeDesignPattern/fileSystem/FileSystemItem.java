interface FileSystemItem {
    void showDetails(int level);

    String getName();

    int getSize();

    boolean delete(String name);

    FileSystemItem search(String name);
}