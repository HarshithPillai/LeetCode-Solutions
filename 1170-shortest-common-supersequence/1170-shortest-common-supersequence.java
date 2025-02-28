class Solution {
    int n, m;
    public String shortestCommonSupersequence(String str1, String str2) {
        char[] arr1 = str1.toCharArray(), arr2 = str2.toCharArray();
        n = arr1.length;
        m = arr2.length;
        int[][] dp = new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (arr1[i-1] == arr2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        int i = n, j = m;
        StringBuilder sb = new StringBuilder();
        while (i>0 && j>0) {
            while (i > 0 && dp[i][j] == dp[i-1][j]) {
                sb.append(arr1[i-1]);
                i--;
            }
            while (j > 0 && dp[i][j] == dp[i][j-1]) {
                sb.append(arr2[j-1]);
                j--;
            }
            if(i > 0) sb.append(arr1[i-1]);
            i--;
            j--;
        }

        while (i > 0) {
            sb.append(arr1[i-1]);
            i--;
        }

        while (j > 0) {
            sb.append(arr2[j-1]);
            j--;
        }

        sb.reverse();

        return new String(sb);
    }
}