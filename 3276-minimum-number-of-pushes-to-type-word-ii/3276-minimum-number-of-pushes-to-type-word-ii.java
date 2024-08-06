class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        char[] arr = word.toCharArray();
        for(char ch:arr) {
            freq[ch-'a']++;
        }
        int ans = 0;
        Arrays.sort(freq);
        for(int i=25; i>=0; i--) {
            int level = (25-i)/8;
            ans+=freq[i]*(level+1);
        }
        return ans;
    }
}