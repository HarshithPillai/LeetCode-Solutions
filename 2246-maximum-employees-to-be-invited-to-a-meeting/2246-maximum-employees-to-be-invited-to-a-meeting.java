class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] indegree = new int[n], depth = new int[n];
        Arrays.fill(depth, 1);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            indegree[favorite[i]]++;
        }
        for(int i=0; i<n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int node = q.poll();
            int next = favorite[node];
            indegree[next]--;
            depth[next] = Math.max(depth[next], depth[node] + 1);
            if(indegree[next] == 0) {
                q.add(next);
            }
        }
        int longestCycle = 0, twoLengthCycle = 0;
        for(int i=0; i<n; i++) {
            if(indegree[i] == 0) continue;
            int curr = i, cycleLength = 0;
            while(indegree[curr] != 0) {
                indegree[curr] = 0;
                curr = favorite[curr];
                cycleLength++;
            }
            if(cycleLength == 2) {
                twoLengthCycle += depth[curr] + depth[favorite[curr]];
            } else {
                longestCycle = Math.max(longestCycle, cycleLength);
            }
        }
        return Math.max(longestCycle, twoLengthCycle);
    }
}