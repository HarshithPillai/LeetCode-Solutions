class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long sum = 0, min = n;
        for(int i:nums) sum += i;
        long target = sum % p;
        if(target == 0) return 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        sum = 0;
        for(int i=0; i<n; i++) {
            sum += nums[i];
            if(map.containsKey((sum - target) % p)) {
                min = Math.min(min, i - map.get((sum - target) % p));
            }
            map.put(sum%p, i);
        }
        if((int)min == n) return -1;
        return (int)min;
    }
}