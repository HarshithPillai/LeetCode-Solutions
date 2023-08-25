class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int[] ans = new int[n1];
        for(int i=0; i<n1; i++) {
            int j=nums2.length-1;
            ans[i]=-1;
            int g=-1;
            while(j>=0 && nums2[j]!=nums1[i]) {
                if(nums2[j]>nums1[i]) {
                    g=nums2[j];
                }
                j--;
            }
            ans[i]=g;
        }
        return ans;
    }
}