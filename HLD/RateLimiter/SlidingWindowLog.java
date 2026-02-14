import java.util.Map;
import java.util.HashMap;
import java.util.Deque;
import java.util.LinkedList;

class SlidingWindowLog {
    private final long limit;
    private final long windowSizeInMillis;

    private final Map<String, Deque<Long>> mp;
    public SlidingWindowLog(long limit, long windowSizeInMillis) {
        this.limit = limit;
        this.windowSizeInMillis = windowSizeInMillis;
        mp = new HashMap<>();
    }

    public boolean allowRequest(String user) {
        mp.putIfAbsent(user, new LinkedList<>());
        Deque<Long> timestamps = mp.get(user);
        Long now = System.currentTimeMillis();
        // remove the old timestamps of this window.
        while(!timestamps.isEmpty() && now - timestamps.peekFirst() > windowSizeInMillis) {
            timestamps.pollFirst();
        }

        timestamps.add(now);
        if(timestamps.size() <= limit) {
            return true;
        }
        return false;
    }
}