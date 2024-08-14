class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0, zero = 0, l=0, r = 0, n = nums.length;
        while(r<n) {
            if(nums[r] == 0) zero++;
            while(zero > k) {
                if(nums[l] == 0) zero--;
                l++;
            }
            count = Math.max(count, r-l+1);
            r++;
        }
        return count;
    }
}