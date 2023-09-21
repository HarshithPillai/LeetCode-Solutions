class Solution {
    int[][] dp;
    public int helper(int[] nums, int s, int e) {
        if(s>e) return 0;
        if(dp[s][e]!=-1) return dp[s][e];
        int res=0;
        for(int k=s;k<=e;k++) {
            int current = nums[s-1]*nums[k]*nums[e+1];
            int left    = helper(nums, s, k-1);
            int right   = helper(nums, k+1, e);
            res = Math.max(res, current + left + right);
        }
        return dp[s][e] = res;
    }
    public int maxCoins(int[] nums) {
        int n=nums.length;
        dp=new int[n+2][n+2];
        //for(int[] i:dp) Arrays.fill(i,-1);
        int[] newnums = new int[n+2];
        newnums[0]=1; newnums[n+1]=1;
        for(int i=1;i<=n;i++) newnums[i]=nums[i-1];

        for(int s=n;s>=1;s--) {
            for(int e=s;e<=n;e++) {
                int res=0;
                for(int k=s;k<=e;k++) {
                    int current = newnums[s-1]*newnums[k]*newnums[e+1];
                    int left    = dp[s][k-1];
                    int right   = dp[k+1][e];
                    res = Math.max(res, current + left + right);
                }
                dp[s][e] = res;
            }
        }
        return dp[1][n];
    }
}