class Solution {
    public int appendCharacters(String s, String t) {
        int n = s.length(), m = t.length(), i=0, j=0;
        char[] sa = s.toCharArray(), ta = t.toCharArray();
        while(i<n && j<m) {
            if(sa[i] == ta[j]) j++;
            i++;
        }
        return m-j;
    }
}