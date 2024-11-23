class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length, m = box[0].length;
        char[][] ans = new char[m][n];
        for(char[] arr:ans) Arrays.fill(arr, '.');
        for(int i=0; i<n; i++) {
            int ind = m-1;
            for(int j = m-1; j>=0; j--) {
                if(box[i][j] == '*') {
                    ind = j-1;
                    ans[j][n-i-1] = '*';
                } else if(box[i][j] == '#') {
                    ans[ind][n-i-1] = '#';
                    ind--;
                }
            }
        }
        return ans;
    }
}