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
                Set<String> temp = new HashSet<>(set);
                temp.add(curr);
                helper(s, i+1, n, temp);
            }
        }
    }
    public int maxUniqueSplit(String s) {
        int n = s.length();
        helper(s, 0, n, new HashSet<>());
        return max;
    }
}