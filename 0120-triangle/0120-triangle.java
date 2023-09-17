class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int r=triangle.size();
        int c=triangle.get(r-1).size();
        int[][] dp = new int[r][c];
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1;i<r;i++) {
            for(int j=0;j<triangle.get(i).size();j++) {
                int up=Integer.MAX_VALUE,dg=Integer.MAX_VALUE;
                if(j<triangle.get(i).size()-1)up=dp[i-1][j];
                if(j>0)dg=dp[i-1][j-1];
                dp[i][j] = triangle.get(i).get(j) + Math.min(up,dg);
            }
        }
        int res=Integer.MAX_VALUE;
        for(int j=0;j<c;j++) res=Math.min(res,dp[r-1][j]);
        return res;
    }
}