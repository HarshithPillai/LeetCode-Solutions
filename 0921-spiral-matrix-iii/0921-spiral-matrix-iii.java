class Solution {
    int n, m, dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0}, ind = 0;
    int[][] ans;
    public boolean isValid(int r, int c) {
        return r<n && r>=0 && c<m && c>=0;
    }
    public void helper(int r, int c, int dist, int travelled, int count, int dir) {
        if(ind == n*m) return;
        if(isValid(r, c)) {
            ans[ind][0] = r;
            ans[ind][1] = c;
            ind++;
        }
        if(travelled == dist) {
            count++;
            dir++;
            travelled = 0;
            if(count == 2) {
                count = 0;
                dist++;
            }
        }
        int newr = r + dx[dir%4], newc = c + dy[dir%4];
        helper(newr, newc, dist, travelled+1, count, dir);
    }
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        n = rows;
        m = cols;
        ans = new int[rows*cols][2];
        helper(rStart, cStart, 1, 0, 0, 0);
        return ans;
    }
}