class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        /**
            keep decreasing monotonic doubly ended queue, but store only the indices
        */
        int[] ans = new int[nums.length-k+1];
        int ind=0;
        for(int i=0; i<nums.length; i++) {
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.removeLast();
            while(!dq.isEmpty() && dq.peekFirst() <= i-k) dq.removeFirst();
            if(i>=k-1) {
                if(dq.isEmpty()) ans[ind] = nums[i];
                else ans[ind] = Math.max(nums[i], nums[dq.peekFirst()]);
                ind++;
            }
            dq.addLast(i);
        }
        return ans;
    }
}