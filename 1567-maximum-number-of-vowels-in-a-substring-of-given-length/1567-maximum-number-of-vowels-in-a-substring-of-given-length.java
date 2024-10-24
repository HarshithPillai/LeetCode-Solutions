class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowel = Set.of('a', 'e', 'i', 'o', 'u');
        char[] arr = s.toCharArray();
        int n = s.length(), l = 0, r = 0, max = 0, curr = 0;
        while(r<n) {
            if(vowel.contains(arr[r])) curr++;
            if(r-l+1 > k) {
                if(vowel.contains(arr[l])) curr--;
                l++;
            }
            if(r-l+1 == k) max = Math.max(max, curr);
            r++;
        }
        return max;
    }
}