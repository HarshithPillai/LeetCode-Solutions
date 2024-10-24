class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = -1e9, sum = 0, K = k;
        int l = 0, r = 0, n = nums.length;
        while(r<n) {
            sum += nums[r];
            if(r-l+1 > k) {
                sum -= nums[l];
                l++;
            }
            if(r-l+1 == k) max = Math.max(max, sum/K);
            r++;
        }
        return max;
    }
}