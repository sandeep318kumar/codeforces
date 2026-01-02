class CaramelDecorator extends CoffeeDecorator {

    public CaramelDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + " Caramel";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 3.0;
    }
}