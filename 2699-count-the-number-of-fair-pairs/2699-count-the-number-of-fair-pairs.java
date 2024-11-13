class Solution {
    public long search(int[] nums, int lower, int upper, int left, int right) {
        int l = left, r = right;
        while(l<=r) {
            int mid = l + (r-l)/2, sum = nums[mid] + nums[left-1];
            if((sum <= upper && sum >= lower) || (sum > upper)) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        if(l > right) return 0;
        int sum = nums[l] + nums[left-1];
        if(sum > upper || sum < lower) return 0;
        int minInd = l;
        l = left;
        r = right;
        while(l<=r) {
            int mid = l + (r-l)/2, curr = nums[mid] + nums[left-1];
            if(curr < lower || (curr >= lower && curr <= upper)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if(r < left) return 0;
        sum = nums[r] + nums[left-1];
        if(sum > upper || sum < lower) return 0;
        return r-minInd+1;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n-1; i++) {
            ans += search(nums, lower, upper, i+1, n-1);
        }
        return ans;
    }
}