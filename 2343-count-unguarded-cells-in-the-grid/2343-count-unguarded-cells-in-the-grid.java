class Solution {
    int[] dx = {1,0,-1,0}, dy = {0,-1,0,1};
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        Set<List<Integer>> ans = new HashSet<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                ans.add(List.of(i, j));
            }
        }
        Set<List<Integer>> wallset = new HashSet<>();
        for(int[] wall:walls) {
            wallset.add(List.of(wall[0], wall[1]));
            // if(ans.contains(List.of(wall[0], wall[1]))) System.out.println("yes present "+wall[0]+" "+wall[1]);
            ans.remove(List.of(wall[0], wall[1]));
        }
        Set<List<Integer>> guardset = new HashSet<>();
        for(int[] guard:guards) {
            guardset.add(List.of(guard[0], guard[1]));
        }
        for(int[] guard:guards) {
            for(int k=0; k<4; k++) {
                int row = guard[0], col = guard[1];
                while(true) {
                    ans.remove(List.of(row, col));
                    row += dx[k];
                    col += dy[k];
                    if(row < 0 || col < 0 || row >= m || col >= n 
                        || wallset.contains(List.of(row, col))
                        || guardset.contains(List.of(row, col))) {
                        // if(wallset.contains(List.of(row, col))) System.out.println("yes");
                        break;
                    }
                }
            }
        }
        return ans.size();
    }
}