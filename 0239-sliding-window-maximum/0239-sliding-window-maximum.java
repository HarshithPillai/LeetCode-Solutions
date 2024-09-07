class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        /**
            keep decreasing monotonic doubly ended queue, but store only the indices

        */
        int[] ans = new int[nums.length-k+1];
        int ind=0;
        for(int i=0; i<nums.length; i++) {
            // keep removing indices from the last of queue, which are smaller/equal to current value
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.removeLast();
            // keep removing indices from the front of queue which are before(and outside) the window
            while(!dq.isEmpty() && dq.peekFirst() <= i-k) dq.removeFirst();
            // if current index is more than/equal to k-1 that means
            // there are enough values before this index to consider this the end of a window
            if(i>=k-1) {
                // if no values in deque, use this as the window max
                if(dq.isEmpty()) ans[ind] = nums[i];
                // compare current value with the maximum in the front of deque
                else ans[ind] = Math.max(nums[i], nums[dq.peekFirst()]);
                ind++;
            }
            dq.addLast(i);
        }
        return ans;
    }
}