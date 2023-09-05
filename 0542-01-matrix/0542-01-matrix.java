class Solution {
    class Pair {
        int row, col, dist;
        Pair(int r, int c, int d) {
            row=r; col=c; dist=d;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int r=mat.length, c=mat[0].length;
        int[][] visited=new int[r][c];
        Queue<Pair> q = new LinkedList<>();

        int[][] result = new int[r][c];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(mat[i][j]==0) {
                    visited[i][j]=1;
                    q.add(new Pair(i,j,0));
                } 
            }
        }
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};

        while(!q.isEmpty()) {
            Pair top = q.poll();
            int x=top.row;
            int y=top.col;
            int step=top.dist;
            result[x][y]=step;
            for(int i=0;i<4;i++) {
                int row=x+dx[i], col=y+dy[i];
                if(row>=0 && col>=0 && row<r && col<c && visited[row][col]==0) {
                    visited[row][col]=1;
                    q.add(new Pair(row,col,step+1));
                }
            }        
        }

        return result;
    }
}