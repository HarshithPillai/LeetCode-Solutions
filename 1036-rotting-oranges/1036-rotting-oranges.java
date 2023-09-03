class Solution {
    class Pair {
        int i, j;
        Pair(int r, int c) { i=r; j=c; }
    }

    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==2) {
                    q.add(new Pair(i-1,j));
                    q.add(new Pair(i+1,j));
                    q.add(new Pair(i,j-1));
                    q.add(new Pair(i,j+1));
                }
            }
        }
        int maxtime=0;
        while(!q.isEmpty()) {
            int size=q.size();
            while(size-->0) {
                Pair top = q.poll();
                int i=top.i;
                int j=top.j;
                if(i<0 || j<0 || i>=m || j>=n || grid[i][j]!=1) continue;
                grid[i][j]=2;
                q.add(new Pair(i-1,j));
                q.add(new Pair(i+1,j));
                q.add(new Pair(i,j-1));
                q.add(new Pair(i,j+1));

            }
            if(!q.isEmpty()) maxtime++;
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