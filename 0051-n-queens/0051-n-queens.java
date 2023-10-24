class Solution {
    public List<String> convert(boolean[][] grid, int n) {
        // TODO
        List<String> res = new ArrayList<>();
        for(int i=0; i<n; i++) {
            char[] arr = new char[n];
            for(int j=0; j<n; j++) {
                if(grid[i][j]) arr[j] = 'Q';
                else arr[j] = '.';
            }
            res.add(new String(arr));
        }
        return res;
    }
    public boolean check(boolean[][] grid, int row, int col, int n) {
        int i=row-1, j=col-1;
        // diagonally left up
        while(i>=0 && j>=0) {
            if(grid[i][j]) return false;
            i--; j--;
        }
        i=row; j=col-1;
        while(j>=0) {
            if(grid[i][j]==true) return false;
            j--;
        }
        i=row+1; j=col-1;
        while(i<n && j>=0) {
            if(grid[i][j]==true) return false;
            i++; j--;
        }

        return true;
    }
    public void dfs(boolean[][] grid, int col, int n, List<List<String>> result) {
        if(col == n) {
            List<String> res = convert(grid, n);
            result.add(res);
        }
        for(int row = 0; row<n; row++) {
            if(check(grid, row, col, n)) {
                grid[row][col] = true;
                dfs(grid, col+1, n, result);
                grid[row][col] = false;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        // table structure: List<boolean>
        boolean[][] temp = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();

        dfs(temp, 0, n, result);

        return result;
    }
}