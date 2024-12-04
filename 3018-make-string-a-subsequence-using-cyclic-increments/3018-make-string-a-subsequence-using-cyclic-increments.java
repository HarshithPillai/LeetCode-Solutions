class Solution {
    Integer[][] dp;
    public char transform(char ch) {
        return (char)(((int)(ch-'a' + 1)%26)+'a');
    }
    // public int lcs(char[] a, int i, char[] b, int j) {
    //     if(i==-1 || j==-1) return 0;
    //     if(dp[i][j] != null) return dp[i][j];
    //     int res = Math.max(lcs(a, i-1, b, j), lcs(a, i, b, j-1));
    //     if(a[i] == b[j] || transform(a[i]) == b[j]) {
    //         res = Math.max(1+lcs(a, i-1, b, j-1), res);
    //     }
    //     return dp[i][j] = res;
    // }
    public boolean canMakeSubsequence(String str1, String str2) {
        // dp = new Integer[str1.length()][str2.length()];
        // int lcs = lcs(str1.toCharArray(), str1.length()-1, str2.toCharArray(), str2.length()-1);
        // return lcs == str2.length();
        char[] a = str1.toCharArray(), b = str2.toCharArray();
        int n = str1.length(), m = str2.length(), i = n-1, j = m-1;
        while(i>=0 && j>=0) {
            if(a[i] == b[j] || transform(a[i]) == b[j]) {
                j--;
            }
            i--;
        }
        return j<0;
    }
}