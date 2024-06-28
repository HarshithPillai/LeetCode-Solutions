class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int indegree[] = new int[n];
        for(int edge[]:roads) {
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[0], a[0]));
        for(int i=0; i<n; i++) {
            pq.add(new int[]{indegree[i], i});
        }
        long val = n, ans = 0;
        for(; val>0; val--) {
            ans+=val*pq.poll()[0];
        }
        return ans;
    }
}