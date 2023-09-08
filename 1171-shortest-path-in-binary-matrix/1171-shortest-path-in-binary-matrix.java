class Solution {
    class Pair{
        int dist, row, col;
        Pair(int d, int r, int c) { dist=d; row=r; col=c; }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.dist-y.dist);
        
        int r=grid.length;
        int c=r;
        int dist[][] = new int[r][c];
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                dist[i][j]=(int)1e9;
            }
        }
        dist[0][0]=1;
        pq.add(new Pair(1,0,0));

        int dx[] = {1,0,-1, 0,1,-1,-1,1};
        int dy[] = {0,1, 0,-1,1,-1, 1,-1};
        while(!pq.isEmpty()) {
            Pair top = pq.poll();
            int dis = top.dist;
            int row = top.row;
            int col = top.col;
            for(int i=0; i<8; i++) {
                int newr = row+dx[i];
                int newc = col+dy[i];
                if(newr>=0 && newc>=0 && newr<r && newc<c && grid[newr][newc]==0) {
                    if(dis+1<dist[newr][newc]) {
                        dist[newr][newc]=dis+1;
                        pq.add(new Pair(dis+1, newr, newc));
                    }
                }
            }
        }

        if(dist[r-1][c-1]==(int)1e9) return -1;
        return dist[r-1][c-1];
    }
}