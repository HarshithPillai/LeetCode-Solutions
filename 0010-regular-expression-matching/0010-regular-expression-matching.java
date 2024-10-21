class Solution {
    int n, m;
    public boolean dfs(char[] arr, int sind, char[] pat, int pind) {
        if(sind == n && pind == m) return true;
        if(pind == m) return false;
        if(sind == n) {
            if(pind < m-1 && pat[pind+1] == '*') return dfs(arr, sind, pat, pind+2);
            return false;
        }
        char ch = arr[sind];
        if(pind < m-1 && pat[pind+1] == '*') {
            boolean res = dfs(arr, sind, pat, pind+2);
            for(int i = sind; i<n; i++) {
                if(arr[i] == pat[pind] || pat[pind] == '.') {
                    res |= dfs(arr, i+1, pat, pind+2);
                    if(res) return res;
                } else break;
            }
            return res;
        }
        if(arr[sind] == pat[pind] || pat[pind] == '.') return dfs(arr, sind+1, pat, pind+1);
        return false;
    }
    public boolean isMatch(String s, String p) {
        char[] arr = s.toCharArray(), pattern = p.toCharArray();
        n = arr.length;
        m = pattern.length;
        return dfs(arr, 0, pattern, 0);
    }
}