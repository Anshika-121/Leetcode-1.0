class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer , Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
         HashSet<Integer> uniqueCounts = new HashSet<>();
        for (int count : freqMap.values()) {
            if (!uniqueCounts.add(count)) {
                // If the count is already in the set, it's not unique
                return false;
            }
        }
        return true;
    }
}