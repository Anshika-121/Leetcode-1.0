import java.util.*;

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        TreeSet<Integer> used = new TreeSet<>();
        int count = 0;

        for (int num : nums) {
            // Try to assign the smallest available value in [num - k, num + k]
            int start = num - k;
            int end = num + k;

            // Find the first unused number ≥ start
            int candidate = start;
            while (candidate <= end && used.contains(candidate)) {
                candidate++;
            }

            if (candidate <= end) {
                used.add(candidate);
                count++;
            }
        }
        return count;
    }
}
