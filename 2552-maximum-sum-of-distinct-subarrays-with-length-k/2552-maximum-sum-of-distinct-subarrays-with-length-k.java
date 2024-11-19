class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0;
        long sum = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(r<n) {
            sum += nums[r];
            int prevIndex = map.getOrDefault(nums[r], -1);
            while(r-l+1 > k || l<=prevIndex) {
                sum -= nums[l];
                l++;
            }
            if(r-l+1 == k) max = Math.max(sum, max);
            map.put(nums[r], r);
            r++;
        }
        return max;
    }
}