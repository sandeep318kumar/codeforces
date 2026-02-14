class Tesla implements Clock {
    public void showTime() {
        System.out.println("Current time is this");
    }
    public static void main(String[] args) {
        Car carObj = new Car(10, "bmw");
        carObj.display();
        carObj.running();
        carObj.accelerate();
        carObj.running();
        // Tesla nT = new Tesla();
        // nT.showTime();
        // showTime();
    }
}