class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, n = s.length(), ans = 0;

        while (r < n) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() == 3) {
                ans += n - r;
                char left = s.charAt(l);
                int count = map.get(left);
                if (count == 1) {
                    map.remove(left);
                } else {
                    map.put(left, count - 1);
                }
                l++;
            }

            r++;
        }

        return ans;
    }
}