class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<matrix.length; i++) {
            boolean flip = (matrix[i][0] == 1);
            StringBuilder sb = new StringBuilder();
            for(int j:matrix[i]) {
                int val = (flip)?(j^1):j;
                sb.append(val);
            }
            String str = new String(sb);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        int ans = 0;
        for(int val:map.values()) ans = Math.max(ans, val);
        return ans;
    }
}