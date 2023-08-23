class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++) {
            pq.add(nums[i]);
        }
        //k=n-k+1;//
        int ans=-1;
        for(int i=0; i<k; i++) {
            ans=pq.poll();
        }
        return ans;
    }
}