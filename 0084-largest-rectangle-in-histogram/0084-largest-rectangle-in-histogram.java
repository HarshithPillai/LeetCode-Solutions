class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length; int max=0;
        int[] left =new int[n];
        int[] right=new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++) {// left smaller index
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]) stack.pop();
            if(stack.isEmpty()) left[i]=0;
            else {
                left[i]=stack.peek()+1;
            }
            stack.push(i);
        }
        stack = new Stack<>();

        for(int i=n-1; i>=0; i--) {// right smaller index
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]) stack.pop();
            if(stack.isEmpty()) right[i]=n-1;
            else {
                right[i]=stack.peek()-1;
            }
            stack.push(i);
        }

        for(int i=0; i<n; i++) {
            int size = heights[i]*(right[i]-left[i]+1);
            if(size>max)max=size;
        }
        return max;
    }
}