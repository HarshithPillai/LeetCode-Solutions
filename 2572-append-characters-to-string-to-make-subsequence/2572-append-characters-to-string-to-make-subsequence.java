class Solution {
    int n, m;
    public int appendCharacters(String s, String t) {
        n = s.length(); m = t.length();
        int i=0, j=0;
        while(i<n && j<m) {
            if(s.charAt(i) == t.charAt(j)) {
                i++; j++;
            } else {
                i++;
            }
        }
        return m-j;
    }
}