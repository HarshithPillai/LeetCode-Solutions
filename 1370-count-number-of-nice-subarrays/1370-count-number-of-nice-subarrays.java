class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0;
        int[] nextOdd = new int[n];
        int lastOdd = n, ans = 0, count = 0;
        for(int i=n-1; i>=0; i--) {
            nextOdd[i] = lastOdd;
            if(nums[i]%2==1) lastOdd = i;
        }

        while(r<n) {
            count += nums[r]%2;
            while(count>=k) {
                if(count==k) ans += nextOdd[r] - r;
                count -= nums[l]%2;
                l++;
            }
            r++;
        }
        return ans;
    }
}