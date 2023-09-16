class Solution {
    public int helper(int[] nums, int target, int ind) {
        if(ind==-1) {
            if(target==0) return 1;
            return 0;
        }
        int add = helper(nums, target-nums[ind], ind-1);
        int sub = helper(nums, target+nums[ind], ind-1);
        return add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, nums.length-1);
    }
}