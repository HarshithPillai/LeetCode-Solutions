class Solution {
    int n, m;
    public boolean isValid(int[][] grid, int i, int j) {
        int col[] = new int[3];
        if(grid[i+1][j+1] != 5) return false;
        int diag1 = 0;
        Set<Integer> set = new HashSet<>();
        for(int r = 0; r<3; r++) {
            int row = 0;
            for(int c=0; c<3; c++) {
                if(grid[i+r][j+c] >9 || grid[i+r][j+c] <1) return false;
                row+=grid[i+r][j+c];
                col[c] += grid[i+r][j+c];
                if(r==c) diag1 += grid[i+r][j+c];
                set.add(grid[i+r][j+c]);
            }
            if(row != 15) return false;
        }
        if(col[0] != 15 || col[1] != 15 || col[2] != 15 || diag1 != 15 || (grid[i+2][j] + grid[i][j+2] != 10) || set.size() != 9) return false;
        return true;
    }
    public int numMagicSquaresInside(int[][] grid) {
        n = grid.length; m = grid[0].length;
        if(n<3 || m<3) return 0;
        int count = 0;
        for(int i=0; i<n-2; i++) {
            for(int j=0; j<m-2; j++) {
                if(isValid(grid, i, j)) {
                    count++;
                    // i+=2;
                }
            }
        }
        return count;
    }
}