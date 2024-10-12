class Solution {
    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i:nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
            int val = entry.getKey(), freq = entry.getValue();
            if(map.containsKey(k - val)) ans += Math.min(freq,map.get(k-val));
        }
        return ans/2;
    }
}