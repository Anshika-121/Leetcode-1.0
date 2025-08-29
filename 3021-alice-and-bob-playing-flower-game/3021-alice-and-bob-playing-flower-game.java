class Solution {
    public long flowerGame(int n, int m) {
        // Count of odd and even numbers in [1, n]
        long oddX = (n + 1) / 2;
        long evenX = n - oddX;

        // Count of odd and even numbers in [1, m]
        long oddY = (m + 1) / 2;
        long evenY = m - oddY;

        // Total pairs with odd sum → Alice wins
        return oddX * evenY + evenX * oddY;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 3, m = 2;
        System.out.println(sol.flowerGame(n, m)); // Output: 3
    }
}
