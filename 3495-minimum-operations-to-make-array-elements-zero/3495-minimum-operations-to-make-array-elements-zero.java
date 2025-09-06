import java.util.*;

class Solution {
    public int minOperations(int[][] queries) {
        long totalOperations = 0;

        // Precompute buckets [low, high, steps]
        long limit = (long)1e9;
        List<long[]> ranges = new ArrayList<>();
        long start = 1;
        int step = 1;

        while (start <= limit) {
            long end = Math.min(limit, (1L << (2 * step)) - 1); // 4^step - 1
            ranges.add(new long[]{start, end, step});
            start = end + 1;
            step++;
        }

        // Answer queries
        for (int[] query : queries) {
            long l = query[0], r = query[1];
            long stepsSum = 0;

            for (long[] range : ranges) {
                long low = range[0], high = range[1], s = range[2];
                if (r < low || l > high) continue; // no overlap

                long overlap = Math.min(r, high) - Math.max(l, low) + 1;
                if (overlap > 0) {
                    stepsSum += overlap * s;
                }
            }

            totalOperations += (stepsSum + 1) / 2;
        }

        return (int) totalOperations;
    }
}
