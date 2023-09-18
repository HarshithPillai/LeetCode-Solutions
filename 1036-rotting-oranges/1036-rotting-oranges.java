class Solution {
    class Pair{
        int row,col,level;
        Pair(int r, int c, int l) { row=r; col=c; level=l; }
    }
    public int orangesRotting(int[][] grid) {
        int rows=grid.length, cols=grid[0].length;
        //PriorityQueue<Pair> q = new PriorityQueue<>((x,y)->x.level-y.level);
        Queue<Pair> q = new LinkedList<>();
        int count=0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j]==2) {
                    q.add(new Pair(i,j,0));
                }
                if(grid[i][j]==1) count++;
            }
        }
        int max=0;
        int[] dx={1,0,-1,0};
        int[] dy={0,1,0,-1};
        while(!q.isEmpty()) {
            Pair top = q.poll();
            int r=top.row;
            int c=top.col;
            int l=top.level;
            if(l>max) max=l;
            for(int i=0;i<4;i++) {
                int newr=r+dx[i], newc=c+dy[i];
                if(newr>=0 && newc>=0 && newr<rows && newc<cols && grid[newr][newc]==1) {
                    grid[newr][newc]=2; count--;
                    q.add(new Pair(newr,newc,l+1));
                }
            }
        }
        if(count!=0) return -1;
        return max;
    }
}