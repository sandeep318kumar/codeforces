class User implements Subscriber {
    private String name;

    User(String name ){
        this.name = name;
    }

    @Override
    public void update(String context) {
        System.out.println("User " + name + " has received update " + context);
    }
}