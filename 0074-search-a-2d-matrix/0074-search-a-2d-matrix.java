class Solution {

    public int searchI(int[][] matrix, int target, int s, int e) {
        if(s>e) {
            return -1;
        }
        int mid=(s+e)/2;
        int sizeJ=matrix[0].length;
        if(matrix[mid][0]<=target && target<=matrix[mid][sizeJ-1]) {
            return mid;
        }
        if(target<matrix[mid][0]) return searchI(matrix, target, s, mid-1);
        else return searchI(matrix, target, mid+1, e);
    }

    public boolean searchJ(int[][] matrix, int target, int i, int s, int e) {
        if(s>e) return false;
        int mid = (s+e)/2;
        if(matrix[i][mid]==target) return true;
        if(matrix[i][mid]<target) 
            return searchJ(matrix, target, i, mid+1, e);
        else return searchJ(matrix, target, i, s, mid-1);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        //find correct i
        // if not found return -1
        // else find correct j
        // if not found return false
        // else return true
        int sizeI=matrix.length;
        int i=-1;
        i = searchI(matrix, target, 0, sizeI-1);
        if(i==-1) return false;
        int sizeJ=matrix[0].length;
        return searchJ(matrix, target, i, 0, sizeJ-1);
        
    }
}