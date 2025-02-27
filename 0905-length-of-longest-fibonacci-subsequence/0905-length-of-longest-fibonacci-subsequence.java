class Solution {
    int ans = 0, n;
    public int lenLongestFibSubseq(int[] arr) {
        n = arr.length;
        Map<Integer, Integer> index = new HashMap<>();
        for(int i=0; i<n; i++) {
            index.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
        for(int i[] : dp) Arrays.fill(i, 1);
        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                int prevVal = arr[i] - arr[j];
                if(index.containsKey(prevVal) && index.get(prevVal) < j) {
                    int prevIndex = index.get(prevVal);
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[j][prevIndex]);
                    ans = Math.max(ans, dp[i][j] + 1);
                }
            }
        }
        return (ans > 2) ? ans : 0;
    }
}