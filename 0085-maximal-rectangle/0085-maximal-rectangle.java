class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max=0;
        int r=matrix.length;
        int c=matrix[0].length;
        int[] histogram = new int[c];
        
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(matrix[i][j]=='1') histogram[j]++;
                else histogram[j]=0;
            }
            

            int[] left  = new int[c];
            int[] right = new int[c];
            Stack<Integer> stack = new Stack<>();
            
            for(int j=0; j<c; j++) {
                while(!stack.isEmpty() && histogram[stack.peek()]>=histogram[j]) stack.pop();
                if(stack.isEmpty()) left[j]=0;
                else left[j] = stack.peek()+1;
                stack.push(j);
            }
            stack=new Stack<>();
            for(int j=c-1; j>=0; j--) {
                while(!stack.isEmpty() && histogram[stack.peek()]>=histogram[j]) stack.pop();
                if(stack.isEmpty()) right[j]=c-1;
                else right[j] = stack.peek()-1;
                stack.push(j);
                max = Math.max(max, (right[j]-left[j]+1)*histogram[j]);
            }
        }
        return max;
    }
}