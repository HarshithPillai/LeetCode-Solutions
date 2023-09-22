class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r=matrix.length, c=matrix[0].length;
        int max=0;
        int[] row = new int[c];
        int[] prev_smaller = new int[c];
        int[] next_smaller = new int[c];
        for(int i=0;i<r;i++) {
            Stack<Integer> stack=new Stack<>();
            for(int j=0;j<c;j++) {
                if(matrix[i][j]=='1') {
                    row[j]++;
                } else {
                    row[j]=0;
                }
                while(!stack.isEmpty() && row[stack.peek()]>=row[j]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    prev_smaller[j]=-1;
                } else {
                    prev_smaller[j]=stack.peek();
                }
                stack.push(j);
            }
            stack=new Stack<>();
            for(int j=c-1;j>=0;j--) {
                while(!stack.isEmpty() && row[stack.peek()]>=row[j]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    next_smaller[j]=c;
                } else {
                    next_smaller[j]=stack.peek();
                }
                max=Math.max(max,row[j]*(next_smaller[j]-prev_smaller[j]-1));
                stack.push(j);
            }
        }
        return max;
    }
}