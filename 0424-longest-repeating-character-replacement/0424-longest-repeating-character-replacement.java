class Solution {
    public int findMax(int[] freq) {
        int max = 0;
        for(int v:freq) max = Math.max(max, v);
        return max;
    }
    public int characterReplacement(String s, int k) {
        /**
            s
            change upto k characters
        */
        int l=0, r=0, n = s.length(), ans = 0, freq[] = new int[26];
        char[] arr = s.toCharArray();
        while(r<n) {
            char ch = arr[r];
            freq[ch-'A']++;
            int max = findMax(freq), len = r-l+1;
            while(len - max > k) {
                freq[arr[l]-'A']--;
                l++;
                max = findMax(freq);
                len = r-l+1;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}