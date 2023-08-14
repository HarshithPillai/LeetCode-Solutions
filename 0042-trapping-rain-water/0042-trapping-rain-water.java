class Solution {
    public int trap(int[] height) {
        int n=height.length;
        if(n<3) return 0;
        int[] right = new int[n];
        int[] left = new int[n];

        int max=-1;
        for(int i=0; i<n; i++) {
            max=Math.max(max, height[i]);
            right[i]=max;
        }
        max=-1;
        for(int i=n-1; i>=0; i--) {
            max=Math.max(max, height[i]);
            left[i]=max;
        }
        int result=0;
        for(int i=0;i<n;i++) {
            result+=Math.min(right[i], left[i])-height[i];
        }
        return result;
    }
}