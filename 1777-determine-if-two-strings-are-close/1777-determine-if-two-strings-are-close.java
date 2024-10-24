class Solution {
    public boolean closeStrings(String word1, String word2) {
        char[] a = word1.toCharArray(), b = word2.toCharArray();
        int[] freq1 = new int[26], freq2 = new int[26];
        Set<Character> s = new HashSet<>();
        for(char ch:a) {
            freq1[ch-'a']++;
            s.add(ch);
        }
        for(char ch:b) {
            if(!s.contains(ch)) return false;
            freq2[ch-'a']++;
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for(int i=0; i<26; i++) {
            if(freq1[i] != freq2[i]) return false;
        }

        return true;
    }
}