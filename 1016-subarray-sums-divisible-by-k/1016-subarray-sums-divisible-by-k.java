class Solution {
    /**
        0   2
        2   2

    */
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ans = 0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            int remainder = sum%k;
            if(remainder<0) remainder+=k;
            if(map.containsKey(remainder)) {
                int val = map.get(remainder);
                ans += val;
                map.put(remainder, val+1);
            } else {
                map.put(remainder, 1);
            }
        }
        return ans;
    }
}