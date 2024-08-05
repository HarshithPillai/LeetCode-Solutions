class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for(String s:arr) freq.put(s, freq.getOrDefault(s, 0) + 1);
        int ind = 1;
        for(String s:arr) {
            if(freq.get(s) == 1) {
                if(ind == k) return s;
                ind++;
            }
        }
        return "";
    }
}