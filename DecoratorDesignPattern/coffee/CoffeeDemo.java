class CoffeeDemo {
    public static void main(String[] args) {
        Coffee simpleCof = new SimpleCoffee("Capuccino", 10.0);

        System.out.println(simpleCof.getDescription() + " $" + simpleCof.getCost());

        simpleCof = new MilkDecorator(simpleCof);
        System.out.println(simpleCof.getDescription() + " $" + simpleCof.getCost());

        simpleCof = new CaramelDecorator(simpleCof);
        System.out.println(simpleCof.getDescription() + " $" + simpleCof.getCost());
    }
}