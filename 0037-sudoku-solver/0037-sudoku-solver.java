class Solution {
    public int[] getXOfGrid(int i, int j) {
        int x=i/3;
        int y=j/3;
        int[] res=new int[2];
        res[0]=x;res[1]=y;
        return res;
    }
    public boolean canPlace(char[][] board, int i, int j, char val) {
        for(int row=0; row<9; row++) {
            if(board[row][j]==val) return false;
            if(board[i][row]==val) return false;
            if(board[(i/3)*3+(row/3)][(j/3)*3+(row%3)]==val) return false;
        }
        //4,7
        
        return true;
    }
    public boolean recUtil(char[][] board) {
        
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j]=='.') {
                    for(char ch='1'; ch<='9'; ch++) {
                        if(canPlace(board, i,j, ch)) {
                            board[i][j]=ch;
                            if(recUtil(board)) {
                                return true;
                            } else {
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        
        recUtil(board);
    }
}