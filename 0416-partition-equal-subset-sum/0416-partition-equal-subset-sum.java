class Solution {
    public boolean rec(int[] nums, int target, int ind, int[][] dp, int n) {
        if(target<0) return false;
        if(target==0) return true;
        if(ind==n) return false;
        if(dp[ind][target]!=-1) return dp[ind][target]==1;
        boolean take = rec(nums, target-nums[ind], ind+1, dp,n);
        boolean dont = rec(nums, target, ind+1, dp,n);
        if(take||dont) {
            dp[ind][target]=1;
        } else dp[ind][target]=0;
        return take||dont;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums) sum+=i;
        if(sum%2==1) return false;
        sum/=2;
        int n=nums.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        
        for(int i=0;i<=n;i++) {
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=sum;j++) {
                dp[i][j]=dp[i-1][j];
                if(dp[i-1][j]==false && j-nums[i-1]>=0 && dp[i-1][j-nums[i-1]])
                    dp[i][j]=true;
            }
        }
        return dp[n][sum];
    }
}