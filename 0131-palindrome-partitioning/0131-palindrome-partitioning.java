class Solution {
    String st;
    int n;
    public boolean isPossible(int s, int e) {
        while(s<e) {
            if(st.charAt(s) != st.charAt(e)) return false;
            s++; e--;
        }
        return true;
    }
    public void helper(List<List<String>> res, int s, int e, List<String> curr) {
        if(s==n) {
            res.add(new ArrayList(curr));
            return;
        }
        if(e==n) return;
        helper(res, s, e+1, curr);
        if(isPossible(s,e)) {
            curr.add(st.substring(s, e+1));
            helper(res, e+1, e+1, curr);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<String>> partition(String str) {
        List<List<String>> res = new ArrayList<>();
        st = str;
        n = str.length();
        helper(res, 0, 0, new ArrayList<>());
        return res;
    }
}