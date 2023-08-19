class Solution {
    public int majorityElement(int[] nums) {
        int max=0, maxVal=nums[0];
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==maxVal) {
                max++;
            } else max--;
            if(max==0) {
                maxVal=nums[i+1];
            }
        }

        return maxVal;
    }
}