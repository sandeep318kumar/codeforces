class DeluxRoom implements HotelElement {
    int roomNumber;
    boolean isOccupied = false;
    boolean spaAccess = true;

    public void accept(HotelVisitor visitor) {
        visitor.visit(this);
    }
}