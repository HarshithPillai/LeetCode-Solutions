class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] < 0 || nums[i] > n) nums[i] = 0;
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                if(nums[nums[i]-1] == 0) nums[nums[i]-1] = -(int)1e6;
                else if(nums[nums[i]-1] > 0) nums[nums[i]-1] *= -1;
            } else if(nums[i] < 0 && nums[i] > -(int)1e6) {
                int ind = -nums[i];
                if(ind > 0) {
                    if(nums[ind-1] == 0) nums[ind-1] = -(int)1e6;
                    else if(nums[ind-1] > 0) nums[ind-1] *= -1;
                }
            }
        }

        for(int i=0; i<n; i++) {
            if(nums[i] >= 0) return i+1;
        }

        return n+1;
    }
}