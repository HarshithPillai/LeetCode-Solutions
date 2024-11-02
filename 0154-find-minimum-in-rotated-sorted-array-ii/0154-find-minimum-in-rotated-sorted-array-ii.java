class Solution {
    public int findMin(int[] nums) {
        int min = (int)1e9;
        for(int i:nums) {
            min = Math.min(min, i);
        }
        return min;
    }
}