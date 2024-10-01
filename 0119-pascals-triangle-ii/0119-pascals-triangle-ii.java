class Solution {
    public List<Integer> getRow(int ind) {
        if(ind == 0) return List.of(1);
        if(ind == 1) return List.of(1, 1);
        List<Integer> prev = new ArrayList();
        prev.add(1); prev.add(1);
        for(int i=2; i<=ind+1; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for(int j=1; j<i-1; j++) {
                curr.add(prev.get(j-1) + prev.get(j));
            }
            curr.add(1);
            prev = curr;
        }
        return prev;
    }
}