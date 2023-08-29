class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n=nums.length;
        int[] ans = new int[n];
        for(int i=2*n-1; i>=0; i--) {
            int ind=i%n;
            ans[ind]=-1;
            while(!stack.isEmpty() && stack.peek()<=nums[ind]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                ans[ind]=stack.peek();
            }
            stack.push(nums[ind]);
        }
        return ans;
    }
}