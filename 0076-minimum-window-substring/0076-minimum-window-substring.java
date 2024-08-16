class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> sfreq = new HashMap<>();
        Map<Character, Integer> tfreq = new HashMap<>();
        char[] tarr = t.toCharArray();
        for(char ch:tarr) tfreq.put(ch, tfreq.getOrDefault(ch, 0) + 1);
        int l=0, r = 0, n = s.length(), ansL = -1, ansR = -1, max = (int)1e7, valid = 0, need = tfreq.size();
        char[] sarr = s.toCharArray();
        while(r<n) {
            char ch = sarr[r];
            sfreq.put(ch, sfreq.getOrDefault(ch, 0) + 1);
            if(tfreq.containsKey(ch) && sfreq.get(ch).equals(tfreq.get(ch))) valid++;
            while(valid == need) {
                if(max > r-l+1) {
                    max = r-l+1;
                    ansL = l;
                    ansR = r;
                }
                int val = sfreq.get(sarr[l]);
                if(tfreq.containsKey(sarr[l]) && val == tfreq.get(sarr[l])) valid--;
                sfreq.put(sarr[l], val-1);
                l++;
            }
            r++;
        }
        if(ansL == -1) return "";
        return s.substring(ansL, ansR+1);
    }
}