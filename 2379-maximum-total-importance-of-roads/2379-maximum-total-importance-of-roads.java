class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int indegree[] = new int[n];
        for(int edge[]:roads) {
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }
        int countsort[] = new int[n];
        long val = n, ans = 0;
        for(int i=0; i<n; i++) {
            countsort[indegree[i]]++;
        }
        for(int i=n-1; i>=0; i--) {
            while(countsort[i]>0) {
                ans+=val*i;
                val--;
                countsort[i]--;
            }
        }
        return ans;
    }
}