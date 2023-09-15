class Solution {
    public boolean rec(int[] nums, int target, int ind, int[][] dp) {
        if(target<0) return false;
        if(target==0) return true;
        if(ind==nums.length) return false;
        if(dp[ind][target]!=-1) return dp[ind][target]==1;
        boolean take = rec(nums, target-nums[ind], ind+1, dp);
        boolean dont = rec(nums, target, ind+1, dp);
        if(take||dont) {
            dp[ind][target]=1;
        } else dp[ind][target]=0;
        return take||dont;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums) sum+=i;
        if(sum%2==1) return false;
        int dp[][] = new int[nums.length][sum/2+1];
        for(int[] i:dp) Arrays.fill(i, -1);
        return rec(nums, sum/2, 0, dp);
    }
}