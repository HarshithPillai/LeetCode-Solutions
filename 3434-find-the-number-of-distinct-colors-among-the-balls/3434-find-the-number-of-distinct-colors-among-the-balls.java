class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> freq = new HashMap<>(), ballColor = new HashMap<>();
        int[] ans = new int[queries.length];
        int ind = 0, size = 0;
        for(int[] q:queries) {
            int ball = q[0], color = q[1];
            if(ballColor.containsKey(ball)) {
                int currColor = ballColor.get(ball), cnt = freq.get(currColor);
                if(cnt == 1) {
                    freq.remove(currColor);
                    size--;
                } else {
                    freq.put(currColor, cnt-1);
                }
            }
            ballColor.put(ball, color);
            if(freq.containsKey(color)) {
                freq.put(color, freq.get(color) + 1);
            } else {
                freq.put(color, 1);
                size++;
            }
            
            ans[ind] = size;
            ind++;
        }
        return ans;
    }
}