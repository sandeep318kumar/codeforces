class Seat {
    public String seatId;
    public SeatType type;
    public double price;

    Seat(String seatId, SeatType type, double price) {
        this.seatId = seatId;
        this.type = type;
        this.price = price;
        System.out.println("[Seat] Created seat: " + seatId + ", type: " + type);
    }
}