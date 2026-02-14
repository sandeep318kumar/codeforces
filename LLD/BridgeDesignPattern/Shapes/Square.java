class Square extends Shape {
    Square(Color color ) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing square - ");
        color.applyColor();
    }
}