class Solution {
    public void recutil(char[][] board, int i, int j, int r, int c,int[][] visited) {
        if(i<0 || j<0 || i>=r || j>=c || visited[i][j]==1 || board[i][j]=='X') return;
        visited[i][j] = 1;
        recutil(board, i-1, j, r, c, visited);
        recutil(board, i+1, j, r, c, visited);
        recutil(board, i, j-1, r, c, visited);
        recutil(board, i, j+1, r, c, visited);
    }
    public void solve(char[][] board) {
        int r=board.length, c=board[0].length;
        int[][] visited = new int[r][c];
        for(int i=0; i<r; i++) {
            if(board[i][0]=='O')   recutil(board, i,   0, r, c,visited);
            if(board[i][c-1]=='O') recutil(board, i, c-1, r, c,visited);
        }
        for(int i=0; i<c; i++) {
            if(board[0][i]=='O')   recutil(board,  0, i, r, c,visited);
            if(board[r-1][i]=='O') recutil(board, r-1, i, r, c,visited);
        }
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(board[i][j]=='O' && visited[i][j]==0) board[i][j]='X';
            }
        }
    }
}