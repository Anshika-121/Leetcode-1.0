import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Step 1: Priority Queue (Max Heap based on gain)
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0])  // sort by gain, descending
        );

        // Step 2: Insert all classes with initial gain
        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            double gain = calculateGain(pass, total);
            pq.offer(new double[]{gain, pass, total});
        }

        // Step 3: Assign extraStudents
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int pass = (int) top[1];
            int total = (int) top[2];

            // Assign one student
            pass++;
            total++;

            double newGain = calculateGain(pass, total);
            pq.offer(new double[]{newGain, pass, total});
        }

        // Step 4: Compute average
        double sum = 0.0;
        for (double[] entry : pq) {
            sum += entry[1] / entry[2];
        }

        return sum / classes.length;
    }

    private double calculateGain(int p, int t) {
        return ((double)(p + 1) / (t + 1)) - ((double) p / t);
    }
}
