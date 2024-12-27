class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int[] prefix = new int[n];
        prefix[0] = values[0];
        int ans = 0;
        for(int i=1; i<n; i++) {
            prefix[i] = Math.max(prefix[i-1]-1, values[i]);
            ans = Math.max(ans, prefix[i-1]-1 + values[i]);
        }
        return ans;
    }
}