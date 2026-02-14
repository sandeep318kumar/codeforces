class TokenBucket {
    private final long capacity;
    private final long refillRatePerSecond ;
    private long tokens = 0;
    private long lastRefillTime;

    public TokenBucket(int capacity, int rate) {
        this.capacity = capacity;
        this.refillRatePerSecond = rate;
        this.tokens = capacity;
        this.lastRefillTime = System.nanoTime();
    }

    public synchronized boolean allowRequest() {
        refill();

        if(tokens >= 1) {
            tokens -= 1;
            return true;
        }
        return false;
    }

    private void refill() {
        // long now = System.nanoTime();
        // long seconds = (now - lastRefillTime) / 1000000000;
        // long tokensToAdd = seconds * refillRatePerSecond;
        // if(tokensToAdd >= 1) {
        //     tokens = Math.min(capacity, tokens + tokensToAdd);
        //     lastRefillTime = now;
        // }
        long now = System.nanoTime();
        long elapsedNanos = now - lastRefillTime;
        long nanosPerToken = 1_000_000_000L/refillRatePerSecond;
        long tokensToAdd = elapsedNanos / nanosPerToken;

        if(tokensToAdd > 0) {
            tokens = Math.min(capacity, tokens + tokensToAdd);
            lastRefillTime += tokensToAdd * nanosPerToken;
        }
    }

}