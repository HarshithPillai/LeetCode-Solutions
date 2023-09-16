class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        // count the number of partitions such that the difference between them is target
        int sum = 0;
        for(int i:nums) sum+=i;
        if(sum<target) return 0;
        if((sum-target)%2==1) return 0;
        sum = (sum-target)/2;
        int[][] dp = new int[n+1][sum+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=sum;j++) {
                int dont=dp[i-1][j];
                int take=0;
                if(j-nums[i-1]>=0) {
                    take=dp[i-1][j-nums[i-1]];
                }
                dp[i][j]=take+dont;
            }
        }
        return dp[n][sum];
    }
}