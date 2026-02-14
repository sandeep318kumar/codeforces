class Runner {
    public static void main(String[] args) {
        FileSystemItem file1 = new File("file1", 10);
        FileSystemItem file2 = new File("file2", 20);
        FileSystemItem file3 = new File("file3", 30);
        FileSystemItem movie = new File("movie.mp4", 700);

        Directory documents = new Directory("Documents");
        documents.addItem(file1);
        documents.addItem(file2);

        Directory downloads = new Directory("Downloads");
        downloads.addItem(movie);

        Directory root = new Directory("root");
        root.addItem(documents);
        root.addItem(downloads);
        root.addItem(file3);

        System.out.println("\n===== INITIAL STRUCTURE =====");
        root.showDetails(0);
        System.out.println("Total size: " + root.getSize() + " KB");

        // 🔹 SCENARIO 1: Delete a file inside subdirectory
        System.out.println("\n===== DELETE file2 =====");
        root.delete("file2");
        root.showDetails(0);

        // 🔹 SCENARIO 2: Delete a directory
        System.out.println("\n===== DELETE Documents =====");
        root.delete("Documents");
        root.showDetails(0);

        // 🔹 SCENARIO 3: Delete deeply nested file
        System.out.println("\n===== DELETE movie.mp4 =====");
        root.delete("movie.mp4");
        root.showDetails(0);

        // 🔹 SCENARIO 4: Delete non-existing item
        System.out.println("\n===== DELETE unknown.txt =====");
        root.delete("unknown.txt");
        root.showDetails(0);
    }
}