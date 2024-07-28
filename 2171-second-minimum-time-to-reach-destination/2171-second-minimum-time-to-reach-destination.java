class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        /**
            a node can be visited two times
            use priority Queue to keep track of shortest distances
            currtime increases with time after each layer
            now if currtime lands in red light

            vis array will hold 0,1,2
        */
        int[] vis = new int[n];
        int currtime = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int ed[]:edges) {
            adj.get(ed[0]-1).add(ed[1]-1);
            adj.get(ed[1]-1).add(ed[0]-1);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> t = new HashSet<>();
        t.add(0);
        map.put(0, t);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int node = q.poll();
                // if(node == n-1 && vis[n-1] == 2) return currtime;
                for(int nbr:adj.get(node)) {
                    if(map.containsKey(nbr)) {
                        map.get(nbr).add(currtime+time);
                    } else {
                        Set<Integer> s = new HashSet<>();
                        s.add(currtime+time);
                        map.put(nbr, s);
                    }
                    if(nbr == n-1 && map.get(nbr).size() == 2) return currtime+time;
                    if(map.get(nbr).size()<=2) {
                        q.add(nbr);
                    }
                }
            }
            currtime+=time;
            int diff = currtime%(2*change);
            if(diff>=change) currtime+=(2*change - diff);
        }
        return -1;
    }
}