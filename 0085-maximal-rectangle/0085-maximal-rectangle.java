class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[] histogram = new int[c];
        int max=0;
        for(int i=0; i<r; i++) {
            Stack<Integer> stack = new Stack<>();
            int[] prev_smaller = new int[c];
            int[] next_smaller = new int[c];
            for(int j=0;j<c;j++) {
                if(matrix[i][j]=='1') {
                    histogram[j]++;
                } else {
                    histogram[j]=0;
                }
                while(!stack.isEmpty() && histogram[stack.peek()]>=histogram[j]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    prev_smaller[j] = -1;
                } else {
                    prev_smaller[j] = stack.peek();
                }
                stack.push(j);
            }
            stack = new Stack<>();
            for(int j=c-1;j>=0;j--) {
                while(!stack.isEmpty() && histogram[stack.peek()]>=histogram[j]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    next_smaller[j] = c;
                } else {
                    next_smaller[j] = stack.peek();
                }
                stack.push(j);

                max=Math.max(max, histogram[j]*(next_smaller[j]-prev_smaller[j]-1));
            }
        }
        return max;
    }
}