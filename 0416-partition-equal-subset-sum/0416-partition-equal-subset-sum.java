class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0,n=nums.length;
        for(int i:nums) sum+=i;
        if(sum%2==1) return false;
        sum/=2;
        boolean[][] dp = new boolean[n+1][sum+1];
        dp[0][0]=true;
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=sum;j++) {
                dp[i][j]=dp[i-1][j];
                if(j-nums[i-1]>=0 && dp[i][j]==false)dp[i][j]=dp[i-1][j-nums[i-1]];
            }
        }
        return dp[n][sum];
    }
}