import java.util.Queue;
import java.util.LinkedList;

class LeakingBucket {
    private final int capacity;
    private final int leakedRatePerSecond;
    private Queue<Long> q = new LinkedList<>();

    private long lastLeakTime;
    
    public LeakingBucket(int capacity, int leakedRatePerSecond) {
        this.capacity = capacity;
        this.leakedRatePerSecond = leakedRatePerSecond;
        lastLeakTime = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
        leak();
        if(q.size() < capacity) {
            q.add(0L);
            return true;
        }
        return false;
    }
    private void leak() {
        long now = System.currentTimeMillis();
        long seconds = (now - lastLeakTime) / 1000;

        long leaks = seconds * leakedRatePerSecond;
        for(int i = 0;i<leaks && !q.isEmpty();i++) {
            q.remove();
        }

        if(leaks > 0) {
            lastLeakTime = now;
        }
    }

}