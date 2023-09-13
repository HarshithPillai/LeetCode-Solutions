class Solution {
    public int recutil(int[] nums, int ind, int[] dp) {
        if(ind==0) return nums[ind];
        if(ind<0) return 0;
        if(dp[ind]>-1) return dp[ind];
        int pick = nums[ind]+recutil(nums, ind-2,dp);
        int notPicked = recutil(nums, ind-1,dp);
        dp[ind]=Math.max(pick, notPicked);
        return dp[ind];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return recutil(nums, n-1, dp);
    }
}