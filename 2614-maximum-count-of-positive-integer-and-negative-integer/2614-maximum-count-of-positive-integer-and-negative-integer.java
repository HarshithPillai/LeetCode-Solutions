class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length, l = 0, h = n - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] >= 0) h = mid - 1;
            else l = mid + 1;
        }
        int neg = l;
        l = 0;
        h = n - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] <= 0) l = mid + 1;
            else h = mid - 1;
        }
        return Math.max(neg, n - h - 1);
    }
}