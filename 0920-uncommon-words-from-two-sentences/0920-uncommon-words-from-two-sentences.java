class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        String[] arr1 = s1.split(" ");
        for(String a:arr1) map.put(a, map.getOrDefault(a, 0) + 1);
        String[] arr2 = s2.split(" ");
        for(String a:arr2) map.put(a, map.getOrDefault(a, 0) + 1);
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                res.add(entry.getKey());
            }
        }
        int n = res.size();
        String[] ans = new String[n];
        for(int i=0; i<n; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}