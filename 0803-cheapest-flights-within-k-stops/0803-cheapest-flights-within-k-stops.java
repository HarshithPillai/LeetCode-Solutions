class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int cost[] = new int[n];
        Arrays.fill(cost, (int)1e9);
        cost[src] = 0;
        for(int i=0; i<=k; i++) {
            int temp[] = new int[n];
            for(int ia=0; ia<n; ia++) temp[ia] = cost[ia];
            for(int ed[]:flights) {
                int u = ed[0], v = ed[1], w = ed[2];
                temp[v] = Math.min(temp[v], cost[u] + w);
            }
            cost = temp;
        }
        if(cost[dst] == (int)1e9) return -1;
        return cost[dst];
    }
}