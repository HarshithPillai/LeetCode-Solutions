class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length, curr = 0, next = 0;
        for (int i=0; i<n-1; i++) {
            if (nums[i] == nums[i+1]) {
                nums[i+1] = 0;
                nums[i] *= 2;
            }
        }
        for(; next < n; next++) {
            if (nums[next] != 0) {
                int val = nums[next];
                nums[next] = 0;
                nums[curr] = val;
                curr++;
            }
        }
        return nums;
    }
}