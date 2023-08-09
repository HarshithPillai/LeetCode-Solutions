class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length==0) return;
        Set<Integer> setI = new HashSet<Integer>();
        Set<Integer> setJ = new HashSet<Integer>();
        int a=matrix.length;
        int b=matrix[0].length;
        for(int i=0; i<a; i++) {
            for(int j=0; j<b; j++) {
                if(matrix[i][j]==0) {
                    setI.add(i);
                    setJ.add(j);
                }
            }
        }

        for(int i=0; i<a; i++) {
            for(int j=0; j<b; j++) {
                if(setI.contains(i)||setJ.contains(j)) {
                    matrix[i][j]=0;
                }
            }
        }

        // for(Integer i:setI) {
        //     for(int indJ=0; indJ<b; indJ++) {
        //         matrix[i][indJ] = 0;
        //     }
        // }

        // for(Integer j:setJ) {
        //     for(int indI=0; indI<a; indI++) {
        //         matrix[indI][j] = 0;
        //     }
        // }

        
    }
}