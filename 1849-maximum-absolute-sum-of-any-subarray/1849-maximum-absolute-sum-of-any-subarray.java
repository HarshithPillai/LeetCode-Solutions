class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int pos = 0, neg = 0, max = 0, n = nums.length;
        for(int i : nums) {
            neg += i;
            pos += i;
            max = Math.max(max, Math.max(pos, Math.abs(neg)));
            if (neg > 0) neg = 0;
            if (pos < 0) pos = 0;
        }
        return max;
    }
}