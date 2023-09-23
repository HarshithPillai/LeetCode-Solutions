class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0, n=nums.length;
        for(int i:nums) sum+=i;
        if(target>sum) return 0;
        if((sum-target)%2==1) return 0;
        sum=(sum-target)/2;
        int[][] dp = new int[n+1][sum+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=sum;j++) {
                dp[i][j]=dp[i-1][j];
                if(j-nums[i-1]>=0) dp[i][j]+=dp[i-1][j-nums[i-1]];
            }
        }
        return dp[n][sum];
    }
}