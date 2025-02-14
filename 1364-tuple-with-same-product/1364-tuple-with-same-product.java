class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length, ans = 0;;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                // if (i==j) continue;
                int val = nums[i] * nums[j];
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
        }
        for(int cnt : map.values()) {
            ans += cnt * (cnt-1);
        }
        return ans*4;
    }
}