class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        /**
            create adj list
            topo sort
            now we have a stack containing all people sorted by how rich they are
            with top being the most rich person
            keep popping each items
        */
        int n = quiet.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n];
        for(int[] i:richer) {
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[n], vis = new int[n];
        for(int i=0;i<n; i++) {
            ans[i] = i;
            if(indegree[i]==0) {
                q.add(i);
                vis[i] = 1;
            }
        }
        while(!q.isEmpty()) {
            int person = q.poll();
            int quietPerson = ans[person];
            for(int nbr:adj.get(person)) {
                if(vis[nbr]==0) {
                    indegree[nbr]--;
                    if(quiet[ans[nbr]] > quiet[quietPerson]) {
                        ans[nbr] = quietPerson;
                    }
                    if(indegree[nbr]==0) {
                        q.add(nbr);
                        vis[nbr] = 1;
                    }
                }
            }
        }
        return ans;
    }
}