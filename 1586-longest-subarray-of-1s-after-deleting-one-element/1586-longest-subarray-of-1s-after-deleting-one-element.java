class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0, r = 0, max = 0, n = nums.length;
        int count = 0;
        while(r < n) {
            if(nums[r] == 0) count++;
            while(count>1) {
                if(nums[l] == 0) count--;
                l++;
            }
            max = Math.max(max, r-l+1 - 1);
            r++;
        }
        return max;
    }
}