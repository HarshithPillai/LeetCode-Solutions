class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length, prefix = values[0], ans = 0;
        for(int i=1; i<n; i++) {
            ans = Math.max(ans, prefix-1 + values[i]);
            prefix = Math.max(prefix-1, values[i]);
        }
        return ans;
    }
}