class Solution {
    public boolean check(int[] nums) {
        int countDrop = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] < nums[i-1]) countDrop++;
        }
        if(countDrop == 1) return nums[0] >= nums[nums.length-1];
        return countDrop == 0;
    }
}