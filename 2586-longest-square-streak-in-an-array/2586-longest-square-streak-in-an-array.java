class Solution {
    int n;
    Integer[] dp;
    public int lowerbound(int[] nums, int val, int ind) {
        int l = ind+1, r = n-1;
        while(l<=r) {
            int mid = l+(r-l)/2;
            if(nums[mid] >= val) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return l;
    }
    public int helper(int[] nums, int ind) {
        if(ind == n) return 0;
        if(dp[ind] != null) return dp[ind];
        int square = nums[ind]*nums[ind];
        int res = 0, next = lowerbound(nums, square, ind);
        if(next == n) return 0;
        if(next < n && nums[next] == square) res = Math.max(res, 1+helper(nums, next));
        return dp[ind] = res;
    }
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        n = nums.length;
        dp = new Integer[n+1];
        int res = 0;
        for(int i=0; i<n-1; i++) {
            res = Math.max(res, 1 + helper(nums, i));
        }
        if(res < 2) return -1;
        return res;
    }
}