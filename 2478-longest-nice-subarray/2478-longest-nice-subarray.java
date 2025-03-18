class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l = 0, r = 0, n = nums.length, ans = 1, curr = 0;

        while (r < n) {
            while ((nums[r] & curr) != 0) {
                curr -= nums[l];
                l++;
            }
            curr += nums[r];
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
