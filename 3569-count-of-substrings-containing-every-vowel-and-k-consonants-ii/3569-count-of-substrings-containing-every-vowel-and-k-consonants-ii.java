class Solution {
    public long helper(String word, int k) {
        /**
            k is non-negative integer 'k'
            return total number of substrings of word that contain every vowel
            at least once and exactly k consonents
        */

        char[] arr = word.toCharArray();
        int n = arr.length, l = 0, r = 0, vowels = 0, consonents = 0;
        long ans = 0;
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        Map<Character, Integer> map = new HashMap<>();
        while (r < n) {
            char ch = arr[r];
            if (set.contains(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            } else {
                consonents++;
            }

            while (map.size() == 5 && consonents >= k) {
                char left = arr[l];
                ans += n-r;
                
                if (set.contains(left)) {
                    int count = map.get(left);
                    if (count == 1) map.remove(left);
                    else map.put(left, count-1);
                } else {
                    consonents--;
                }
                l++;
            }

            r++;
        }
        return ans;
    }
    public long countOfSubstrings(String word, int k) {
        return helper(word, k) - helper(word, k+1);
    }
}