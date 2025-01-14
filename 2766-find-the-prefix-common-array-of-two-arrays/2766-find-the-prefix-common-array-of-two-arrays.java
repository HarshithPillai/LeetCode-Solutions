class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n], seta = new int[n+1], setb = new int[n+1];
        for(int i=0; i<n; i++) {
            seta[A[i]]++;
            setb[B[i]]++;
            int count = 0;
            for(int j = 0; j<=n; j++) {
                if(seta[j] > 0 && setb[j] > 0) count++;
            }
            ans[i] = count;
        }
        return ans;
    }
}