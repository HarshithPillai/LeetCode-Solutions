class Solution {
    int max = 0;
    public void helper(String s, int ind, int n, Set<String> set) {
        if(ind==n) {
            max = Math.max(max, set.size());
            return;
        }
        for(int i=ind; i<n; i++) {
            String curr = s.substring(ind, i+1);
            if(!set.contains(curr)) {
                set.add(curr);
                helper(s, i+1, n, set);
                set.remove(curr);
            }
        }
    }
    public int maxUniqueSplit(String s) {
        int n = s.length();
        helper(s, 0, n, new HashSet<>());
        return max;
    }
}