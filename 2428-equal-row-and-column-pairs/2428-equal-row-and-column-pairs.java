class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Map<String, Integer> row = new HashMap<>(), col = new HashMap<>();
        for(int i=0; i<n; i++) {
            StringBuilder s = new StringBuilder();
            for(int j=0; j<m; j++) {
                if(!s.isEmpty()) s.append("_");
                s.append(grid[i][j]);
            }
            String st = new String(s);
            row.put(st, row.getOrDefault(st, 0) + 1);
        }
        for(int i=0; i<m; i++) {
            StringBuilder s = new StringBuilder();
            for(int j=0; j<n; j++) {
                if(!s.isEmpty()) s.append("_");
                s.append(grid[j][i]);
            }
            String st = new String(s);
            col.put(st, col.getOrDefault(st, 0) + 1);
        }
        int count = 0;
        for(Map.Entry<String, Integer> entry:row.entrySet()) {
            String val = entry.getKey();
            int freq = entry.getValue();
            if(col.containsKey(val)) {
                count += freq * col.get(val);
            }
        }
        return count;
    }
}