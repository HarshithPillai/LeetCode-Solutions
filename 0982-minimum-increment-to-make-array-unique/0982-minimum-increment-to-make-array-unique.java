class Solution {
    public int minIncrementForUnique(int[] nums) {
        /**
            1 1 2 2 3 7
            1 2 3 4 5 7
        */
        Arrays.sort(nums);
        int ans = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] <= nums[i-1]) {
                ans += nums[i-1] - nums[i] + 1;
                nums[i] = nums[i-1] + 1;
            }
        }
        return ans;
    }
}