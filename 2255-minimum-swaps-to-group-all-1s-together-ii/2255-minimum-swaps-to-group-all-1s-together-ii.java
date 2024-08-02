class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0, n = nums.length;
        for(int v:nums) ones+=v;
        if(ones == 0) return 0;
        int l = 0, r = 0;
        int zeros = 0;
        
        int min = (int)1e6;
        for(; r<2*n; r++) {
            if(nums[r%n]==0) zeros++;
            if(r-l+1>ones) {
                if(nums[l%n] == 0) zeros--;
                l++;
            }
            if(r-l+1 == ones) min = Math.min(min, zeros);
        }
        return min;
    }
}