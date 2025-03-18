class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l = 0, r = 0, n = nums.length, ans = 1;
        int[] bits = new int[32];

        while (r < n) {
            int val = nums[r], extra = 0;
            for (int i = 0; i < 32; i++) {
                if ((val & (1 << i)) != 0) {
                    bits[i]++;
                    if (bits[i] > 1) extra++;
                }
            }

            // Fix: Keep removing elements from left until extra becomes 0
            while (extra > 0) {
                int left = nums[l];
                for (int i = 0; i < 32; i++) {
                    if ((left & (1 << i)) != 0) {
                        bits[i]--;
                        if (bits[i] == 1) extra--; // Fix: Only decrease `extra` when a bit count drops to 1
                    }
                }
                l++;
            }

            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
