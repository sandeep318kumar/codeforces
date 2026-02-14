class SingleRoom implements HotelElement {
    int roomNumber;
    boolean isOccupied = false;

    public void accept(HotelVisitor visitor) {
        visitor.visit(this);
    }
}