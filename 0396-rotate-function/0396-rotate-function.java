class Solution {
    public int maxRotateFunction(int[] nums) {
        /**
            use dp to get the optimal position for '0'
            https://www.youtube.com/watch?v=Die0sok3WTM
            
            sum = sum of all elements

            f[0] = 0 * nums[1] + 1 * nums[2] + .... + (n-2) * nums[n-1] + (n-1) * nums[0]
            f[1] = 0 * nums[0] + 1 * nums[1] + .... + (n-1) * nums[n-1]
            f[1] - f[0] = nums[1] + nums[2] + nums[3] + ... + nums[n-1] - (n-1) * nums[0]
            f[1] - f[0] = sum - n * nums[n-1]
            f[1] = f[0] + sum - n * nums[n-1]
            f[2] = f[1] + sum - n * nums[n-2]
            f[3] = f[2] + sum - n * nums[n-3]
            .
            .
            .
            f[n-1] = f[n-2] + sum - n * nums[0];

            return the max of all the f(x)
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