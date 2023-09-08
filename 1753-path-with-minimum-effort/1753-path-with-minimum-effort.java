class Solution {
    class Pair{
        int diff, row, col;
        Pair(int d, int r, int c) { diff=d; row=r; col=c; }
    }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.diff-y.diff);
        //Queue<Pair> pq = new LinkedList<>();
        int r=heights.length;
        int c=heights[0].length;
        //used to store the minimum of the max effort of the paths to each cell
        int diff[][] = new int[r][c];
        for(int i=0;i<r; i++) {
            for(int j=0;j<c;j++) {
                diff[i][j]=(int)1e9;
            }
        }
        diff[0][0]=0;
        pq.add(new Pair(0,0,0));
        int dx[] = {1,0,-1, 0};
        int dy[] = {0,1, 0,-1};
        while(!pq.isEmpty()) {
            Pair top = pq.poll();
            int dif = top.diff;
            int row = top.row;
            int col = top.col;
            // try returning the first we get for target indices
            //if(row==r-1 && col==c-1) return dif;
            for(int i=0;i<4; i++) {
                int newr = row+dx[i];
                int newc = col+dy[i];
                if(newr>=0 && newc>=0 && newr<r && newc<c) {
                    int newEffort = Math.abs(heights[row][col]-heights[newr][newc]);
                    newEffort = Math.max(newEffort, dif);
                    if(newEffort < diff[newr][newc]) {
                        diff[newr][newc] = newEffort;
                        pq.add(new Pair(newEffort, newr, newc));
                    }
                }
            }
        }
        return diff[r-1][c-1];
    }
}
