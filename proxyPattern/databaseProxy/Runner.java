class Runner {
    public static void main(String[] args) {
        Database userDb = new DatabaseProxy("USER");
        userDb.read();
        userDb.write();

        Database mainDb = new DatabaseProxy("ADMIN");
        mainDb.read();
        mainDb.write();
    }
}