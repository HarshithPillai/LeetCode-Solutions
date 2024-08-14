class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
            as the name suggests, give the length of substring with all unique characters
        */
        Set<Character> freq = new HashSet<>();
        char[] arr = s.toCharArray();
        Set<Character> invalid = new HashSet<>();
        int l = 0, r = 0, n = s.length(), ans = 0;
        while(r<n) {
            char ch = arr[r];
            while(freq.contains(ch)) {
                freq.remove(arr[l]);
                l++;
            }
            freq.add(ch);
            ans = Math.max(freq.size(), ans);
            r++;
        }
        return ans;
    }
}