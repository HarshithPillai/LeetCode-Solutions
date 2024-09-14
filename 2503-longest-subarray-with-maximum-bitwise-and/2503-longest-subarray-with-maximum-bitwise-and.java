class Solution {
    public int longestSubarray(int[] nums) {
        int maxLen=0, n=nums.length, currMax = -1, len = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] == currMax) len++;
            else if(nums[i] < currMax) len = 0;
            else {
                len = 1;
                currMax = nums[i];
                maxLen = 0;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}