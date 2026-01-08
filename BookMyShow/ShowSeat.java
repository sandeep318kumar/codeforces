class ShowSeat {
    final public Seat seat;
    private SeatStatus status;

    ShowSeat(Seat seat) {
        this.seat = seat;
        this.status = SeatStatus.AVAILABLE;
        System.out.println("[ShowSeat] Initialized for seat: " + seat.seatId + " | Status: AVAILABLE");
    }

    synchronized public boolean lock() {
        if(status != SeatStatus.AVAILABLE) return false;
        status = SeatStatus.LOCKED;
        return true;
    }

    synchronized public void confirm() {
        status = SeatStatus.BOOKED;
    }

    synchronized public void release() {
        status = SeatStatus.AVAILABLE;
    }

    public SeatStatus getStatus() {
        return status;
    }
}