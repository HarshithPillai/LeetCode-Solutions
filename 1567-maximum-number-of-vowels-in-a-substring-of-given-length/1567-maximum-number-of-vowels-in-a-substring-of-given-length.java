class Solution {
    public int maxVowels(String s, int k) {
        boolean[] vowel = new boolean[26];
        vowel[0] = true;
        vowel[4] = true;
        vowel[8] = true;
        vowel[14] = true;
        vowel[20] = true;
        char[] arr = s.toCharArray();
        int n = s.length(), l = 0, r = 0, max = 0, curr = 0;
        while(r<n) {
            if(vowel[arr[r]-'a']) curr++;
            if(r >= k) {
                if(vowel[arr[l]-'a']) curr--;
                l++;
            }
            if(r-l+1 == k) max = Math.max(max, curr);
            r++;
        }
        return max;
    }
}