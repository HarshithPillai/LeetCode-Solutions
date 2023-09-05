class Solution {
    public void recutil(int[][] board, int i, int j, int r, int c,int[][] visited) {
        if(i<0 || j<0 || i>=r || j>=c || visited[i][j]==1 || board[i][j]==0) return;
        visited[i][j] = 1;
        recutil(board, i-1, j, r, c, visited);
        recutil(board, i+1, j, r, c, visited);
        recutil(board, i, j-1, r, c, visited);
        recutil(board, i, j+1, r, c, visited);
    }
    public int numEnclaves(int[][] board) {
        int r=board.length, c=board[0].length;
        int count=0;
        int[][] visited = new int[r][c];
        for(int i=0; i<r; i++) {
            if(board[i][0]==1)   recutil(board, i,   0, r, c,visited);
            if(board[i][c-1]==1) recutil(board, i, c-1, r, c,visited);
        }
        for(int i=0; i<c; i++) {
            if(board[0][i]==1)   recutil(board,  0, i, r, c,visited);
            if(board[r-1][i]==1) recutil(board, r-1, i, r, c,visited);
        }
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(board[i][j]==1 && visited[i][j]==0) count++;
            }
        }
        return count;
    }
}