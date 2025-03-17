class Solution {
    // from accepted pool
    public boolean containsDuplicate(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < min || num > max) {
                min = Math.min(num, min);
                max = Math.max(num, max);
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}