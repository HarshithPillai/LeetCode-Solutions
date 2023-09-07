class Solution {

    class Tuple{
        int distance;
        int row;
        int col;
        public Tuple(int distance,int row, int col){
            this.row = row;
            this.distance = distance;
            this.col = col; 
        }
    }
   
    public int minimumEffortPath(int[][] grid) {
        PriorityQueue<Tuple> pq = 
        new PriorityQueue<Tuple>((x,y) -> x.distance - y.distance);
        int r= grid.length;
        int c= grid[0].length;
        int[][] dist = new int[r][c];
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                dist[i][j]=(int)(1e9);
            }
        }
        dist[0][0]=0;
        // Queue<Pair> pq = new LinkedList<>();
        pq.add(new Tuple(0, 0, 0));
        while(pq.size() != 0) {
            Tuple top = pq.peek();
            pq.remove();
            int dis=top.distance;
            int x=top.row;
            int y=top.col;
            //if(x == r-1 && y == c-1) return dis; 
            // if(x==r-1 && y==c-1) return dis;
            int[] dx={-1,0,1,0};
            int[] dy={0,1,0,-1};
            for(int i=0;i<4;i++) {
                int row=x+dx[i];
                int col=y+dy[i];
                if(row>=0 && col>=0 && row<r && col<c) {
                    int abs1=Math.max(dis,Math.abs(grid[x][y]-grid[row][col]));
                   
                    if(abs1<dist[row][col]) {
                        dist[row][col]=abs1;
                        pq.add(new Tuple(abs1,row,col));
                    }
                }
            }
        }
        if(dist[r-1][c-1]==(int)(1e9)) return 0;
        return dist[r-1][c-1];
    }
}