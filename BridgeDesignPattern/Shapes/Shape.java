abstract class Shape {
    Color color;
    Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}