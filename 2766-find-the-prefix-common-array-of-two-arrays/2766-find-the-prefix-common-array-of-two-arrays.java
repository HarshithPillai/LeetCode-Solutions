class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> seta = new HashSet<>(), setb = new HashSet<>();
        int n = A.length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            seta.add(A[i]);
            setb.add(B[i]);
            int count = 0;
            for(int val:seta) {
                if(setb.contains(val)) count++;
            }
            ans[i] = count;
        }
        return ans;
    }
}