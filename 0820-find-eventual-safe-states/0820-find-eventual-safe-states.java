class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjRev.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++) {
            for(int num:graph[i]) {
                adjRev.get(num).add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        int[] indegree = new int[n];
        for(int i=0; i<n; i++) {
            for(int num:adjRev.get(i)) {
                indegree[num]++;
            }
        }
        for(int i=0;i<n;i++) {
            if(indegree[i]==0) q.add(i);
        }
        while(!q.isEmpty()) {
            int top = q.poll();
            result.add(top);
            for(int num:adjRev.get(top)) {
                indegree[num]--;
                if(indegree[num]==0) {
                    q.add(num);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}