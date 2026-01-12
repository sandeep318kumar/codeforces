class Runner {
    public static void main(String[] args) {
        FileSystemItem f1 = new File("file1");
        FileSystemItem f2 = new File("file2");
        FileSystemItem f3 = new File("file3");

        Directory docs = new Directory("Documents");
        docs.addItem(f1);
        docs.addItem(f2);

        Directory root = new Directory("root");
        root.addItem(docs);
        root.addItem(f3);

        root.showDetails();
    }
}