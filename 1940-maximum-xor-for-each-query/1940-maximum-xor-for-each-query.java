class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0, n = nums.length;
        for(int i:nums) xor ^= i;
        int ind = n-1;
        int[] ans = new int[n];
        while(ind>=0) {
            int k = 0;
            for(int i=0; i<maximumBit; i++) {
                int mask = 1<<i;
                if ((mask & xor) == 0) k |= mask;
            }
            ans[n-ind-1] = k;
            // remove the last element
            xor ^= nums[ind];
            ind--;
        }
        return ans;
    }
}