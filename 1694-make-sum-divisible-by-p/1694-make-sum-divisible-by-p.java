class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for(int i:nums) sum+=i;
        int n = nums.length, ans = n;
        long remainder = sum%p;
        if(remainder == 0) return 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        sum = 0;
        for(int i=0; i<n; i++) {
            sum+=nums[i];
            if(map.containsKey((sum-remainder)%p)) {
                ans = Math.min(ans, i-map.get((sum-remainder)%p));
            }
            map.put(sum%p, i);
        }
        if(ans==n) return -1;
        return ans;
    }
}