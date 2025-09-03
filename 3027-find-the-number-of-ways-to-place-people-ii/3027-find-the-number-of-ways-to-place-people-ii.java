class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int ans = 0;

        for (int i = 0; i < n; i++) { // Alice
            int xA = points[i][0];
            int yA = points[i][1];

            for (int j = 0; j < n; j++) { // Bob
                if (i == j) continue;
                int xB = points[j][0];
                int yB = points[j][1];

                // Alice must be upper-left, Bob must be lower-right
                if (xA <= xB && yA >= yB) {
                    boolean valid = true;

                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int x = points[k][0];
                        int y = points[k][1];

                        // If any other point lies inside/on the rectangle → invalid
                        if (xA <= x && x <= xB && yB <= y && y <= yA) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) ans++;
                }
            }
        }

        return ans;
    }
}
