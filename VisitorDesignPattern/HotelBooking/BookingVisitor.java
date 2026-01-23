class BookingVisitor implements HotelVisitor {
    @Override
    public void visit(SingleRoom room) {
        if(!room.isOccupied) {
            room.isOccupied = true;

            System.out.println("Booked single room " + room.roomNumber);
        }
    }

    @Override
    public void visit(DeluxRoom delux) {
        if(!delux.isOccupied) {
            delux.isOccupied = true;
            System.out.println("Booked Delux room: " + delux.roomNumber);
        }
    }
}