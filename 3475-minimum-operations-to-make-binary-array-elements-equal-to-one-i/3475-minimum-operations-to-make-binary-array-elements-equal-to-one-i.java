class Solution {
    public int minOperations(int[] nums) {
        /**
            3 consecutive elements from the array get flipped
            all must by set bit '1'
        */
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (i >= n - 2) return -1;
                for (int j = 0; j < 3; j++) nums[i + j] ^= 1;
                ans++;
            }
        }
        return ans;
    }
}