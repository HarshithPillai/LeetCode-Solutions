class Solution {
    class Pair{
        int dist, row, col;
        Pair(int d, int r, int c) { dist=d; row=r; col=c; }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        int r=grid.length;
        int n=r;
        
        int c=r;
        int[][] dist = new int[r][c];
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                dist[i][j]=(int)(1e9);
            }
        }
        dist[0][0]=1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->{
            return x.dist-y.dist;
        });
        pq.add(new Pair(1, 0, 0));
        while(!pq.isEmpty()) {
            Pair top = pq.poll();
            int dis=top.dist;
            int x=top.row;
            int y=top.col;
            int[] dx={1,0,-1,0,1,-1,1,-1};
            int[] dy={0,1,0,-1,1,-1,-1,1};
            for(int i=0;i<8;i++) {
                int row=x+dx[i];
                int col=y+dy[i];
                if(row>=0 && col>=0 && row<r && col<c && grid[row][col]==0) {
                    if(dis+1<dist[row][col]) {
                        dist[row][col]=dis+1;
                        pq.add(new Pair(dis+1,row,col));
                    }
                }
            }
        }
        if(dist[n-1][n-1]==(int)(1e9)) return -1;
        return dist[n-1][n-1];
    }
}