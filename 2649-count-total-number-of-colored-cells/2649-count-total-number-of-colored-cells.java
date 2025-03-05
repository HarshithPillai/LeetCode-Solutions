class Solution {
    public long coloredCells(int N) {
        long ans = 1, n = (long) N;
        for (long i = 1; i < n; i++) {
            ans += 4 * i;
        }
        return ans;
    }
}