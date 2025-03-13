class Solution {
    public boolean helper(int[] nums, int n, int[][] queries, int mid) {
        int[] diff = new int[n+1];
        for (int i = 0; i < mid; i++) {
            int l = queries[i][0], r = queries[i][1], val = queries[i][2];
            diff[r + 1] -= val;
            diff[l] += val;
        }
        int curr = 0;
        for (int i = n; i > 0; i--) {
            curr += diff[i];
            if (nums[i-1] > -curr) return false;
        }
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        /**
            nums of length n
            queries[i] = [l, r, val]

            decrement the value of each index in the range [l, r] by val

            amount by which each value is decremented can be chosen independently for each index

        */

        int n = nums.length, l = 0, r = queries.length;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (helper(nums, n, queries, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (l > queries.length) return -1;
        return l;
    }
}