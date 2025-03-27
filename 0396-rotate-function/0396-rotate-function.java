class Solution {
    public int maxRotateFunction(int[] nums) {
        /**
            use dp to get the optimal position for '0'
        */

        int f = 0, sum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i];
        }

        int max = f;
        for (int i = 1; i < n; i++) {
            f = f + sum - n * nums[n - i];
            max = Math.max(f, max);
        }

        return max;
    }
}