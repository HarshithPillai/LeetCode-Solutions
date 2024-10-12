class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int ans = 0, dx[] = {1,0,-1,0}, dy[] = {0,-1,0,1}, r = maze.length, c = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] pos = q.poll();
                int row = pos[0], col = pos[1];
                for(int k=0; k<4; k++) {
                    int newr = row + dx[k], newc = col + dy[k];
                    if(newr < r && newr >= 0 && newc < c && newc >= 0) {
                        if(maze[newr][newc] == '.') {
                            q.add(new int[]{newr, newc});
                            maze[newr][newc] = '+';
                        }
                    } else if(ans > 0) return ans;
                }
            }
            ans++;
        }
        return -1;
    }
}