class Solution {
    public int minOperations(int[] nums, int k) {
        int count = 0, xor = 0;
        for(int num:nums) xor ^= num;
        for(int i=0; i<31; i++) {
            int mask = 1<<i;
            if((mask & xor) != (mask & k)) count++;
        }
        return count;
    }
}