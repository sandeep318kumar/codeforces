class FixedWindowCounter {
    private final int limit;
    private final long windowSizeInMillis;
    private long windowStart;
    private int count;
    public FixedWindowCounter(int limit, long windowSizeInMillis) {
        this.limit = limit;
        this.windowSizeInMillis = windowSizeInMillis;
        windowStart = System.currentTimeMillis();
        count = 0;
    }

    public boolean allowRequest() {
        long now = System.currentTimeMillis();
        long elapsed = now - windowStart;
        
        if(elapsed >= windowSizeInMillis) {
            count = 0;
            windowStart = now;
        }

        if(count < limit) {
            count++;
            return true;
        }
        return false;
    }
}