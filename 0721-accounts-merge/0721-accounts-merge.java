class Solution {
    public class DisjointSet {
        List<Integer> parent, size;
        DisjointSet(int n) {
            parent = new ArrayList<>();
            size = new ArrayList<>();
            for(int i=0; i<n; i++) {
                parent.add(i);
                size.add(1);
            }
        }
        int findUPar(int node) {
            int par = parent.get(node);
            if(par != node) {
                par = findUPar(par);
                parent.set(node, par);
            }
            return par;
        }
        boolean unionBySize(int u, int v) {
            int parU = findUPar(u), parV = findUPar(v);
            if(parU == parV) return false;
            int sizeU = size.get(parU), sizeV = size.get(parV);
            if(sizeU < sizeV) {
                parent.set(parU, parV);
                size.set(parV, sizeU + sizeV);
            } else {
                parent.set(parV, parU);
                size.set(parU, sizeU + sizeV);
            }
            return true;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        /**
        */
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            List<String> acc = accounts.get(i);
            for(int j=1; j<acc.size(); j++) {
                String email = acc.get(j);
                if(map.containsKey(email)) {
                    ds.unionBySize(i, map.get(email));
                } else {
                    map.put(email, i);
                }
            }
        }

        List<List<String>> temp = new ArrayList<>();
        for(int i=0; i<n; i++) temp.add(new ArrayList<>());
        for(Map.Entry<String, Integer> entry:map.entrySet()) {
            int par = ds.findUPar(entry.getValue());
            temp.get(par).add(entry.getKey());
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(temp.get(i).size()>0) {
                Collections.sort(temp.get(i));
                List<String> t = new ArrayList<>();
                t.add(accounts.get(i).get(0));
                for(String s:temp.get(i)) t.add(s);
                ans.add(t);
            }
        }
        return ans;
    }
}