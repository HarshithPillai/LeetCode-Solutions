class Solution {
    Integer dp[][] = new Integer[101][101];
    public int helper(char[] arr, int i, int j) {
        if(i==j) return 1;
        if(dp[i][j] != null) return dp[i][j];
        int res = (int)1e9;
        for(int k=i; k<j; k++) {
            // In case the first character of both subarrays are same, then reduce by 1
            int minus = (arr[i] == arr[k+1])?1:0;
            res = Math.min(res, helper(arr, i, k) + helper(arr, k+1, j) - minus);
        }
        return dp[i][j] = res;
    }
    public int strangePrinter(String s) {
        /**
            Similar to Matric Chain multiplication/ Burst Balloon/ Rod cutting
        */
        char[] arr = s.toCharArray();
        return helper(arr, 0, s.length()-1);
    }
}