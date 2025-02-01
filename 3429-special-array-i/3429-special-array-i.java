class Solution {
    public boolean isArraySpecial(int[] nums) {
        int val = nums[0]%2;
        for(int i:nums) {
            if(i%2 != val) return false;
            val ^= 1;
        }
        return true;
    }
}