class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0,n=nums.length;
        for(int i:nums) sum+=i;
        if(sum%2==1) return false;
        sum/=2;
        boolean[] dp = new boolean[sum+1];
        dp[0]=true;
        for(int i=1;i<=n;i++) {
            boolean[] dp1 = new boolean[sum+1];
            for(int j=0;j<=sum;j++) {
                dp1[j]=dp[j];
                if(j-nums[i-1]>=0 && dp1[j]==false)dp1[j]=dp[j-nums[i-1]];
            }
            dp=dp1;
        }
        return dp[sum];
    }
}