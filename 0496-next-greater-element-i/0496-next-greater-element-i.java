class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int[] ans = new int[n1];
        //keep a stack and hashmap
        //iterate through each int in nums2 from end to start
        //for each element see what is at top of stack
        // if empty add -1 to that number in map
        // if top<nums2[i]c, keep on popping till you get a number 
        // greater than this. or till stack is empty
        // then add that number to map <nums2[i]=number> and to stack.

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=nums2.length-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek()<=nums2[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i],stack.peek());
            }
            stack.push(nums2[i]);
        }
        int i=0;
        for(int num:nums1) {
            ans[i++] = map.get(num);
        }
        return ans;
    }
}