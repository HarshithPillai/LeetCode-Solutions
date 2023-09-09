class Solution {
    class DisjointSet {
        List<Integer> size, parent;
        DisjointSet(int n) {
            size = new ArrayList<>();
            parent = new ArrayList<>();
            for(int i=0;i<=n;i++) {
                size.add(1);
                parent.add(i);
            }
        }
        public int findUPar(int node) {
            if(parent.get(node)==node) return node;
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return ulp;
        }
        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            int sizeU = size.get(ulp_u);
            int sizeV = size.get(ulp_v);
            if(ulp_u == ulp_v) return;
            if(sizeU < sizeV) {
                parent.set(ulp_u, ulp_v);
            } else {
                parent.set(ulp_v, ulp_u);
            }
            size.set(ulp_u, sizeU+sizeV);
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int V=accounts.size();
        Map<String, Integer> map = new HashMap<>();
        DisjointSet ds = new DisjointSet(V);
        for(int i=0;i<V;i++) {
            int col=accounts.get(i).size();
            for(int j=1;j<col;j++) {
                String email=accounts.get(i).get(j);
                if(map.containsKey(email)) {
                    ds.unionBySize(i, map.get(email));
                } else {
                    map.put(email,i);
                }
            }
        }
        List<List<String>> mergeList = new ArrayList<>();
        for(int i=0;i<V;i++) {
            mergeList.add(new ArrayList<>());
        }
        for(Map.Entry<String, Integer> entry:map.entrySet()) {
            int index=ds.findUPar(entry.getValue());
            String val=entry.getKey();
            mergeList.get(index).add(val);
        }
        
        List<List<String>> result = new ArrayList<>();
        for(int i=0;i<V;i++) {
            if(mergeList.get(i).size()==0) continue;
            Collections.sort(mergeList.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String ele:mergeList.get(i)) temp.add(ele);
            result.add(temp);
        }
        return result;
    }
}