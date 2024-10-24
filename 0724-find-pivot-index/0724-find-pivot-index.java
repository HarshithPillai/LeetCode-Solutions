class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length, sum = 0;
        int[] prefix = new int[n];
        for(int i=0; i<n; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }
        for(int i=0; i<n; i++) {
            int left = prefix[i] - nums[i];
            int right = sum - prefix[i];
            if(left == right) return i;
        }
        return -1;
    }
}