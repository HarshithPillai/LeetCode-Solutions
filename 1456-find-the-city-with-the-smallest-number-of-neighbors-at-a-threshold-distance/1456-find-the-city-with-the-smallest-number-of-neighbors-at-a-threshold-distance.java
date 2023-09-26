class Solution {
    public int findTheCity(int n, int[][] edges, int tar) {
        int[][] matrix = new int[n][n];
        int m = edges.length;
        for(int i[]:matrix) Arrays.fill(i,(int)(1e9));
        for(int i=0;i<n;i++) matrix[i][i]=0;
        for(int i=0; i<m; i++) {
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            matrix[u][v]=w;
            matrix[v][u]=w;
        }

        for(int via=0;via<n;via++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(matrix[i][j] > matrix[i][via] + matrix[via][j]) {
                        matrix[i][j] = matrix[i][via] + matrix[via][j];
                    }
                }
            }
        }

        int max=Integer.MAX_VALUE, res=-1;
        for(int i=0;i<n;i++) {
            int count=0;
            for(int j=0;j<n;j++) {
                if(matrix[i][j]<=tar) {
                    count++;
                }
            }
            if(count<=max) {
                max=count;
                res=i;
            }
        }
        return res;
    }
}