class Solution {
    Integer[] dp;
    public int recur(String s, int i, int n, Set<String> set) {
        if(i>=n) return 0;
        if(dp[i] != null) return dp[i];
        /**
            take ith character as extra or not
        */
        int res = 1 + recur(s, i+1, n, set);
        for(int j=i+1; j<=n; j++) {
            String sub = s.substring(i, j);
            if(set.contains(sub)) {
                res = Math.min(res, recur(s, j, n, set));
            }
        }
        return dp[i] = res;
    }
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        dp = new Integer[s.length()];
        return recur(s, 0, s.length(), set);
    }
}