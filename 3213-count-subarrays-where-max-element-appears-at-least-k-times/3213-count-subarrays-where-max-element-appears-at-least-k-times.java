class Solution {
    public long countSubarrays(int[] nums, int k) {
        // total subarrays - count of subarrays with count of max element being less than k
        int l=0, r=0, count=0, n=nums.length;
        long max = 0, ans = 0;
        for(int i:nums) max = Math.max(max, i);
        while(r<n) {
            if(nums[r] == max) count++;
            while(count>=k) {
                if(nums[l] == max) count--;
                l++;
            }
            ans += r - l + 1;
            r++;
        }
        long N = n;
        long total = N*(N+1)/2;
        return total - ans;
    }
}