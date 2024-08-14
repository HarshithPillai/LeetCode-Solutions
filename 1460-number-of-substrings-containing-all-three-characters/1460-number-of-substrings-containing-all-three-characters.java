class Solution {
    public int numberOfSubstrings(String s) {
        int l=0, r=0, n = s.length(), count = 0;
        char[] arr = s.toCharArray();
        Map<Character, Integer> freq = new HashMap<>();
        while(r<n) {
            char ch = arr[r];
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            while(freq.size() == 3) {
                count += n-r;
                int val = freq.get(arr[l]);
                if(val == 1) {
                    freq.remove(arr[l]);
                } else {
                    freq.put(arr[l], val-1);
                }
                l++;
            }
            r++;
        }
        return count;
    }
}