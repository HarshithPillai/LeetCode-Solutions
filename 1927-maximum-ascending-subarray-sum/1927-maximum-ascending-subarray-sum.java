class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0], curr = max;
        for(int i=1; i<nums.length; i++) {
            if(nums[i-1] >= nums[i]) {
                curr = nums[i];
            } else {
                curr += nums[i];
            }
            max = Math.max(curr, max);
        }
        return max;
    }
}