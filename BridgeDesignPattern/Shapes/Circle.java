class Circle extends Shape {
    Circle(Color color ) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing circle - ");
        color.applyColor();
    }
}