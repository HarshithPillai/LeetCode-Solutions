class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int[] ans = new int[n1];
        int[] temp = new int[n2];
        //keep a stack and hashmap
        //iterate through each int in nums2 from end to start
        //for each element see what is at top of stack
        // if empty add -1 to that number in map
        // if top<nums2[i], keep on popping till you get a number 
        // greater than this. or till stack is empty
        // then add that number to map <nums2[i], number> and to stack.

        Stack<Integer> stack = new Stack<>();
        for(int i=n2-1; i>=0; i--) {
            temp[i]=-1;
            while(!stack.isEmpty() && stack.peek()<=nums2[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                temp[i] = stack.peek();
            }
            stack.push(nums2[i]);
        }
        for(int ind=0; ind<n1; ind++) {
            for(int i=0; i<n2; i++) {
                if(nums1[ind]==nums2[i]) {
                    ans[ind]=temp[i];
                }
            }
        }
        
        return ans;
    }
}