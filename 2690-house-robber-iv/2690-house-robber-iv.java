class Solution {
    int n;
    public boolean helper(int[] nums, int k, int mid) {
        for (int i = 0; i < n; i++) {
            if (nums[i] <= mid) {
                k--;
                i++;
            }
        }
        return k <= 0;
    }

    public int minCapability(int[] nums, int k) {
        int l = nums[0], r = nums[0];
        n = nums.length;
        for (int num : nums) {
            l = Math.min(l, num);
            r = Math.max(r, num);
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (helper(nums, k, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}