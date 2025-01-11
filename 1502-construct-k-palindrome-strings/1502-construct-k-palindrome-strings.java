class Solution {
    public boolean canConstruct(String s, int k) {
        int countOdd = 0, n = s.length();
        if (n < k) return false;

        int[] freq = new int[26];
        char[] arr = s.toCharArray();
        for(char ch : arr) {
            freq[ch - 'a']++;
        }
        for(int i = 0; i<26; i++) {
            countOdd += (freq[i] & 1);
        }
        if(countOdd > k) return false;
        return true;
    }
}