class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length, l = 0, r = 0, ans = 0;
        int[] nextOne = new int[n];
        int lastOne = n;

        for(int i=n-1; i>=0; i--) {
            nextOne[i] = lastOne;
            if(nums[i] == 1) lastOne = i;
        }
        int sum=0;
        while(r<n) {
            sum+=nums[r];
            while(sum>goal) {
                sum-=nums[l];
                l++;
            }
            while(l<=r && sum ==  goal) {
                ans += nextOne[r] - r;
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return ans;
    }
}