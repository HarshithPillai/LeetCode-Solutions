class Solution {
    int dx[] = {0,1,0,-1}, dy[] = {1,0,-1,0};
    public int robotSim(int[] commands, int[][] obstacles) {
        int x=0, y=0, dir = 0, max = 0;
        Set<List<Integer>> s = new HashSet<>();
        for(int[] ob:obstacles) s.add(List.of(ob[0], ob[1]));
        for(int comm:commands) {
            if(comm == -1) {
                dir = (dir+4+1)%4;
            } else if(comm == -2) {
                dir = (dir+4-1)%4;
            } else {
                for(int i=0; i<comm; i++) {
                    int newx = x+dx[dir], newy = y+dy[dir];
                    if(!s.contains(List.of(newx, newy))) {
                        x = newx;
                        y = newy;
                        max = Math.max(max, newx*newx + newy*newy);
                    } else break;
                }
            }
        }
        return max;
    }
}