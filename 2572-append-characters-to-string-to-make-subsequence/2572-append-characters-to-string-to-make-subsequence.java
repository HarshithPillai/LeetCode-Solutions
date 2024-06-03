class Solution {
    public int appendCharacters(String s, String t) {
        int n = s.length(), m = t.length(), i=0, j=0;
        while(i<n && j<m) {
            if(s.charAt(i) == t.charAt(j)) j++;
            i++;
        }
        return m-j;
    }
}