class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length, max=1;
        int[] dp = new int[n];
        for(int i=0;i<n;i++) {
            dp[i]=1;//each element is an increasing subsequence in itself;
            for(int j=0;j<i;j++) {
                if(nums[i]>nums[j] && dp[i]<dp[j]+1) {
                    dp[i]=dp[j]+1;
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}