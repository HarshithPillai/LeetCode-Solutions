class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> s = new HashSet<>();
        int ans = words.length;
        char[] all = allowed.toCharArray();
        for(char ch:all) s.add(ch);
        for(String word:words) {
            for(char ch:word.toCharArray()) {
                if(!s.contains(ch)) {
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}