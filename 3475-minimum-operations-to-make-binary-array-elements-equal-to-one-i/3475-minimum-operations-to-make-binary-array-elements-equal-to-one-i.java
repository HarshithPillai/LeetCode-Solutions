class Solution {
    public int minOperations(int[] nums) {
        /**
            3 consecutive elements from the array get flipped
            all must by set bit '1'
        */
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (i >= nums.length-2) return -1;
                for (int j = 0; j < 3; j++) nums[i + j] ^= 1;
                ans++;
            }
        }
        return ans;
    }
}