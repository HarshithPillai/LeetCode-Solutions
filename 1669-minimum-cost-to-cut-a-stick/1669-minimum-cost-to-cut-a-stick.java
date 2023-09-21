class Solution {
    int[][] dp;
    public int helper(int[] cuts, int s, int e) {
        if(s>e) return 0;
        if(dp[s][e]!=-1) return dp[s][e];
        int res = Integer.MAX_VALUE;
        for(int i=s;i<=e;i++) {
            int current = cuts[e+1] - cuts[s-1];
            int first   = helper(cuts,  s, i-1);
            int second  = helper(cuts, i+1,  e);
            res = Math.min(res,current + first + second);
        }
        return dp[s][e]=res;
    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts); // needed to make each subproblem separate from each other
        // other wise we might get a case [1,2,6] [3,5]. 
        // here the entire 2nd array is within the range of first array
        int size=cuts.length;
        dp=new int[size+2][size+2];
        
        int[] newcuts= new int[size+2];
        for(int i=1;i<=size;i++) {
            newcuts[i]=cuts[i-1];
        }
        newcuts[size+1]=n;

        for(int i=size; i>0; i--) {
            for(int j=i;j<=size;j++) {
                int res=Integer.MAX_VALUE;
                for(int k=i;k<=j;k++) {
                    int current = newcuts[j+1] - newcuts[i-1];
                    int first   = dp[i][k-1];
                    int second  = dp[k+1][j];
                    res = Math.min(res,current + first + second);
                }
                dp[i][j]=res;
            }
        }

        return dp[1][size];
    }
}