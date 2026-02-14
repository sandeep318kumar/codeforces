class Runner {
    public static void main(String[] args) throws InterruptedException {
        TokenBucket tokenBucket = new TokenBucket(3, 1);
        LeakingBucket leakingBucket = new LeakingBucket(3, 1);
        FixedWindowCounter fixedWindowCounter = new FixedWindowCounter(3, 2000);
        SlidingWindowLog slidingWindowLog = new SlidingWindowLog(3, 5000);
        SlidingWindowCounter slidingWindowCounter = new SlidingWindowCounter(3, 5000);
        for(int i = 1;i<=10;i++) {
            // boolean allowed = tokenBucket.allowRequest();
            // boolean allowed = leakingBucket.allowRequest();
            boolean allowed = fixedWindowCounter.allowRequest();
            // boolean allowed = slidingWindowLog.allowRequest("sandeep");
            // boolean allowed = slidingWindowCounter.allowRequest();

            System.out.println("Request: " + i + " allowed? " + allowed);
            Thread.sleep(300);
        }

    }
}