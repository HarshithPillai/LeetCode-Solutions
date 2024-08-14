class Solution {
    public int helper(int[] nums, int mid) {
        int l=0, r = 1;
        int count = 0;
        while(r<nums.length) {
            while(nums[r]-nums[l] > mid) {
                l++;
            }
            count+=r-l;
            r++;
        }
        return count;
    }
    public int smallestDistancePair(int[] nums, int k) {
        /** 
            helper function:
                check the pairs and calculate the total pairs that have a diff <= mid
            
            binary search in the search space of answers
        */
        int l=0, h=(int)1e6;
        Arrays.sort(nums);
        while(l<=h) {
            int mid = l+(h-l)/2;
            int count = helper(nums, mid);
            if(count >= k) {
                // total number of pairs with diff <= mid is more than or equal to k
                // this could be a possible answer
                // we need to minimize mid
                // how do we minimize mid?
                // go left
                h = mid-1;
            } else {
                l = mid+1;
            }
        }
        return l;
    }
}