class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        int m=1;
        for(int i=0;i<n;i++) {
            dp[i]=1;// because each element is an Increasing Subsequence in itself
            for(int j=0;j<i;j++) {
                if(nums[i]>nums[j] && dp[j]+1>dp[i]) {
                    dp[i] = 1+dp[j];
                    if(dp[i]>m)m=dp[i];
                }
            }
        }
        return m;
    }
}