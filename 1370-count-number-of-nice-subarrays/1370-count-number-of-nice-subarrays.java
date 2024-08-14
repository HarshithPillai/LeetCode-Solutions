class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count=0, l=0, r=0, n = nums.length, ans = 0;
        int nextOdd[] = new int[n];
        int lastOdd = n;
        for(int i=n-1; i>=0; i--) {
            nextOdd[i] = lastOdd;
            if(nums[i] %2 == 1) lastOdd = i;
        }
        while(r<n) {
            count += nums[r] % 2;
            while(count > k) {
                count -= nums[l] % 2;
                l++;
            }
            while(count == k && l<=r) {
                ans += nextOdd[r] - r;
                count -= nums[l] % 2;
                l++;
            }
            r++;
        }
        return ans;
    }
}