class Solution {
    int max = 0;
    public void helper(String s, int ind, int n, Set<String> set) {
        max = Math.max(max, set.size());
        if(ind==n) return;
        for(int i=ind; i<n; i++) {
            Set<String> temp = new HashSet<>(set);
            temp.add(s.substring(ind, i+1));
            helper(s, i+1, n, temp);
        }
    }
    public int maxUniqueSplit(String s) {
        int n = s.length();
        helper(s, 0, n, new HashSet<>());
        return max;
    }
}