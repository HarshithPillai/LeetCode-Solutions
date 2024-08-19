class Solution {
    int total;
    Integer[][] dp;
    public int helper(int tar, int copied) {
        if(tar==0) return 0;
        if(dp[tar][copied] != null) return dp[tar][copied];
        int res = (int)1e6;
        if(tar >= copied) {
            res = helper(tar-copied, copied)+1;
            int newCopied = total-tar;
            if(tar >= newCopied && newCopied != copied) res = Math.min(res, helper(tar-newCopied, newCopied) + 2);
        }
        return dp[tar][copied] = res;
    }
    public int minSteps(int n) {
        if(n==1) return 0;
        total = n;
        dp = new Integer[n][n];
        return helper(n-1,1)+1;
    }
}