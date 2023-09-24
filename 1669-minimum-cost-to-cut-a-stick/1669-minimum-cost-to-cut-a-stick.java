class Solution {
    int[][] dp;
    public int helper(int[] cuts, int s, int e) {
        //if(s+1==e) return 0;
        if(s>e) return 0;
        if(dp[s][e]!=-1) return dp[s][e];
        int curr = cuts[e+1]-cuts[s-1], res=(int)(1e9);
        for(int k=s; k<=e; k++) {
            int left = helper(cuts,s,k-1);
            int right= helper(cuts,k+1,e);
            res=Math.min(res, curr+left+right);
        }
        return dp[s][e]=res;
    }
    public int minCost(int len, int[] cuts) {
        /**
            0,1,3,4,5,len
            f(s,e) = min(curr, k:(s->e)->{cuts[e+1]-cuts[s-1] + f(s,k-1) + f(k+1,e)})
         */
        int n=cuts.length;
        Arrays.sort(cuts);
        int[] newcuts = new int[n+2];
        newcuts[0]=0; newcuts[n+1]=len;
        for(int i=1;i<=n;i++) newcuts[i]=cuts[i-1];
        dp = new int[n+2][n+2];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(newcuts, 1, n);
    }
}