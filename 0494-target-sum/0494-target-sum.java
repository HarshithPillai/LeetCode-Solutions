class Solution {
    public int helper(int[] nums, int target, int ind, int[][] dp) {
        if(ind==-1) {
            if(target==0) return 1;
            return 0;
        }
        //if(target<0) return 0;
        if(dp[ind][target+2000]!=-1) return dp[ind][target+2000];
        int add = helper(nums, target-nums[ind], ind-1, dp);
        int sub = helper(nums, target+nums[ind], ind-1, dp);
        dp[ind][target+2000] = add+sub;
        return add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum=0;
        for(int i:nums)sum+=i;
        int[][] dp = new int[n+1][5000];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(nums, target, nums.length-1,dp);
    }
}