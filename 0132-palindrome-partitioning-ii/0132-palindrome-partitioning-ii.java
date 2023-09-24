class Solution {
    int[][] dp;
    public boolean check(char[] arr, int s, int e) {
        while(s<e) {
            if(arr[s]!=arr[e]) return false;
            s++;e--;
        }
        return true;
    }
    public int helper(char[] arr, int s, int e) {
        if(s>e) return 0;
        if(dp[s][e]!=-1) return dp[s][e];
        int res=(int)(1e9);
        for(int k=s;k<=e;k++) {
            if(check(arr,s,k)) {
                res=Math.min(res, 1+helper(arr,k+1,e));
            }
        }
        return dp[s][e]=res;
    }
    public int minCut(String s) {
        char[] arr = s.toCharArray();
        int n=arr.length;
        dp = new int[n+1][n+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(arr,0,n-1)-1;
    }
}