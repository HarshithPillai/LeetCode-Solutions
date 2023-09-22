class Solution {
    int[] dp;
    public int helper(int[] arr, int s, int e, int k) {
        if(s>e) return 0;
        if(dp[s]!=-1) return dp[s];
        int res=0, max=0;
        for(int i=s;i<=e && (i-s+1)<=k ;i++) {
            if(max<arr[i]) max=arr[i];
            res=Math.max(res, max*(i-s+1) + helper(arr, i+1, e, k));
        }
        return dp[s]=res;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length,e=n-1;
        dp = new int[n+1];
        // Arrays.fill(dp,-1);
        for(int s=n-1;s>=0;s--) {
            int res=0, max=0;
            for(int i=s;i<=e && (i-s+1)<=k ;i++) {
                if(max<arr[i]) max=arr[i];
                res=Math.max(res, max*(i-s+1) + dp[i+1]);
            }
            dp[s]=res;
        }
        return dp[0];
    }
}