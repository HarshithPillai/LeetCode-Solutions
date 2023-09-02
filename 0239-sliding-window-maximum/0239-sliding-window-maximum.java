class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        int n=nums.length;
        for(int i=0; i<k; i++) {
            while(!dq.isEmpty() && nums[dq.getLast()]<nums[i]) 
                dq.removeLast();
            dq.addLast(i);
        }
        int[] ans=new int[n-k+1];
        ans[0]=nums[dq.getFirst()];
        for(int i=k; i<n; i++) {
            if(dq.getFirst()==i-k)dq.removeFirst();
            while(!dq.isEmpty() && nums[dq.getLast()]<nums[i]) 
                dq.removeLast();
            dq.addLast(i);
            ans[i-k+1]=nums[dq.getFirst()];
        }
        return ans;
    }
}