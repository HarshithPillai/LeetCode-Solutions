class Solution {
    public int calculateOr(int[] arr) {
        int val = 0;
        for(int i = 0; i<32; i++) {
            if(arr[i] > 0) {
                val += (1<<i);
            }
        }
        return val;
    }
    public int minimumSubarrayLength(int[] nums, int k) {
        int l = 0, r = 0, min = (int)1e7, n = nums.length, or = 0;
        int[] arr = new int[32];
        while(r < n) {
            for(int i=0; i<32; i++) {
                if((nums[r] & (1<<i)) != 0) arr[i]++;
            }
            or = calculateOr(arr);
            while(or >= k && l<=r) {
                min = Math.min(min, r-l+1);
                for(int i=0; i<32; i++) {
                    if((nums[l] & (1<<i)) != 0) arr[i]--;
                }
                l++;
                or = calculateOr(arr);
            }
            r++;
        }
        if(min == (int)1e7) return -1;
        return min;
    }
}