import java.util.*;

class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);  // add the new request
        // remove outdated requests
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
