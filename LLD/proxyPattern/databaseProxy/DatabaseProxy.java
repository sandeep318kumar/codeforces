class DatabaseProxy implements Database {
    private RealDatabase real = new RealDatabase();
    private String role;

    public DatabaseProxy(String role) {
        this.role = role;
    }

    public void read() {
        real.read();
    }

    public void write() {
        if("ADMIN".equals(role)) {
            real.write();
        } else {
            System.out.println("Access Denied");
        }
    }
}