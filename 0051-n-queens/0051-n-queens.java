class Solution {
    public boolean canPlace(int i, int j, char[][] board, int n) {
        int x=i, y=j;
        if(i==n || i==-1 || j==-1 || j==n) return false;
        
        while(i<n && j<n && i>-1 && j>-1) {
            if(board[i][j]=='Q') return false;
            i++; j--;
        }
        i=x;
        j=y;
        while(i<n && j<n && i>-1 && j>-1) {
            if(board[i][j]=='Q') return false;
            i--; j--;
        }
        i=x;
        j=y;
        while(j>-1) {
            if(board[i][j]=='Q') return false;
            j--;
        }
        return true;
    }
    public void recUtil(List<List<String>> result, char[][] board, int ind, int n) {
        if(ind==n) {
            // all queens are placed on the board. TODO add the strings to a list and add the list to result
            List<String> temp = new ArrayList<>();
            for(int i=0; i<n; i++) {
                String row="";
                for(int j=0; j<n; j++) {
                    row+=""+board[i][j];
                }
                temp.add(row);
            }
            result.add(temp);
            return;
        }
        for(int i=0; i<n; i++) {
            if(canPlace(i, ind, board, n)) {
                board[i][ind] = 'Q';
                recUtil(result, board, ind+1, n);
                board[i][ind] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j]='.';
            }
        }
        
        recUtil(result, board, 0, n);

        return result;
    }
}