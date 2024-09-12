class Solution {
    int n;
    public int helper(int[] nums, int mid) {
        /**
            two pointer question: find pairs of number with difference less than or equal to mid
            
            
            ans += length of window - 1 (becuase here this means
                                    that all the pairs ending at 'r'
                                    are all having distance <= mid)           
        */

        int count = 0, l = 0, r = 1;
        while(r<n) {
            while(nums[r]-nums[l] > mid) {
                l++;
            }
            count += r-l;
            r++;
        }
        return count;
    }
    public int smallestDistancePair(int[] nums, int k) {
        /**
            smallest distance among all the pairs of nums[i] and nums[j]
            sort the array
            binary search on the search space of possible pairs
            and find the one which one gives the count of k pairs 
            with difference equal to or lesser than mid
        */
        Arrays.sort(nums);
        n = nums.length;
        int l = 0, h = nums[n-1]-nums[0];
        while(l<=h) {
            int mid = l + (h-l)/2;
            int count = helper(nums, mid);
            if(count >= k) {
                h = mid-1;
            } else {
                l = mid+1;
            }
        }

        return l;
    }
}