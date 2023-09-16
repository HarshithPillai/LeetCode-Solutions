class Solution {
    int[][] dp;
    public int helper(int[] nums, int target, int ind) {
        if(ind==-1) {
            if(target==0) return 1;
            return 0;
        }
        //if(target<0) return 0;
        if(dp[ind][target+2000]!=-1) return dp[ind][target+2000];
        int add = helper(nums, target-nums[ind], ind-1);
        int sub = helper(nums, target+nums[ind], ind-1);
        dp[ind][target+2000] = add+sub;
        return add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        dp = new int[n+1][4001];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(nums, target, nums.length-1);
    }
}