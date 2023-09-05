class Solution {
    class Pair {
        int i, j, step;
        Pair(int r, int c, int s) { i=r; j=c; step=s; }
    }

    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==2) {
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int maxtime=0;
        int[] dx={1,0,-1,0};
        int[] dy={0,1,0,-1};
        while(!q.isEmpty()) {
            Pair top = q.poll();
            int i=top.i;
            int j=top.j;
            int step=top.step;
            maxtime=step;
            for(int k=0;k<4;k++) {
                int r=i+dx[k], c=j+dy[k];
                if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==1) {
                    grid[r][c]=2;
                    q.add(new Pair(r,c,step+1));
                }
            }
        }

        // check if any orange is still not rotten
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==1) return -1;
            }
        }
        return maxtime;
    }
}