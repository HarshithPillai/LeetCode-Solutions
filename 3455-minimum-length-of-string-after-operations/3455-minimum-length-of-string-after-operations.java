class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        int n = s.length(), ans = 0;
        char[] arr = s.toCharArray();
        for(char ch:arr) {
            freq[ch - 'a']++;
        }
        for(int i=0; i<26; i++) {
            if (freq[i] > 1) {
                if(freq[i] % 2 == 1) {
                    ans += 1;
                } else {
                    ans += 2;
                }
            } else ans += freq[i];
        }
        return ans;
    }
}