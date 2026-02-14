class ParkingAvailabilityDisplay implements ParkingObserver {
    private String displayId;

    ParkingAvailabilityDisplay(String id) {
        this.displayId = id;
    }

    @Override
    public void onSpotFreed(ParkingSpot spot) {
        System.out.println("Display [" + displayId + "] -> Spot Freed: " + spot.getId());
    }
}