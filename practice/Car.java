class Car {
    private int speed = 0;
    private String brand;
    private String color;

    Car(int s, String b, String c) {
        this.speed = s;
        this.brand = b;
        this.color = c;
    }

    Car(int s, String b) {
        // this.speed = s;
        // this.brand = b;
        // call the master constructor only.
        this(s, b, "purple");
    }

    Car(int s) {
        this(s, "mercedes");
    }

    public void display() {
        System.out.println("Your car details are " + brand + ", " + color);
    }

    public void accelerate() {
        speed += 10;
        System.out.println("now speed is " + speed);
    }

    public void running() {
        System.out.println(
            "car is running at " + speed
        );
    }
}