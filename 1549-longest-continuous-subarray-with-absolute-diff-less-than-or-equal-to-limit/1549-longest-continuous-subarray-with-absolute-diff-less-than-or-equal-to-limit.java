class Solution {
    public int longestSubarray(int[] nums, int limit) {
        /**
            keep a frequency map in form of treemap
            keep track of first and last entries in the map
            while the entries's difference is more than limit,
            keep on reducing the window and once an entry's frequency reaches 0 remove it
        */
        Deque<int[]> min = new LinkedList<>(), max = new LinkedList<>();
        int l=0, r=0, ans=0, n=nums.length;
        while(r<n) {
            while(!min.isEmpty() && min.peekLast()[0] > nums[r]) min.pollLast();
            while(!max.isEmpty() && max.peekLast()[0] < nums[r]) max.pollLast();
            min.addLast(new int[]{nums[r], r});
            max.addLast(new int[]{nums[r], r});
            int diff = max.peekFirst()[0] - min.peekFirst()[0];
            while(l<r && diff>limit) {
                l = Math.min(max.peekFirst()[1], min.peekFirst()[1]) +1;
                while(!max.isEmpty() && max.peekFirst()[1]<l) max.pollFirst();
                while(!min.isEmpty() && min.peekFirst()[1]<l) min.pollFirst();
                diff = max.peekFirst()[0] - min.peekFirst()[0];
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}