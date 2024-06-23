class Solution {
    public int longestSubarray(int[] nums, int limit) {
        /**
            keep a frequency map in form of treemap
            keep track of first and last entries in the map
            while the entries's difference is more than limit,
            keep on reducing the window and once an entry's frequency reaches 0 remove it
        */
        TreeMap<Integer, Integer> freq = new TreeMap<>((a,b)->Integer.compare(a,b));
        int l=0, r=0, max=0, n=nums.length;
        while(r<n) {
            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);
            while(freq.lastEntry().getKey() - freq.firstEntry().getKey() > limit) {
                int fr = freq.get(nums[l]);
                if(fr == 1) freq.remove(nums[l]);
                else {
                    freq.put(nums[l], fr-1);
                }
                l++;
            }
            max = Math.max(r-l+1, max);
            r++;
        }
        return max;
    }
}