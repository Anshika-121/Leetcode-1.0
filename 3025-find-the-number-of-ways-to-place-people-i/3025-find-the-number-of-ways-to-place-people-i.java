class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int ax = points[i][0], ay = points[i][1];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int bx = points[j][0], by = points[j][1];

                // Define "upper-left": A.x <= B.x and A.y >= B.y
                if (ax <= bx && ay >= by) {
                    // ignore identical coordinates (same point position)
                    if (ax == bx && ay == by) continue;

                    int minX = Math.min(ax, bx);
                    int maxX = Math.max(ax, bx);
                    int minY = Math.min(ay, by);
                    int maxY = Math.max(ay, by);

                    boolean blocked = false;
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue; // ignore A and B themselves
                        int cx = points[k][0], cy = points[k][1];
                        // if C lies inside or on the border of rectangle -> block
                        if (cx >= minX && cx <= maxX && cy >= minY && cy <= maxY) {
                            blocked = true;
                            break;
                        }
                    }

                    if (!blocked) count++;
                }
            }
        }
        return count;
    }
}
