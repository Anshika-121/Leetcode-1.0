class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // start with the last row
        int[] dp = new int[n];
        
        // copy last row into dp
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        
        // bottom-up calculation
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = Math.min(dp[col], dp[col + 1]) + triangle.get(row).get(col);
            }
        }
        
        // dp[0] will have the answer (min path sum from top to bottom)
        return dp[0];
    }
}
