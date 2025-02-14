class Solution {
    public long countBadPairs(int[] nums) {
        Map<Long, Long> freq = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            long diff = nums[i] - i;
            freq.put(diff, freq.getOrDefault(diff, 0l) + 1);
        }
        long goodPairs = 0l, n = nums.length;
        for(long val:freq.values()) {
            goodPairs += val*(val-1);
        }
        return ((n*(n-1)) - goodPairs)/2;
    }
}