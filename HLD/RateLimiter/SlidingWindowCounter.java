class SlidingWindowCounter {
    private final int limit;
    private final long windowSizeInMillis;

    private int currentWindowCount;
    private int previousWindowCount;
    private long currentWindowStart;

    public SlidingWindowCounter(int limit, long windowSizeInMillis) {
        this.limit = limit;
        this.windowSizeInMillis = windowSizeInMillis;
        currentWindowStart = System.currentTimeMillis();
    }

    public boolean allowRequest() {
        long now = System.currentTimeMillis();
        long elapsedTime = now - currentWindowStart;
        if(elapsedTime >= windowSizeInMillis) {
            previousWindowCount = currentWindowCount;
            currentWindowCount = 0;
            currentWindowStart = now;
        }
        // time in last window.
        double overlapRatio = (double) (windowSizeInMillis - elapsedTime) / windowSizeInMillis;
        double effectiveCount = overlapRatio * previousWindowCount + currentWindowCount;

        if(effectiveCount < limit) {
            currentWindowCount++;
            return true;
        }
        return false;
    }

}