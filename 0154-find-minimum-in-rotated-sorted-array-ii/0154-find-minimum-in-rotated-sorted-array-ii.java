class Solution {
    public int findMin(int[] nums) {
        int n = nums.length, l = 0, r = n-1;
        while(l<=r) {
            while(l<r && nums[l] == nums[l+1]) l++;
            while(l<r && nums[r] == nums[r-1]) r--;
            if(l==r || nums[l] < nums[r]) return nums[l];
            int mid = l+(r-l)/2;
            if(nums[l] >= nums[mid] && nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }
}