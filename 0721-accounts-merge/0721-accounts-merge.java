class Solution {
    class DisjointSet {
        List<Integer> size=new ArrayList<>(), parent=new ArrayList<>();
        DisjointSet(int n) {
            for(int i=0;i<=n;i++) {
                size.add(1);
                parent.add(i);
            }
        }
        public int findUPar(int u) {
            if(parent.get(u)==u) return u;
            int ulp = findUPar(parent.get(u));
            parent.set(u, ulp);
            return ulp;
        }
        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if(ulp_v == ulp_u) return;
            if(size.get(ulp_u)<size.get(ulp_v)) {
                size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
                parent.set(ulp_u, ulp_v);
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> adj) {
        int n=adj.size();
        DisjointSet ds = new DisjointSet(n);
        // different rows with some common ids between them
        // merge all the rows who have a single email id in common
        // create a map<String, Int> key is email and value is the row it was in
        // if an email is found that is not in map, add it with the row number
        // else if found in map, then add then union the current row with the row in the map
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            for(int j=1;j<adj.get(i).size();j++) {
                String str=adj.get(i).get(j);
                if(map.containsKey(str)) {
                    ds.unionBySize(i, map.get(str));
                } else {
                    map.put(str, i);
                }
            }
        }
        List<List<String>> temp = new ArrayList<>();
        for(int i=0;i<n;i++) temp.add(new ArrayList<>());
        for(Map.Entry<String, Integer> entry:map.entrySet()) {
            String str = entry.getKey();
            int row = entry.getValue();
            int ulp = ds.findUPar(row);
            temp.get(ulp).add(str);
        }
        List<List<String>> result = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(temp.get(i).size()>0) {
                List<String> t = new ArrayList<>();
                Collections.sort(temp.get(i));
                t.add(adj.get(i).get(0));
                for(String str:temp.get(i)) t.add(str);
                result.add(t);
            }
        }
        return result;
    }
}