class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        List<String> res = new ArrayList<>();
        String[] arr1 = s1.split(" ");
        for(String a:arr1) map1.put(a, map1.getOrDefault(a, 0) + 1);
        String[] arr2 = s2.split(" ");
        for(String a:arr2) map2.put(a, map2.getOrDefault(a, 0) + 1);
        for(Map.Entry<String, Integer> entry : map1.entrySet()) {
            if(entry.getValue() == 1 && !map2.containsKey(entry.getKey())) {
                res.add(entry.getKey());
            }
        }
        for(Map.Entry<String, Integer> entry : map2.entrySet()) {
            if(entry.getValue() == 1 && !map1.containsKey(entry.getKey())) {
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