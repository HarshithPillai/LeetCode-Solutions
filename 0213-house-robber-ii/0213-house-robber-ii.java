class Solution {
    public int helper(int[] nums, int s, int e, int n) {
        int dp[] = new int[n];
        dp[s]=nums[s];
        dp[s+1]=Math.max(nums[s], nums[s+1]);
        for(int i=s+2;i<=e;i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[e];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        return Math.max(helper(nums, 1,n-1, n), helper(nums, 0,n-2, n));
    }
}