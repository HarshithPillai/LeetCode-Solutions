class Solution {
    public int[] searchRange(int[] nums, int target) {
        int f = -1, s = -1, l = 0, h = nums.length-1;
        // lower_bound
        while(l<=h) {
            int m = (l+h)/2;
            if(nums[m]==target) {
                f = m;
                h=m-1;
            } else if(nums[m] > target) {
                h=m-1;
            } else l = m+1;
        }
        
        l=0; h=nums.length-1;

        while(l<=h) {
            int m = (l+h)/2;
            if(nums[m]==target) {
                s = m;
                l = m+1;
            } else if(nums[m]<target) {
                l = m+1;
            } else h = m-1;
        }

        return new int[]{f,s};
    }
}