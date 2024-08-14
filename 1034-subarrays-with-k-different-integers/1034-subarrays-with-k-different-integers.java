class Solution {
    public int findAtmostK(int[] nums, int k) {
        int n = nums.length, l=0, r=0, ans=0;
        Map<Integer, Integer> freq = new HashMap<>();
        while(r<n) {
            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);
            while(freq.size() > k) {
                int val = freq.get(nums[l]);
                if(val == 1) {
                    freq.remove(nums[l]);
                } else {
                    freq.put(nums[l], val - 1);
                }
                l++;
            }
            ans += r-l+1;
            r++;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return findAtmostK(nums, k) - findAtmostK(nums, k-1);
    }
}