class Solution {
    public boolean canJump(int[] nums) {
        /**
            2, 3, 1, 1, 4
        */
        int max = 0, n = nums.length;
        for(int i=0; i<n; i++) {
            if(max<i) return false;
            max = Math.max(max, i+nums[i]);
        }
        return max>=n-1;
    }
}