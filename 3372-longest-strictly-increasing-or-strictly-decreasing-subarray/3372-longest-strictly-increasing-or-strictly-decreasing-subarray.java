class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int len = 1, max = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                len++;
            } else {
                len = 1;
            }
            max = Math.max(len, max);
        }
        len = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                len++;
            } else {
                len = 1;
            }
            max = Math.max(len, max);
        }
        return max;
    }
}