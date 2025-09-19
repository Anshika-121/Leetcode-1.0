
import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowMap = new HashMap<>();
        
        // Store rows as strings in HashMap
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]).append(",");
            }
            String rowKey = sb.toString();
            rowMap.put(rowKey, rowMap.getOrDefault(rowKey, 0) + 1);
        }
        
        int ans = 0;
        
        // Check columns
        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(grid[i][j]).append(",");
            }
            String colKey = sb.toString();
            
            if (rowMap.containsKey(colKey)) {
                ans += rowMap.get(colKey);  // add how many rows match this column
            }
        }
        
        return ans;
    }
}
