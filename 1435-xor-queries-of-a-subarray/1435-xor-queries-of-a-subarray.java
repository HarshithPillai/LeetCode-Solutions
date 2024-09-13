class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] xor = new int[n];
        int val = 0;
        for(int i=0; i<n; i++) {
            val^=arr[i];
            xor[i] = val;
        }
        int m = queries.length;
        int[] ans = new int[m];
        for(int i=0; i<m; i++) {
            int l = queries[i][0], r = queries[i][1];
            if(l>0) ans[i] = xor[r]^xor[l-1];
            else ans[i] = xor[r];
        }
        return ans;
    }
}