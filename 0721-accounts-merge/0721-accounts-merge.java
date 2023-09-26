class Solution {
    class DisjointSet {
        List<Integer> parent = new ArrayList<>(), size = new ArrayList<>();
        DisjointSet(int n) {
            for(int i=0;i<=n;i++) {
                parent.add(i); size.add(1);
            }
        }
        public int findUPar(int u) {
            if(parent.get(u)==u) return u;
            int ulp_u = findUPar(parent.get(u));
            parent.set(u, ulp_u);
            return ulp_u;
        }
        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u), ulp_v = findUPar(v);
            if(ulp_u == ulp_v) return;
            if(size.get(ulp_u)>size.get(ulp_v)) {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            } else {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> map = new HashMap<>();
        int n=accounts.size();
        DisjointSet ds = new DisjointSet(n);
        for(int i=0;i<n;i++) {
            for(int j=1;j<accounts.get(i).size();j++) {
                String curr = accounts.get(i).get(j);
                if(map.containsKey(curr)) {
                    int parent_node = map.get(curr);
                    ds.unionBySize(i, parent_node);
                } else {
                    map.put(curr,i);
                }
            }
        }
        List<Set<String>> tem = new ArrayList<>();
        for(int i=0;i<n;i++) tem.add(new TreeSet<>());
        for(int i=0;i<n;i++) {
            for(int j=1;j<accounts.get(i).size();j++) {
                String curr = accounts.get(i).get(j);
                int parent_node = ds.findUPar(map.get(curr));
                tem.get(parent_node).add(curr);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(tem.get(i).size()>0) {
                String first = accounts.get(i).get(0);
                List<String> t = new ArrayList<>();
                for(String str:tem.get(i)) {
                    t.add(str);
                }
                t.add(0,first);
                res.add(t);
            }
        }
        return res;
        /**
            go through each email id and put them into their respective id's in map
            <emailId, rowNo>
        */
    }
}