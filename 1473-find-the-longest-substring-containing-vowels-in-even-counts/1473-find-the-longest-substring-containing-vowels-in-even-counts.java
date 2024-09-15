class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 1);
        map.put('i', 2);
        map.put('o', 3);
        map.put('u', 4);
        int[] firstOccurrence = new int[32];
        Arrays.fill(firstOccurrence, -1);
        char[] arr = s.toCharArray();
        int max = 0, n = arr.length, state = 0;
        for(int i=0; i<n; i++) {
            char ch = arr[i];
            if(map.containsKey(ch)) {
                state = state ^ (1<<map.get(ch));
                if(state!=0 && firstOccurrence[state] == -1) {
                    firstOccurrence[state] = i;
                }
            }
            max = Math.max(max, i-firstOccurrence[state]);
        }
        return max;
    }
}