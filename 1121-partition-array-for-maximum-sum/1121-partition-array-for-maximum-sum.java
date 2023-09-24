class Solution {
    int[] dp;
    public int helper(int[] arr, int s, int e, int k) {
        if(s>e) return 0;
        if(dp[s]!=-1) return dp[s];
        int max=arr[s], res=0;
        for(int ind=s; ind<=e && (ind-s+1)<=k; ind++) {
            if(arr[ind]>max) max=arr[ind];
            int curr=max*(ind-s+1);
            res=Math.max(res, curr + helper(arr, ind+1, e, k));
        }
        return dp[s]=res;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(arr, 0, n-1, k);
    }
}