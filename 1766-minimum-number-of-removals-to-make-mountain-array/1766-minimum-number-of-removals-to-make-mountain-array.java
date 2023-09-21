class Solution {
    public int minimumMountainRemovals(int[] arr) {
        int n=arr.length;
        int[] lis = new int[n];
        int[] lds = new int[n];
        for(int i=0;i<n;i++) {
            lis[i]=1;
            for(int j=0;j<i;j++) {
                if(arr[i]>arr[j] && lis[i]<1+lis[j]) {
                    lis[i] = 1+lis[j];
                }
            }
        }
        for(int i=n-1;i>=0;i--) {
            lds[i]=1;
            for(int j=n-1;j>i;j--) {
                if(arr[i]>arr[j] && lds[i]<1+lds[j]) {
                    lds[i] = 1 + lds[j];
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++) {
            // because if 1 means the slope starts from there,
            // we need a point which already has 1 or more element before it
            if(lds[i]>1 && lis[i]>1) max=Math.max(max,lis[i]+lds[i]-1);
        }
        return n-max;
    }
}