class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] a = s1.toCharArray(), b = s2.toCharArray();
        int n = a.length, m = b.length;
        if(n > m) return false;
        int l=0, r = 0, freq[] = new int[26], target[] = new int[26];
        // freq of a
        for(char ch:a) target[ch - 'a']++;
        while(r<m) {
            char ch = b[r];
            freq[ch-'a']++;
            if(r > n-1) {
                freq[b[l]-'a']--;
                l++;
            }
            boolean restrict = false;
            for(int i=0; i<26; i++) {
                if(target[i] > freq[i]) restrict = true;
            }
            if(!restrict) return true;
            r++;
        }
        return false;
    }
}