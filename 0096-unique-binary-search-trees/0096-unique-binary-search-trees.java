class Solution {
    public int dfs(int s, int e) {
        if(e < s) return 0;
        if(e-s < 2) return e-s+1;
        int curr = dfs(s, e-1) + dfs(s+1, e);
        for(int i=s+1; i<e; i++) {
            curr += dfs(s, i-1) * dfs(i+1, e);
        }
        return curr;
    }
    public int numTrees(int n) {
        return dfs(1, n);
    }
}